package com.example.springensyuu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springensyuu.service.HelloService;

@Controller
public class ScreenController {
	private final HelloService helloService;
	
	public ScreenController(HelloService helloService) {
        this.helloService = helloService;
	}

	@GetMapping("/user/screen")
	public String getUserName() {
		return "viewName";
	}
	
	@GetMapping("/user/search")
	public String searchUserName(@RequestParam int userId) {
		helloService.getUserName(userId);
		return "viewName";
	}
}
