package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.UserDetail;

public interface UserRepository extends JpaRepository<UserDetail, Long> {

	@Query("select user from UserDetail user where user.userid =:userid")
	public UserDetail getUser(@Param("userid") String userid);
}
