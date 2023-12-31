package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User1DTO;
import kr.ch07.dto.User1DTO.User1DTOBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User1MapperTest {

	@Autowired
	private User1Mapper mapper;
	
	
	public void insertUser1(User1DTO dto) {
		
		User1DTO user1 = User1DTO.builder()
						.uid("A102")
						.name("zzz")
						.hp("010-1234-1234")
						.age(25)
						.build();
		
		mapper.insertUser1(user1);
		
	};
	
	public User1DTO selectUser1(String uid) {
		return null;
	};
	
	@Test
	public List<User1DTO> selectUser1s(){
		List<User1DTO> users =mapper.selectUser1s();
		
		for(User1DTO user :users) {
			log.info(users.toString());
			
		}		
		
		return null;
	};
	
	public void updateUser1(User1DTO dto) {};
	
	public void deleteUser1(String uid) {};
	
}
