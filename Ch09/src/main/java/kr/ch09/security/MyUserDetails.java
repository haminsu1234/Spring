package kr.ch09.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString

//sessUser 로 저장된다 라고 생각하면 될듯
public class MyUserDetails implements UserDetails{

	private static final long serialVersionUID = -2215291298593473038L;
	
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private String role;
	private int age;
	private LocalDateTime regDate;
	
	
	
	
	@Override //인가 등급을 리턴(role)
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//계정이 갖는 권한 목록
		List<GrantedAuthority> authorities =new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		return authorities;
	}

	@Override 
	public String getPassword() {
		// 계정이 갖는 비밀번호
		return pass;
	}

	@Override
	public String getUsername() {
		//계정이 갖는 id
		return uid;
	}

	@Override
	public boolean isAccountNonExpired() {
		//계정 만료 여부(true : 만료안됨 , false : 만료)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//계정 잠김 여부 (lock)(true : 잠김아님 , false : 잠김)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//계정 비밀번호 만료 여부(true : 만료안됨 , false : 잠김)(3개월마다 바꾸라는거)
		return true;
	}

	@Override
	public boolean isEnabled() {
		//계정 활성화 여부 (true : 활성화 , false : 비활성화)
		return true;
	}

}
