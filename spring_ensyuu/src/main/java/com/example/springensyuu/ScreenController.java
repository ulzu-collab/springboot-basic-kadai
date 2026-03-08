package com.example.springensyuu;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springensyuu.entity.User;
import com.example.springensyuu.service.HelloService;

import jakarta.validation.Valid;

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
//	@GetMapping("/screen/all")
//	public String screenAll(Model model) {
//		List<User> userList = helloService.getAllUser();
//		model.addAttribute("users", userList);
//		return "all";
//	}
	
	@GetMapping("/screen/all")
	public String screenAll(
	        @RequestParam(name = "page", defaultValue = "0") int page,
	        Model model) {

	    int pageSize = 2; // 1ページ2件

	    // ★ helloService にページング対応のメソッドがある前提
	    Page<User> userPage = helloService.getAllUser(page, pageSize);

	    model.addAttribute("users", userPage.getContent());     // 今のページの2件
	    model.addAttribute("currentPage", page);                // 現在ページ
	    model.addAttribute("totalPages", userPage.getTotalPages()); // 総ページ数

	    return "all"; // all.html にページング情報を渡す
	}
	
	@GetMapping("/screen/user/add")
	public String showAddUser(User user) {
		
		return "addUser";
	}
	
	@PostMapping("/screen/user/add")
	public String addUser(@Valid User user,BindingResult result, Model model) {
		helloService.addUser(user);
		return "addUser";
	}
}
