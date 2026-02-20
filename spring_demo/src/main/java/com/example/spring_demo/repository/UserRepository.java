package com.example.spring_demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// email で検索したい時に使う
	UserEntity findByEmail(String email);

}
