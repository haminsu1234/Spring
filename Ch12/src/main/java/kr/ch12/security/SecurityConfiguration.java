package kr.ch12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@Configuration //전역설정
public class SecurityConfiguration {
	
	@Autowired
	private SecurityUserService service;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//어짜피 리턴해줄거 그냥 첨부터 return 선언하고 해도될듯함
		
		
		return http
				//사이트 위변조 방지 비활성
				.csrf(CsrfConfigurer::disable)//매서드 참조연산조로 람다식을 간결하게 표현
				//기본폼 로그인설정
				.formLogin(f->f
							.loginPage("/user/login")
							.defaultSuccessUrl("/")
							.usernameParameter("uid")
							.passwordParameter("pass")
				)
				//로그아웃설정
				.logout(o->o
						.logoutUrl("/user/logout")
						.logoutSuccessUrl("/")
				)
				//OAuth2 설정
				.oauth2Login(oa->oa
							.loginPage("/user/login")
							.defaultSuccessUrl("/")
						)
				//인가 권한 설정
				.authorizeHttpRequests(a -> a
										.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
										.requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER")
										.requestMatchers("/user/**").permitAll()
										.anyRequest().permitAll()
						)
				.build();
				
				

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder(); //같은문자라도 다른 uuid로 만들어줌
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
	}

}
