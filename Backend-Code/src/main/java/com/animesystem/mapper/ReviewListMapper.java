package com.animesystem.mapper;

import org.springframework.stereotype.Component;

import com.animesystem.controller.dto.ReviewsListDto;
import com.animesystem.entity.AddReviewDetail;

@Component
public class ReviewListMapper {

	public  ReviewsListDto entityToDto(AddReviewDetail entity) {
		
		ReviewsListDto dto=new ReviewsListDto();
		
		dto.setReviews(entity.getReviews());
		return dto;
	
	}
	
}


