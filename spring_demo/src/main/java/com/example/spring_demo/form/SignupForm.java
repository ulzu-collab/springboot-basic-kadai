package com.example.spring_demo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;
	
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	
	@NotBlank(message = "確認用パスワードを入力してください")
    private String passwordConfirm;


}
