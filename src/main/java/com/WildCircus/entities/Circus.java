package com.WildCircus.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Circus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer place_max;
	private String town;
	private String image;
	@OneToMany(mappedBy = "circus", cascade = CascadeType.ALL)
	private List<Wilder> wilder;
	 @OneToOne(mappedBy = "circus", cascade = CascadeType.ALL)
	    private Article article;
	 
	public Circus() {
	}

	public Circus(Integer id, String name, Integer place_max, String town, String image, List<Wilder> wilder,
			Article article) {
		super();
		this.id = id;
		this.name = name;
		this.place_max = place_max;
		this.town = town;
		this.image = image;
		this.wilder = wilder;
		this.article = article;
	}

	public Circus(String name, Integer place_max, String town, String image, List<Wilder> wilder,
			Article article) {
		super();
		this.name = name;
		this.place_max = place_max;
		this.town = town;
		this.image = image;
		this.wilder = wilder;
		this.article = article;
	}
	
	

	public Circus(Integer id, String name, String town, String image) {
		super();
		this.id = id;
		this.name = name;
		this.town = town;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlace_max() {
		return place_max;
	}

	public void setPlace_max(Integer place_max) {
		this.place_max = place_max;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Wilder> getWilder() {
		return wilder;
	}

	public void setWilder(List<Wilder> wilder) {
		this.wilder = wilder;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
