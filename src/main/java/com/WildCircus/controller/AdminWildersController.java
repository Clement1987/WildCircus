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
import com.WildCircus.entities.Wilder;
import com.WildCircus.repository.WilderRepository;

@Controller
public class AdminWildersController {
	
	@Autowired
	private WilderRepository wilderRepository;
	
	
	@RequestMapping("/admin/wilders")
	public String toAdminWilder(Model model) {
	
		model.addAttribute("wilder", wilderRepository.findAll());
		return"adminWilders";
	}
	
	@GetMapping("/admin/wilders/update")
	public String towildersUpdate(Model model, @RequestParam(required = false) Integer id) {
        Wilder wilder = new Wilder();
        if (id != null) {
        	Optional<Wilder> optionalCircus = wilderRepository.findById(id);
        	if (optionalCircus.isPresent()) {
        		wilder = optionalCircus.get();
        	}
        }
        model.addAttribute("wilder", wilder);
		return "adminWildersUpdate";
	}
	
	@PostMapping("/admin/wilders/update")
	public String updateWilders(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("name") String name,
			@RequestParam ("firstname") String firstname,
			@RequestParam ("content") String content,
			@RequestParam ("picture") String picture
			) {
		
		Wilder wilder = new Wilder( id, name, firstname, content, picture);
		wilderRepository.save(wilder);
		return "redirect:/admin/wilders";
	}
	
	@GetMapping("/admin/wilders/delete{id}")
	public String deleteWilder(RedirectAttributes redirAttrs,@PathVariable Integer id) {
		Wilder wilderToDelete = wilderRepository.findById(id).get();
		wilderRepository.delete(wilderToDelete);
		return "redirect:/admin/wilders";
	}
	

}
