package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MainController.class)//중요
public class MainControllerTest {

	//mvc 테스트를 위한 가상 mvc 객체
	@Autowired
	private MockMvc mvc; // 프로토타입 mvc;
	
	@BeforeAll //afterall 포함 최초한번씩실행
	public static void before() {
		System.out.println("before....");
		
	}
	
	@BeforeEach//each 는 반복문 처럼생각하면됨 하나 가끝나면 각각 전후로 실행됨
	public void beforeEach() {
		System.out.println("beforeEach....");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("afterAll....");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("afterEach....");
	}
	
	
	
	public void index() throws Exception {
		
		mvc
		.perform(get("/index"))						//get 요청 -> index로
		.andExpect(status().isOk()) 				// 요청결과 테스트
		.andExpect(view().name("/index"))			// 반환되는 view 이름 테스트
		.andDo(print());							// 요청 테스트 결과 출력
	
	}

	@Test
	public void include() throws Exception {
		System.out.println("include...");
		
		mvc
		.perform(
				get("/include")
				.param("name", "홍길동")
				.param("age", "23")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("/include"))
		.andDo(print());
	}

	public void layout() {
		System.out.println("layout...");
	}
	
}
