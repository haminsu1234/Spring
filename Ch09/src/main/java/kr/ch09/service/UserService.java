package kr.ch09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ch09.entity.UserEntity;
import kr.ch09.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public void insertUser(UserEntity entity) {
		//비밀번호 암호화
		entity.setPass(encoder.encode(entity.getPass()));
		
		repo.save(entity);
	}
	
	public UserEntity selectUser(String uid,String pass) {
		return repo.findUserEntityByUidAndPass(uid, pass);
		
	}
	
}
