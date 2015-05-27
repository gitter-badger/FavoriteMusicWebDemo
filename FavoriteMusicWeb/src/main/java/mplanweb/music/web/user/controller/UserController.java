package mplanweb.music.web.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	private UserService userService;

	@RequestMapping(value = "/user/duplicate")
	public String duplicateUser(HttpServletRequest request) {

		System.out.println("Test:::");

		String id = request.getParameter("userid");
		if (userService.duplicateUser(id)) {
			System.out.println("Ok");
		} else {
			System.out.println("No");
		}
		return "home";

	}

	@RequestMapping(value = "/user/getUserInfo", method=RequestMethod.GET)
	public String getUserInfo(ModelMap model, HttpServletRequest request) throws IOException{
		String userid = request.getParameter("userid");
		ArrayList list = null;
		try {
			if (userService.getUserInfo(userid) != null) {
				System.out.println(userid + "Choosed");
			
			 list = userService.getUserInfo(userid);
			}else{
				System.out.println("No");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		model.addAttribute("list", list);
		return "/user/joinus";

	}
	
	@RequestMapping(value = "/user/login", method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
}
