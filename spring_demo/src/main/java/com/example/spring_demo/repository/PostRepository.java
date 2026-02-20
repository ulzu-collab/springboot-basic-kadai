package com.example.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_demo.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{

}
