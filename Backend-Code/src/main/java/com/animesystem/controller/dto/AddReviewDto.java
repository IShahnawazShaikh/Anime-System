package com.animesystem.controller.dto;


public class AddReviewDto {
	private String userId;
    private Integer animeId;
	private String reviews;
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
