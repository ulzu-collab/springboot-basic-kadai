package com.example.spring_demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users") // schema.sql のテーブル名に合わせる
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ログインに使用するので重複禁止。
	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(nullable = false, length = 255)
	private String password;

	@Column(nullable = false, length = 50)
	private String role;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	// --- Profile（1対1） ---
	@OneToOne(mappedBy = "userEntity")
	private ProfileEntity profile;

	// --- Post（1対多） ---
	@OneToMany(mappedBy = "userEntity")
	private List<PostEntity> posts;

	// --- LoginLog（1対多） ---
	@OneToMany(mappedBy = "userEntity")
	private List<LoginLogEntity> loginLogs;

	// --- コンストラクタ ---
	public UserEntity() {
	}

}
