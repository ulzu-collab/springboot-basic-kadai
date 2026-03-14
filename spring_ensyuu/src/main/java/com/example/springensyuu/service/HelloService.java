package com.example.springensyuu.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.springensyuu.UserForm;
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
	
	/**
	 * usersテーブルに情報を登録する。
	 * @param user
	 */
	public void addUser(User user) {
		userRepository.save(user);
	}
	/**
	 * usersテーブルの中身を一覧表示する。
	 * @return
	 */
//	public Page<User> getAllUser() {
//		return userRepository.findAll();
//	}
	
	public Page<User> getAllUser(int page, int size) {
	    return userRepository.findAll(PageRequest.of(page, size));
	}
	
	public void addUser(UserForm userForm) {
		User user = new User();
		user.setUserId(userForm.getUserId());
		user.setUserName(userForm.getUserName());
		user.setPassword(userForm.getPassword());
		userRepository.save(user);
	}
}
