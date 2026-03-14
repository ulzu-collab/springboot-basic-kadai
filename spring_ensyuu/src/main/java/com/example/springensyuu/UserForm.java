package com.example.springensyuu;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
	
	private Integer userId;
	private String userName;
	@Size(min = 3, message = "パスワードは3文字以上で入力してください")
	private String password;
}
