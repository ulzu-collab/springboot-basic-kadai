package com.example.userapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userapp.entity.User;

//JpaReoisitoryクラスを継承して、<User, Long>は、使用するエンティティentity/User.javaを指定し、Longで主キーのデータ型を指定している。
public interface UserRepository extends JpaRepository<User, Long> {
//	Userエンティティのインスタンスを返すという意味。
//	findByUsernameは、検索するカラム。findByの後はカラム名。Andを使って複数検索もできる。
//	括弧の中は検索条件として渡す値とそのデータ型。
    User findByUsername(String username);
}