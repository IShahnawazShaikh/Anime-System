package com.animesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddReviewDetail")
public class AddReviewDetail {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="Id")
    private Long Id;
	
	@Column(name="userId")
	private String userId; 
	
	@Column(name="animeId")
	private Integer animeId;
	
	@Column(name="reviews")
	private String reviews;

	public AddReviewDetail() {}
	public AddReviewDetail(Long id, String userId, Integer animeId, String reviews) {
		super();
		Id = id;
		this.userId = userId;
		this.animeId = animeId;
		this.reviews = reviews;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAnimeId() {
		return animeId;
	}

	public void setAnimeId(Integer animeId) {
		this.animeId = animeId;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	
	
}
