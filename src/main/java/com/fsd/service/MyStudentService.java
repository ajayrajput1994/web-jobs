package com.fsd.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fsd.entity.MyStudent;

@Component
public interface MyStudentService {

	MyStudent addMyStudent(MyStudent student);
	
	List<MyStudent> getAllStudnets();
	
	MyStudent updateMyStudent(String utr,long id);
}
