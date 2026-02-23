package com.example.spring_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring_demo.service.UserService;

@Controller
public class LoginController {

	private final UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email,
			@RequestParam String password,
			Model model) {

		boolean result = userService.authenticate(email, password);

		if (result) {
			model.addAttribute("message", "ログイン成功！");
			return "login-success";
		} else {
			model.addAttribute("message", "ログイン失敗…");
			return "login-fail";
		}
	}
}
