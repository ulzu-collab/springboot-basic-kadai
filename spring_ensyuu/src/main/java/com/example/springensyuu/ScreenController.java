package com.example.springensyuu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String searchUserName(@RequestParam int userId, Model model) {
		String userName = helloService.getUserName(userId);
		model.addAttribute("userName", userName);	// addAttributeは配送依頼、第一引数が箱のラベル、第二引数に中の荷物。
		return "viewName";
	}
	
	/**
	 * usersテーブルの内容を一覧表示するメソッドの作成途中。
	 * @return
	 */
	@GetMapping("/screen/all")
	public String screenAll() {
		
		return "all";
	}
}
