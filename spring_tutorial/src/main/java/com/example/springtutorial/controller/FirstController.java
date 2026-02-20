package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//クラスをコントローラにするアノテーション
@Controller
public class FirstController {
	
		//firstメソッドをGetMapingでGETリクエストに紐づける。
		@GetMapping("/")
		public String first() {
			return "firstView";
		}

}
