package com.fsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.entity.MyStudent;

@Repository
public interface MyStudentRepository extends JpaRepository<MyStudent, Long> {

	@Query("SELECT s FROM MyStudent s where s.email=:email")
	public MyStudent getStudentByemail(@Param("email") String email);
	
	@Query("SELECT s FROM MyStudent s where s.email=:phone")
	public MyStudent getStudentByphone(@Param("phone") String phone);
	
	public List<MyStudent> findByEmail(String email);
	
	public List<MyStudent> findByPhone(String phone);
	
}
