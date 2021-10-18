package com.animesystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.animesystem.entity.UserDetail;

@Repository
public interface UserRepository extends CrudRepository<UserDetail,String>{

	@Query("select u from UserDetail u where u.email=?1 AND u.password=?2")
	UserDetail findUserByEmail(String email, String password);

}
