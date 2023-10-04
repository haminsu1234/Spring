package kr.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch08.dto.User1DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="USER1")
public class User1Entity { //폼에가까움 클라이언트쪽에 가깝다? 

	@Id
	private String uid;
	
	private String name;
	private String hp;
	private int age;
	
	public User1DTO toDTO() {
		
		
		return User1DTO.builder()
				.uid(uid)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
	}
	
}
