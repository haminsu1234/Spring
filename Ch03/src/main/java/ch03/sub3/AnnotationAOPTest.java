package ch03.sub3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch03.sub3.Service;

public class AnnotationAOPTest {

	public static void main(String[] args) {
		//스프링 컨텍스트 객체 생성(컨테이너)
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		//Service 객체 가져오기
		Service service = (Service) ctx.getBean("service2");
		//Service 객체 실행
		service.insert();
		service.select();
		service.update(0);
		service.delete(0, null);
	}
}
