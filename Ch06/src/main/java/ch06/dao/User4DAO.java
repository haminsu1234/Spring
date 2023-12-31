package ch06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch06.dto.User1DTO;

@Repository
public class User4DAO {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public void insertUser1(User1DTO dto) {
		
		String sql = "INSERT INTO `USER1` VALUES (?,?,?,?)";
		
		// Object 배열로 순서에 맞게 Query Parameter 바인딩 
		Object[] params = {
					dto.getUid(), 
					dto.getName(), 
					dto.getHp(), 
					dto.getAge()
					};
		
		// update() 메서드로 INSERT, UPDATE, DELETE 실행
		jdbc.update(sql, params);
		
	}
	
	public User1DTO selectUser1(String uid) {
		String sql = "SELECT * FROM `USER1` WHERE `uid`=?";
		User1DTO dto = jdbc.queryForObject(sql, new User1RowMapper(), uid);
		return dto;
	}
	
	public List<User1DTO> selectUser1s() {
		String sql = "SELECT * FROM `USER1`";
		List<User1DTO> users = jdbc.query(sql, new User1RowMapper());
		return users;
	}
	
	public void updateUser1(User1DTO dto) {
		String sql = "UPDATE `USER1` SET `name`=?, `hp`=?, `age`=? WHERE `uid`=?";
		Object[] params = {
					dto.getName(),
					dto.getHp(),
					dto.getAge(),
					dto.getUid()			
				  };
		
		jdbc.update(sql, params);
	}
	
	public void deleteUser1(String uid) {
		String sql = "DELETE FROM `USER1` WHERE `uid`=?";
		jdbc.update(sql, uid);
	}
	
}