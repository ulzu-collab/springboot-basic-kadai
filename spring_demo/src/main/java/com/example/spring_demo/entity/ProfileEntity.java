package com.example.spring_demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class ProfileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private UserEntity userEntity;

	@Column(length = 100)
	private String nickname;

	@Column(columnDefinition = "TEXT")
	private String bio;

	private LocalDate birthday;

	@Column(name = "icon_path", length = 255)
	private String iconPath;

	public ProfileEntity() {
	}

}
