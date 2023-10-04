package kr.ch08.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch08.dto.User1DTO;
import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;

@Service
public class User1Service {
	
	@Autowired
	private User1Repository repo;
	
	public void insertUser1(User1DTO dto) {
		//Entity 변환
		User1Entity entity = dto.toEntity();		
		repo.save(entity);
	}
	
	public User1DTO selectUser1(String uid) {
		
	
		Optional<User1Entity> result =repo.findById(uid); //null 값처리를 편리하게해줌
	
		//entity 를 dto로 변환
		User1DTO dto = result.get().toDTO();
		
		return dto;
	}
	
	public List<User1DTO> selectUser1s() {
		
		//entity 를 dto 로 변환
							//entity리스트   스트림연결  map을통해 오브젝트들을 일괄처리
		List<User1DTO> list =repo.findAll().stream()
							.map(t -> User1DTO.builder()
									.uid(t.getUid())
									.name(t.getName())
									.hp(t.getHp())
									.age(t.getAge())
									.build())
							.collect(Collectors.toList());
		
		
		
		return list;
	}
	
	public void updateUser1(User1DTO dto) {
		//Entity 변환
		User1Entity entity = dto.toEntity();		
		repo.save(entity);
	}
	
	public void deleteUser1(String uid) {
		repo.deleteById(uid);
	}
	
	
}
