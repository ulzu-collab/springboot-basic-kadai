package com.example.springensyuu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springensyuu.entity.User;

// JpaRepositoryを継承し、エンティティクラス名と、主キーのデータ型を指定。
public interface UserRepository  extends JpaRepository<User, Integer> {
	// findByは検索するカラム、引数に対象のデータ型とカラム名。Userエンティティのインスタンスを生成。
	User findByUserId(Integer userId);	// userIdカラムから一致する値を検索してレコードを取得。
}
