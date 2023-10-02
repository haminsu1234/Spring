package kr.ch07.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.ch07.dto.User6DTO;

@Repository
public class User6DAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void insertUser6(User6DTO dto) {
		mybatis.insert("insertUser6",dto);

	}
	
	public User6DTO selectUser6(String uid) {
		return mybatis.selectOne("selectUser6", uid);
	}
	
	public List<User6DTO> selectUser6s() {
		return mybatis.selectList("selectUser6s");
	}
	
	public void updateUser6(User6DTO dto) {
		mybatis.update("updateUser6",dto);
	}
	
	public void deleteUser6(String uid) {
		mybatis.delete("deleteUser6",uid);
	}
	
}
