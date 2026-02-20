package com.example.userapp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userapp.entity.User;
import com.example.userapp.repository.UserRepository;

@Service		//このクラスがビジネスロジック（処理の本体）を担当する宣言。
public class UserService {

//	UserServiceクラスのフィールドで、インスタンスは後で自動で生成されるのでnewが無い。
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    Springがインスタンスを自動生成し、注入する。そして注入されたインスタンスをフィールドにセットしている。
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String username, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(rawPassword)); // パスワードを暗号化

        return userRepository.save(user);
    }
}