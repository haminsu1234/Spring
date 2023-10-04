package kr.ch08.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.User1Entity;

@Repository
public interface User1Repository extends JpaRepository<User1Entity, String> { //entitya, pk의 자료형

	// JPA 쿼리 메서드 jpa 명령 규칙에 맞게 매서드 이름 짖기
	public User1Entity findUser1EntityByUid(String uid);
	public List<User1Entity > findUser1EntityByName(String name);
	public List<User1Entity > findUser1EntityByNameNot(String name);
	public User1Entity findUser1EntityByUidAndName(String uid,String name);
	
	public List<User1Entity> findUser1EntityByUidOrName(String uid,String name);

	public List<User1Entity> findUser1EntityByAgeGreaterThan(int age);
	public List<User1Entity> findUser1EntityByAgeGreaterThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeLessThan(int age);
	public List<User1Entity> findUser1EntityByAgeLessThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeBetween(int low ,int high);

	
	public List<User1Entity> findUser1EntityByNameLike(String name);
	public List<User1Entity> findUser1EntityByNameContains(String name);
	public List<User1Entity> findUser1EntityByNameStartsWith(String name);
	public List<User1Entity> findUser1EntityByNameEndsWith(String name);

	public List<User1Entity> findUser1EntityByOrderByName();
	public List<User1Entity> findUser1EntityByOrderByAgeAsc();
	public List<User1Entity> findUser1EntityByOrderByAgeDesc();
	public List<User1Entity> findUser1EntityByAgeGreaterThanOrderByAgeDesc(int age);
	
	public List<User1Entity> countUser1EntityByUid(String uid);
	public List<User1Entity> countUser1EntityByName(String name);
	
	//JPQL
	@Query("select ul from User1Entity as ul where ul.age < 30")
	public List<User1Entity> selectUser1UnderAge30();
	
	@Query("select ul from User1Entity as ul where ul.name= ?1")
	public List<User1Entity> selectUser1ByName(String name);
	
	@Query("select ul from User1Entity as ul where ul.name= :name")
	public List<User1Entity> selectUser1ByNameParam(@Param("name") String name);
	
	@Query("select ul.uid, ul.name, ul.age from User1Entity as ul where ul.uid= :uid")
	public List<Object[]> selectUser1ByUid(@Param("uid") String uid);
	
	
	
	
}
