package com.example.springensyuu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")	// 参照するDBのテーブル名を指定。
@Data	// ゲッターとセッターを自動生成。
public class User {
	@Id
//	@GeneratedValue( strategy = GenerationType.IDENTITY )	// 新しくDBに登録された時に自動でナンバリングするアノテーション。
	@Column( name = "user_id" )
	private Integer userId;
	
	@Column( name = "user_name" )
	private String userName;
	
	@Column( name = "password" )
	private String password;

}
