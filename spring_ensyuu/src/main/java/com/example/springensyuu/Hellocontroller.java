package com.example.springensyuu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springensyuu.entity.User;
import com.example.springensyuu.service.HelloService;

@RestController
//@RequestMapping("/greeting")
public class Hellocontroller {
	private final HelloService helloService;
	
	public Hellocontroller(HelloService helloService) {
        this.helloService = helloService;
    }

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/goodnight")
	public String goodnight() {
		return "Goodnight";
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	@GetMapping("/num/{number}")
	public int getnumber(@PathVariable("number") int number) {
		return number;
	}
	
	@GetMapping("/user/{userid}")	// URLから/user/の後に続く値を取得。
	public String getuser(@PathVariable("userid") Integer number) {
//		HelloService helloService = new HelloService(); 確認の為に一度手動インスタンス化したもの。
		return helloService.getUserName(number);	// 取得した値をHelloServiceのuserNameメソドに渡す。
	}
	
	// 
	/**
	 * ログイン情報を登録するメソッド。
	 * @param user
	 */
	@PostMapping("/user/add")
	public void add(@RequestBody User user) {	// 受け取ったデータを解読する為のアノテーション。
		System.out.println(user.getUserName() + user.getUserId() + user.getPassword());		// コンソールにuserの中身を出力して確認。
		helloService.addUser(user);		// サービスから登録処理する情報を受け取ってDBに登録する。
	}

}
