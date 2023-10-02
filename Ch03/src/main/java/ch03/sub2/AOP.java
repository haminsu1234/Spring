package ch03.sub2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2023/09/19 
 * 이름 : 하민수
 * 내용 : Proxy기반 AOP실습
 * 
 */
public class AOP {
	public static void main(String[] args) {
		//스프링 컨텍스트 객체 생성(컨테이너)
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		//Service 객체 가져오기
		Service service = (Service) ctx.getBean("service1");
		//Service 객체 실행
		service.insert();
		service.select();
		service.update(0);
		service.delete(0, null);
	}
	
	
}
