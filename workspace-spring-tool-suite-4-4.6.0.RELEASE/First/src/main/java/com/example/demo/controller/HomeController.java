package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private UserRepository rep;
	
	@RequestMapping("/home")	
	public String home() {
		return "registration";
	}
	@RequestMapping("/")
	@ResponseBody
	public String empty() {
		return "Empty String";
	}
	@RequestMapping("/getData")
	public String getData(HttpServletRequest req) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//System.out.println(username+" "+password);
		
		HttpSession ses=req.getSession();
		ses.setAttribute("username",username);
		ses.setAttribute("password",password);
		return "home";
	}
	@RequestMapping("getLoginData")
	public ModelAndView getLoginData(@RequestParam("username") String username,@RequestParam("password") String password) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("username",username);
		mv.addObject("password",password);
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping("getUserData")
	public ModelAndView getUserData(User user) {
		ModelAndView mv=new ModelAndView();
		mv.addObject(user);
		mv.setViewName("home");
		rep.save(user);
		return mv;
	}
	
	
}
