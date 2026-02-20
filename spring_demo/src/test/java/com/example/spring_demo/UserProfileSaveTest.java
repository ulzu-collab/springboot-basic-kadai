package com.example.spring_demo;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.spring_demo.entity.ProfileEntity;
import com.example.spring_demo.entity.UserEntity;
import com.example.spring_demo.repository.ProfileRepository;
import com.example.spring_demo.repository.UserRepository;

@DataJpaTest
public class UserProfileSaveTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Test
	void DBに情報が登録されるか() {

		// --- User 作成 ---
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail("test@example.com");
		userEntity.setPassword("password123");
		userEntity.setRole("nagi");

		userRepository.save(userEntity);

		// --- Profile 作成 ---
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setNickname("Nagi");
		profileEntity.setBio("Hello, I'm Nagi!");
		profileEntity.setUserEntity(userEntity);
		userEntity.setProfile(profileEntity);
		profileEntity.setBirthday(LocalDate.of(2000, 1, 1));
		profileEntity.setIconPath(null);

		profileRepository.save(profileEntity);

		// --- 検証 ---
		assertThat(userRepository.count()).isEqualTo(1);
		assertThat(profileRepository.count()).isEqualTo(1);

		UserEntity savedUser = userRepository.findAll().get(0);
		ProfileEntity savedProfile = profileRepository.findAll().get(0);

		assertThat(savedUser.getEmail()).isEqualTo("test@example.com");
		assertThat(savedProfile.getNickname()).isEqualTo("Nagi");
		assertThat(savedProfile.getUserEntity().getId()).isEqualTo(savedUser.getId());
	}
}