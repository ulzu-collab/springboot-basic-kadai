package com.example.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_demo.entity.LoginLogEntity;

public interface LoginLogRepository extends JpaRepository<LoginLogEntity, Long>{

}
