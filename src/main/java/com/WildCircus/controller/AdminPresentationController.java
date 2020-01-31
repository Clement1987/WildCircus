package com.WildCircus.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.WildCircus.entities.Article;
import com.WildCircus.entities.Circus;
import com.WildCircus.repository.ArticleRepository;


@Controller
public class AdminPresentationController {

	@Autowired
	private ArticleRepository articleRepository;
	
	
	@RequestMapping("/admin/presentation")
	public String toAdminPresentation(Model model) {
	
		model.addAttribute("article", articleRepository.findAll());
		return"adminPresentation";
	}
	
	@GetMapping("/admin/presentation/articleCircus/update")
	public String toArticleCircusUpdate(Model model, @RequestParam(required = false) Integer id) {
        Article article = new Article();
        if (id != null) {
        	Optional<Article> optionalArticle = articleRepository.findById(id);
        	if (optionalArticle.isPresent()) {
        		article = optionalArticle.get();
        	}
        }
        model.addAttribute("article", article);
		return "adminPresentationUpdate";
	}
	
	@PostMapping("/admin/presentation/update")
	public String updateArticle(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("content_circus") String content_circus,
			@RequestParam ("picture_circus") String picture_circus,
			@RequestParam ("content_town") String content_town,
			@RequestParam ("picture_town") String picture_town,
			@RequestParam ("name") String name
			) {
		
		
		Article article = new Article(id,content_circus, picture_circus, content_town, picture_town
				);
		articleRepository.save(article);
		return "redirect:/admin/presentation";
	}
	
	
	
	
	
}
