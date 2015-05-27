package mplanweb.music.web.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@RequestMapping(value = "/duplicate")
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

	@RequestMapping(value = "/getUserInfo")
	public String getUserInfo(ModelMap model, HttpServletRequest request) {
		String userid = request.getParameter("userid");
		ArrayList list = null;

		if (userService.getUserInfo(userid) != null) {
			System.out.println(userid + "Choosed");

			list = userService.getUserInfo(userid);
		}
		model.addAttribute("list", list);
		return "/user/joinus";

	}
}
