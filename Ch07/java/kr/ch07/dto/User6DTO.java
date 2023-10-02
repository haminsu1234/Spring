package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor  
@NoArgsConstructor 
@Builder

public class User6DTO {


	private String uid;
	private String name;
	private String hp;
	private int age;
	private String birth;
	private String gender;
	private String addr;


	}
	
	
	
	

