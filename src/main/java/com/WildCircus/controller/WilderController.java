package com.WildCircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.WildCircus.repository.WilderRepository;

@Controller
public class WilderController {
	
	@Autowired
	private WilderRepository wilderRepository;
	
	@RequestMapping("/wilder")
	public String toWilder(Model model) {
		
		model.addAttribute("wilder",wilderRepository.findAll());
		return"wilders";
	}

}
