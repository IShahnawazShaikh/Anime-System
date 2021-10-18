package com.animesystem.service;

import java.util.List;

import com.animesystem.controller.dto.AddReviewDto;
import com.animesystem.controller.dto.ReviewsListDto;

public interface ReviewService {
	public AddReviewDto addReviews(AddReviewDto addReviewDto)  throws Exception;
	List<ReviewsListDto> getReviewsList(Integer id) throws Exception;

}
