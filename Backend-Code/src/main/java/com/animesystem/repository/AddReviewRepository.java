package com.animesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.animesystem.entity.AddReviewDetail;

@Repository
public interface AddReviewRepository extends CrudRepository<AddReviewDetail,Long>{
     @Query("select u from AddReviewDetail u where u.animeId=?1")
	List<AddReviewDetail> findReviewsByAnimeId(Integer id);
	

}
