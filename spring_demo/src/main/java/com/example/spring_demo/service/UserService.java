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

	/**
	 * 新規ログイン情報を登録する。今は仮の値を代入している。
	 * @param signupForm
	 * @return
	 */
	@Transactional
	public UserEntity createUser(SignupForm signupForm) {

		UserEntity userEntity = new UserEntity();

		userEntity.setEmail("admin@example.com");
		userEntity.setPassword("password");

		return userRepository.save(userEntity);
	}

	public boolean authenticate(String email, String password) {

		// 仮のユーザー情報（後でDBに置き換える）
		String dummyEmail = "admin@example.com";
		String dummyPassword = "password";

		// email と password が一致しているかチェック
		return dummyEmail.equals(email) && dummyPassword.equals(password);
	}

	// フォームクラスを作成、ログイン機能実装途中。

}
