package mplanweb.music.web.user.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mplanweb.music.web.user.bean.UserBean;
import mplanweb.music.web.user.service.UserService;
import mplanweb.musiv.web.etc.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model){
		model.addAttribute(Command.USER_KEY, new UserBean());
		return "user/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid UserBean userbean, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user/signup";
		}
		
		String authority = "ROLE_USER";
		
		userService.addUser(userbean);
		userService.addAuthority(userbean.getUserid(), authority);
		
		return "redirect:/user/welcome";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userid, String passwd, HttpServletRequest request)
			throws ServletException {
		userService.login(userid, passwd);
		return "user/login";

	}

}
