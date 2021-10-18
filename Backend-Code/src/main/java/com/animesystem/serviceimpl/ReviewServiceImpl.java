package com.animesystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animesystem.controller.ReviewsController;
import com.animesystem.controller.dto.AddReviewDto;

import com.animesystem.controller.dto.ReviewsListDto;
import com.animesystem.entity.AddReviewDetail;
import com.animesystem.mapper.AddReviewMapper;
import com.animesystem.mapper.ReviewListMapper;
import com.animesystem.repository.AddReviewRepository;
import com.animesystem.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	private static final Logger LOGGER=LogManager.getLogger(ReviewServiceImpl.class);
	
	@Autowired
	AddReviewRepository addReviewRepository;
	
	@Autowired
	AddReviewMapper addReviewMapper;
	
	@Autowired
	private ReviewListMapper reviewListMapper;

	@Override
	public AddReviewDto addReviews(AddReviewDto addReviewDto) throws Exception {
		
		AddReviewDetail addReviewDetail=addReviewMapper.dtoToEntity(addReviewDto);
		addReviewDetail=addReviewRepository.save(addReviewDetail);
		
		return addReviewMapper.entityToDto(addReviewDetail);
		

	}

	@Override
	public List<ReviewsListDto> getReviewsList(Integer id) throws Exception {
	List<AddReviewDetail> entityList=addReviewRepository.findReviewsByAnimeId(id);
		
		List<ReviewsListDto> listDto=new ArrayList<>();
		for(AddReviewDetail entity: entityList) {

			ReviewsListDto dto=reviewListMapper.entityToDto(entity);
		
			listDto.add(dto);
				
		}
		return listDto;
	}



	
}
