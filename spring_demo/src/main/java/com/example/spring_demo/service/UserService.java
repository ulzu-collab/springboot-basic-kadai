package com.example.spring_demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_demo.entity.UserEntity;
import com.example.spring_demo.form.SignupForm;
import com.example.spring_demo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public UserEntity createUser(SignupForm signupForm) {
		UserEntity userEntity = new UserEntity();
		
		userEntity.setEmail("admin@example.com");
		
		return userRepository.save(userEntity);
	}

}
