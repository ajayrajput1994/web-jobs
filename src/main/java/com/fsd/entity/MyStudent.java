package com.fsd.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_student")
public class MyStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String phone;
	private String center_no;
	private String parents_name;
	private String parents_no;
	private String qualification;
	private String course;
	private String utr;
	private String date=newDate();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCenter_no() {
		return center_no;
	}
	public void setCenter_no(String center_no) {
		this.center_no = center_no;
	}
	public String getParents_name() {
		return parents_name;
	}
	public void setParents_name(String parents_name) {
		this.parents_name = parents_name;
	}
	public String getParents_no() {
		return parents_no;
	}
	public void setParents_no(String parents_no) {
		this.parents_no = parents_no;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getUtr() {
		return utr;
	}
	public void setUtr(String utr) {
		this.utr = utr;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String newDate() {
		/* show to time like this 24 Sep 2023 01:44:50 PM*/
		Date date=new Date();
		String formate="dd MMM yyyy hh:mm:ss a";
		String timezone=null;
		SimpleDateFormat sdf= new SimpleDateFormat(formate);
		// default system timezone if passed null or empty
		if (timezone == null || "".equalsIgnoreCase(timezone.trim())) {
			timezone=Calendar.getInstance().getTimeZone().getID();
		}
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		return sdf.format(date);
		
	}
	public MyStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyStudent createMyStudent(MyStudent student) {
		MyStudent s=new MyStudent();
		s.setName(student.getName());
		s.setEmail(student.getEmail());
		s.setPhone(student.getPhone());
		s.setCenter_no(student.getCenter_no());
		s.setParents_name(student.getParents_name());
		s.setParents_no(student.getParents_no());
		s.setQualification(student.getQualification());
		s.setCourse(student.getCourse());
		s.setUtr(student.getUtr());
		s.setDate(student.getDate());
		return student;
	}
	 
	public MyStudent(long id, String name, String email, String phone, String center_no, String parents_name,
			String parents_no, String qualification, String course, String utr, String date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.center_no = center_no;
		this.parents_name = parents_name;
		this.parents_no = parents_no;
		this.qualification = qualification;
		this.course = course;
		this.utr = utr;
		this.date = date;
	}
	@Override
	public String toString() {
		return "MyStudent [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", center_no="
				+ center_no + ", parents_name=" + parents_name + ", parents_no=" + parents_no + ", qualification="
				+ qualification + ", course=" + course + ", utr=" + utr + ", date=" + date + "]";
	}
	 
	
	
}
