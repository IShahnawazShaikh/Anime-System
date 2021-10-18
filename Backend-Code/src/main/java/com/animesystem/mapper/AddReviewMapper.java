package com.animesystem.mapper;

import org.springframework.stereotype.Component;

import com.animesystem.controller.dto.AddReviewDto;
import com.animesystem.entity.AddReviewDetail;

@Component
public class AddReviewMapper {
	
	public  AddReviewDetail dtoToEntity(AddReviewDto dto) {
		
		AddReviewDetail entity=new AddReviewDetail();
		entity.setAnimeId(dto.getAnimeId());
		entity.setUserId(dto.getUserId());
		entity.setReviews(dto.getReviews());
	
		return entity;
	}
	
	
	public  AddReviewDto entityToDto(AddReviewDetail entity) {
		
		AddReviewDto dto=new AddReviewDto();
		dto.setAnimeId(entity.getAnimeId());
		dto.setUserId(entity.getUserId());
		dto.setReviews(entity.getReviews());
	
		return dto;
	}

}
