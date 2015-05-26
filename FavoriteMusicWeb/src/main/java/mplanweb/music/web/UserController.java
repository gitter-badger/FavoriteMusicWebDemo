package mplanweb.music.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

		@Autowired
		private UserService userservice;
		
		@RequestMapping(value = "/user/duplicate")
		public String duplicateUser(HttpServletRequest request){
			
			System.out.println("Test:::");
			
			String id = request.getParameter("userid");
			if(userservice.duplicateUser(id)){
				System.out.println("Ok");
			}else{
				System.out.println("No");
			}
			return "home";
			
		}
		@RequestMapping(value = "/user/getUserInfo")
		public String getUserInfo(ModelMap model, HttpServletRequest request){
			String userid = request.getParameter("userid");
			ArrayList list = null;
			
			if(userservice.getUserInfo(userid) != null){
				System.out.println(userid + "Choosed");
				
				list = userservice.getUserInfo(userid);
			}
			model.addAttribute("list", list);
			return "/user/joinus";
			
			
			
			
			
			
		}
}
