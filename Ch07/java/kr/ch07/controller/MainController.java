package kr.ch07.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ch07.dto.User1DTO;
import kr.ch07.dto.User1DTO.User1DTOBuilder;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	
	@GetMapping(value={"/","/index"})
	public String index(Model model) {
		
		String str1 ="스프링 부트";
		String str2 ="타임리프";
		//생성자를 이용한 초기화
		User1DTO user1 = new User1DTO("A102","홍길동","010-1234-1002",23);
		
		User1DTO user2 =new User1DTO();
		user2.setUid("A102");
		user2.setName("김유신");
		user2.setHp("010-1234-1002");
		user2.setAge(25);
		
		
		//builder 를 이용한 초기화
		
		
		User1DTOBuilder user3 = User1DTO.builder();
							/*user3.build().setUid("A102");
							user3.build().setName("A102");
							user3.build().setHp("010-1234-1234");
							user3.build().setAge(25);*/
							user3.uid("A102");
							user3.name("zzz");
							user3.hp("010-1234-1234");
							user3.age(25);
							
		User1DTO user4=null;
		
		List<User1DTO> users =new ArrayList<>();
		users.add(new User1DTO("A101","홍길동1","010-1234-1001",21));
		users.add(new User1DTO("A102","홍길동2","010-1234-1002",22));
		users.add(new User1DTO("A103","홍길동3","010-1234-1003",23));
		users.add(new User1DTO("A104","홍길동4","010-1234-1004",24));
		users.add(new User1DTO("A105","홍길동5","010-1234-1005",23));
							
		model.addAttribute("str1",str1);
		model.addAttribute("str2",str2);
		model.addAttribute("user1",user1);
		model.addAttribute("user2",user1);
		model.addAttribute("user3",user3);
		model.addAttribute("user4",user4);
		model.addAttribute("users",users);


		
		return "/index";
	}
	
	@GetMapping("/include")
	public String include(String name, int age) {
		log.debug(name);
		log.debug("age + "+age);
		return "/include";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "/layout";
	}
	
}
