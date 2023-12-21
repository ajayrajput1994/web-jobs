package com.fsd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsd.entity.MyStudent;
import com.fsd.service.MyStudentService;

@Controller
public class HomeController {
	@Autowired
	private MyStudentService myStudentService;

	/*
	 * @ModelAttribute public void getCommonData() { List<MyStudent>
	 * studens=this.myStudentService.getAllStudnets();
	 * 
	 * }
	 */
	@GetMapping({"","/","/hello"})
	public String home(Model m) {
		m.addAttribute("title","hello welcome");
		//getCommonData();
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Model m) {
		m.addAttribute("title","this is about");
		return "about";
	}
	
	@GetMapping("/full-stack")
	public String fullstack(Model m) {
		m.addAttribute("title","full stack developer");
		return "full-stack";
	}
	
	@GetMapping("/design-&-digital")
	public String degital(Model m) {
		m.addAttribute("title","full stack developer");
		return "digital";
	}
	@GetMapping("/admission-form")
	public String admissionform(Model m) {
		m.addAttribute("title","full stack developer");
		MyStudent student=new MyStudent();
		m.addAttribute("student",student);
		return "admission_form";
	}
	
	@GetMapping("/payment-method")
	public String payment(Model m) {
		m.addAttribute("title","full stack developer");
		
		return "payment_form";
	}
	@PostMapping("/admission-process")
	public String addStudent(@ModelAttribute("student") MyStudent student,Model m,HttpSession session) {
		m.addAttribute("title","payment method ");
		MyStudent s=this.myStudentService.addMyStudent(student);
		session.setAttribute("sid", s.getId());
		return "redirect:/payment-method";
	}
	
	@PostMapping("/payment-process")
	public String updateUtr(@RequestParam("utr") String utr, Model m,HttpSession session) {
		long sid=(long) session.getAttribute("sid");
		System.out.println("student id==="+sid+":::utr:"+utr);
		MyStudent student=this.myStudentService.updateMyStudent(utr,sid);
		System.out.println("update UTR id :::"+student);
		m.addAttribute("student",student);
		return "profile";
	}
	@GetMapping("/my-profile")
	public String profile(Model m) {
		return "profile";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("sid");
		return "redirect:/";
	}
	
}
