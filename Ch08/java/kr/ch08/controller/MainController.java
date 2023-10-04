package kr.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;


@Controller
public class MainController {

	@Autowired
	private User1Repository repo;
	
	@GetMapping(value = {"/","/index"})
	public String index() {
		return "/index";
	}
	
	@GetMapping("/query1")
	public String query1() {
		
		User1Entity entity=repo.findUser1EntityByUid("a9999");
		
		System.out.println(entity);
		return "redirect:/";
	}
	
	@GetMapping("/query2")
	public String query2() {
		
		List<User1Entity> entity=repo.findUser1EntityByName("9999");
		
		System.out.println(entity);
		return "redirect:/";
	}
	
	@GetMapping("/query3")
	public String query3() {
		
		List<User1Entity> entity=repo.findUser1EntityByNameNot("9999");
		System.out.println(entity);
		return "redirect:/";
	}
	
	@GetMapping("/query4")
	public String query4() {
		
		User1Entity entity=repo.findUser1EntityByUidAndName("a1014","9999");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query5")//or조건
	public String query5() {
		
		List<User1Entity> entity =repo.findUser1EntityByUidOrName("a1014", "9999");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query6")//12초과
	public String query6() {
		List<User1Entity> entity =repo.findUser1EntityByAgeGreaterThan(12);
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query7")//12이상
	public String query7() {
		
		List<User1Entity> entity =repo.findUser1EntityByAgeGreaterThanEqual(12);
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query8")//12미만
	public String query8() {
		
		List<User1Entity> entity =repo.findUser1EntityByAgeLessThan(12);
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query9")//12 이하
	public String query9() {
		
		List<User1Entity> entity =repo.findUser1EntityByAgeLessThanEqual(12);
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query10")//a이상 b 이하
	public String query10() {
		
		List<User1Entity> entity =repo.findUser1EntityByAgeBetween(12,20);
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query11")//해당단어와 유사한단어 %가 안붙어있는듯
	public String query11() {
		
		List<User1Entity> entity =repo.findUser1EntityByNameLike("%민%");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query12")// 해당단어를 포함하는
	public String query12() {
		
		List<User1Entity> entity =repo.findUser1EntityByNameContains("민");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query13")//해당단어로 시작되는
	public String query13() {
		
		List<User1Entity> entity =repo.findUser1EntityByNameStartsWith("김");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query14")
	public String query14() {
		
		List<User1Entity> entity =repo.findUser1EntityByNameEndsWith("민");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query15")//이름순 정렬
	public String query15() {
		
		List<User1Entity> entity =repo.findUser1EntityByOrderByName();
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query16")//나이순 정렬 오름차순
	public String query16() {
		
		List<User1Entity> entity =repo.findUser1EntityByOrderByAgeAsc();
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query17")//나이순 정렬 내림차순
	public String query17() {
		
		List<User1Entity> entity =repo.findUser1EntityByOrderByAgeDesc();
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query18")// select where orderby 인듯
	public String query18() {
		
		List<User1Entity> entity =repo.findUser1EntityByAgeGreaterThanOrderByAgeDesc(12);
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query19")//count 문
	public String query19() {
		
		List<User1Entity> entity =repo.countUser1EntityByUid("a1014");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query20")//count 문 2
	public String query20() {
		
		List<User1Entity> entity =repo.countUser1EntityByName("김민재");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query21")
	public String query21() {
		
		List<User1Entity> entity =repo.selectUser1UnderAge30();
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query22")
	public String query22() {
		
		List<User1Entity> entity =repo.selectUser1ByName("김민재");
		
		System.out.println(entity);
		
		
		return "redirect:/";
	}
	
	@GetMapping("/query23")
	public String query23() {
		
		List<User1Entity> entity =repo.selectUser1ByNameParam("김민재");
		
		System.out.println(entity);
		
		return "redirect:/";
	}
	
	@GetMapping("/query24")
	public String query24() {
		
		List<Object[]> entity = repo.selectUser1ByUid("a1014");
		
		for(Object[] object : entity) {
			System.out.println("object[0]"+object[0]);
			System.out.println("object[1]"+object[1]);
			System.out.println("object[2]"+object[2]);
		}
		
		System.out.println(entity);
		
		return "redirect:/";
	}
}
