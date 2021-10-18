package com.animesystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animesystem.controller.dto.AddReviewDto;
import com.animesystem.controller.dto.ReviewsListDto;
import com.animesystem.serviceimpl.ReviewServiceImpl;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/reviews")
public class ReviewsController {
	private static final Logger LOGGER=LogManager.getLogger(ReviewsController.class);
	
	@Autowired
	ReviewServiceImpl reviewServiceImpl ;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addReviewOfAnime(@RequestBody AddReviewDto AddReviewDto) {
		
		try {
			AddReviewDto addReviewDto=reviewServiceImpl.addReviews(AddReviewDto);
			return new ResponseEntity<>(addReviewDto,HttpStatus.OK);
			
		} catch (Exception e) {
			LOGGER.error("Erro occured in ReviewsController");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	@GetMapping("{Id}")
	public ResponseEntity<?>  getReviewsByAnimeId(@PathVariable("Id") Integer Id) {
		
		try{
			List<ReviewsListDto> list=reviewServiceImpl.getReviewsList(Id);

			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Erro occured in ReviewsController");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		
	}
	

}
