package com.fsd.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.entity.MyStudent;
import com.fsd.repository.MyStudentRepository;
import com.fsd.service.MyStudentService;
@Service
public class MyStudentServiceImpl implements MyStudentService {
	@Autowired
	private MyStudentRepository myStudentRepository;

	@Override
	public MyStudent addMyStudent(MyStudent student) {
		List<MyStudent> checkemail=this.myStudentRepository.findByEmail(student.getEmail());
		List<MyStudent> checkphone=this.myStudentRepository.findByPhone(student.getPhone());
		MyStudent s=new MyStudent();
		System.out.println(student);
		if (checkemail.isEmpty()) {
			System.out.println("email is not found");
			if (checkphone.isEmpty()) {
				System.out.println("phone is not found");
				student=this.myStudentRepository.save(s.createMyStudent(student));
				System.out.println("now insert record::::"+student);
			}else {
				
				student=this.myStudentRepository.getStudentByphone(student.getPhone());	
				System.out.println("phone is found " +student);
			}
		}else {
			
			student=this.myStudentRepository.getStudentByemail(student.getEmail());
			System.out.println("email is found "+student);
		}
		return student;
	}

	@Override
	public List<MyStudent> getAllStudnets() {
		return this.myStudentRepository.findAll();
	}

	@Override
	public MyStudent updateMyStudent(String utr,long id) {
		MyStudent student=this.myStudentRepository.getById(id);
		student.setId(id);
		student.setUtr(utr);
		return this.myStudentRepository.save(student);
	}

}
