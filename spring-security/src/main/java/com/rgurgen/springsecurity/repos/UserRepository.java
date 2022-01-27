package com.rgurgen.springsecurity.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgurgen.springsecurity.model.Role;
import com.rgurgen.springsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);

	   @Modifying
	   @Query("update User set role = :role where userName = :username")
	   void updateUserRole(@Param("username") String userName, @Param("role") Role role);
	
	
}
