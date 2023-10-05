package kr.ch09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ch09.entity.UserEntity;
import kr.ch09.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@GetMapping("/user/success")
	public String success() {
		return "/user/success";
		
		//template might not exist or might not be accessible by any of the configured Template Resolvers
		// 이오류 -> return 받는 html 파일이름과  return 에 경로이름이 다르면 오류뜸 파일을 바꾸던가 경로를 바꾸던가 해야함 바꾸니까 귀신같이해결됨 
	}
	
	@PostMapping("/user/register")
	public String register(UserEntity user) {
		service.insertUser(user);
		return "redirect:/user/login";
	}
	

}
