package kr.ch12.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="User")
public class UserEntity {
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private String role;
	private int age;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	
	
	

}
