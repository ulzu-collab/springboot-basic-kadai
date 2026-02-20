package com.example.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_demo.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{

}
