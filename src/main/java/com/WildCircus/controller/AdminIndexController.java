package com.WildCircus.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.WildCircus.entities.Circus;
import com.WildCircus.repository.CircusRepository;

@Controller
public class AdminIndexController {
	
	@Autowired
	private CircusRepository circusRepository;
	
	@RequestMapping("/admin/index")
	public String toAdminIndex(Model model) {
	
		model.addAttribute("circus", circusRepository.findAll());
		return"adminIndex";
	}
	
	@GetMapping("/admin/index/delete{id}")
	public String deleteCircus(RedirectAttributes redirAttrs,@PathVariable Integer id) {
		Circus circusToDelete = circusRepository.findById(id).get();
		circusRepository.delete(circusToDelete);
		return "redirect:/admin/index";
	}
	
	@GetMapping("/admin/index/update")
	public String toCircusUpdate(Model model, @RequestParam(required = false) Integer id) {
        Circus circus = new Circus();
        if (id != null) {
        	Optional<Circus> optionalCircus = circusRepository.findById(id);
        	if (optionalCircus.isPresent()) {
        		circus = optionalCircus.get();
        	}
        }
        model.addAttribute("circus", circus);
		return "adminIndexUpdate";
	}
	
	@PostMapping("/admin/index/update")
	public String updateParagraph(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("image") String image,
			@RequestParam ("town") String town,
			@RequestParam ("name") String name
			) {
		
		Circus circus = new Circus( id, town, name, image );
		circusRepository.save(circus);
		return "redirect:/admin/index";
	}
	

}
