package ch03.sub2;

import org.springframework.stereotype.Component;

/*
 * 날짜 : 2023/09/19 
 * 이름 : 하민수
 * 내용 : Proxy기반 AOP실습
 * 
 */
@Component
public class LogAdvice {

	public void beforeLog() {
		System.out.println("----------------------------");
		System.out.println("Cross-cutting - beforeLog...");
	}
	
	public void afterLog() {
		System.out.println("Cross-cutting - afterLog...");
		System.out.println("----------------------------");
	}
	
	
}
