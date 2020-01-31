package com.WildCircus.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "TEXT")
	private String content_circus;
	private String picture_circus;
	@Column(columnDefinition = "TEXT")
	private String content_town;
	private String picture_town;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "circus_id", referencedColumnName = "id")
    private Circus circus;
	
	
	public Article() {
		
	}


	public Article(Integer id, String content_circus, String picture_circus, String content_town, String picture_town) {
		this.id = id;
		this.content_circus = content_circus;
		this.picture_circus = picture_circus;
		this.content_town = content_town;
		this.picture_town = picture_town;
	}
	
	
	

	

	public Article(Integer id, String content_circus, String picture_circus, Circus circus) {
		this.id = id;
		this.content_circus = content_circus;
		this.picture_circus = picture_circus;
		this.circus = circus;
	}


	public Article(Integer id, String content_circus, String picture_circus, String content_town, String picture_town,
			Circus circus) {
		this.id = id;
		this.content_circus = content_circus;
		this.picture_circus = picture_circus;
		this.content_town = content_town;
		this.picture_town = picture_town;
		this.circus = circus;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getContent_circus() {
		return content_circus;
	}


	public void setContent_circus(String content_circus) {
		this.content_circus = content_circus;
	}


	public String getPicture_circus() {
		return picture_circus;
	}


	public void setPicture_circus(String picture_circus) {
		this.picture_circus = picture_circus;
	}


	public String getContent_town() {
		return content_town;
	}


	public void setContent_town(String content_town) {
		this.content_town = content_town;
	}


	public String getPicture_town() {
		return picture_town;
	}


	public void setPicture_town(String picture_town) {
		this.picture_town = picture_town;
	}


	public Circus getCircus() {
		return circus;
	}


	public void setCircus(Circus circus) {
		this.circus = circus;
	}	
	
	
}
