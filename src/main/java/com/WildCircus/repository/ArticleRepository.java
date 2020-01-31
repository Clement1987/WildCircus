package com.WildCircus.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.WildCircus.entities.Article;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
}
