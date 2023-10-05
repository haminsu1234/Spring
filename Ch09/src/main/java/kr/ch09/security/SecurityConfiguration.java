package kr.ch09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration //전역설정
public class SecurityConfiguration {
	
	@Autowired
	private SecurityUserService service;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//어짜피 리턴해줄거 그냥 첨부터 return 선언하고 해도될듯함
		
		 return http
			//인가 설정
			.authorizeHttpRequests( authorizeRequests -> authorizeRequests
															.requestMatchers("/").permitAll()	
															.requestMatchers("/user/**").permitAll()	
															.requestMatchers("/admin/**").hasAuthority("ADMIN")
															.requestMatchers("/manager/**").hasAnyAuthority("MANAGER","ADMIN")
				)		
			//사이트 위변조 방지 설정
			.csrf(CsrfConfigurer::disable)
			//로그인 설정
			.formLogin( formLogin -> formLogin
									.loginPage("/user/login")
									.defaultSuccessUrl("/user/success")
									.failureUrl("/user/login?success=100")
									.usernameParameter("uid")
									.passwordParameter("pass")
			
			)
			
			//로그아웃 설정 
			.logout( logout-> logout
				.invalidateHttpSession(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.logoutSuccessUrl("/user/login?success=200")
			)
			
			//사용자 인증 처리 컴포넌트 등록
			.userDetailsService(service)
		 	.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder(); //같은문자라도 다른 uuid로 만들어줌
	}

}
