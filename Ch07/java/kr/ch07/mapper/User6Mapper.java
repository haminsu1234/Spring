package kr.ch07.mapper;

import java.util.List;

import kr.ch07.dto.User6DTO;

public interface User6Mapper {

	public void insertUser6(User6DTO dto);
	public void selectUser6(String uid);
	public List<User6DTO> selectUser1s();
	public void updateUser6(User6DTO dto);
	public void deleteUser6(String uid);
	
}
