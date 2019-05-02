package com.well.kept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.well.kept.Classroom;
import com.well.kept.User;
import com.well.kept.data.ClassroomRepository;
import com.well.kept.data.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	private final ClassroomRepository classRepo;
	private final UserRepository userRepo;
	
	@Autowired
	public DashboardController(ClassroomRepository classRepo, UserRepository userRepo) {
		this.classRepo = classRepo;
		this.userRepo = userRepo;
	}

	@GetMapping
	public String showClassrooms(Model model, 
			@AuthenticationPrincipal User user) {
				
		if(user.getClassrooms() != null && user.getClassrooms().size() > 0)
			model.addAttribute("classrooms", user.getClassrooms());
		
		model.addAttribute("newClassroom", new Classroom());
		model.addAttribute("title", "Your Classrooms");
		
		return "dashboard";
	}
	
	@PostMapping
	public String processNewClassroom(@ModelAttribute Classroom newClassroom, @AuthenticationPrincipal User user) {
		
		Classroom saved = classRepo.save(newClassroom);
		
		user.addClassroom(saved);
		
		userRepo.save(user);
		
		log.info("Creating new classroom: " + newClassroom);
		
		return "redirect:/dashboard/classroom/" + newClassroom.getId();
	}
}
