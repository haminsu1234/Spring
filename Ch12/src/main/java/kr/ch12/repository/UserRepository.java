package kr.ch12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch12.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	
	
}
