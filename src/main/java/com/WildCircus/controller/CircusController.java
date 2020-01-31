package com.WildCircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.WildCircus.repository.ArticleRepository;





@Controller
public class CircusController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@RequestMapping("/circus")
	public String toCircus(Model model) {
		model.addAttribute("article",articleRepository.findAll());
		
		return"circus";
	}
	@RequestMapping("/circus/{id}")
	public String toCircusTown(@PathVariable Integer id,Model model) {
		
		model.addAttribute("article",articleRepository.getOne(id));
		return"circus";
	}

}
