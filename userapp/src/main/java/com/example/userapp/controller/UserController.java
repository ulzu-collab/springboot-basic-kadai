package com.example.userapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.userapp.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    /registerにアクセスされた時、register.htmlを表示として返す。
    @GetMapping("/register")
    public String showForm() {
        return "register"; // register.html を表示
    }

//    /registerフォームから送られたデータを受け取る。
    @PostMapping("/register")	// /registerページから受け取った値を処理するという意味。
    public String register(
            @RequestParam String username,	// usernameに代入されたString型の値を受け取る。
            @RequestParam String password,
            Model model
    ) {
//    	Serviceに処理を依頼する。
        userService.register(username, password);
        model.addAttribute("message", "登録完了！");
        return "result"; // result.html を表示
    }
}