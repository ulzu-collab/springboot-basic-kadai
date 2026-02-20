package com.example.springensyuu.service;


import org.springframework.stereotype.Service;

import com.example.springensyuu.entity.User;
import com.example.springensyuu.repository.UserRepository;

@Service
public class HelloService {
	private final UserRepository userRepository;
	
	public HelloService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public String getUserName(Integer number) {		// Hellocontrollerからnumberを受け取る。
		User user = userRepository.findByUserId(number);	// 受け取ったnumberでRepositoryが取得したレコードをuserに格納。
		return user.getUserName();		// userに格納されたレコードからgetUserNameでNameのみを返す。
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
}
