package com.WildCircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.WildCircus.repository.ArticleRepository;
import com.WildCircus.repository.CircusRepository;
import com.WildCircus.repository.WilderRepository;


@Controller
public class IndexController {
	
	
	@Autowired
	private CircusRepository circusRepository;
	
	

	@RequestMapping("/")
	public String toIndex(Model model) {
		
		model.addAttribute("circus",circusRepository.findAll());
		return"Index";
	}
}
