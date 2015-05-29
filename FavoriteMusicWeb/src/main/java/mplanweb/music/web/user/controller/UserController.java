package mplanweb.music.web.user.controller;

import java.nio.file.AccessDeniedException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mplanweb.music.web.etc.Command;
import mplanweb.music.web.user.bean.UserBean;
import mplanweb.music.web.user.mapper.Password;
import mplanweb.music.web.user.service.UserService;

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

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute(Command.USER_KEY, new UserBean());
		return "user/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Valid UserBean userbean, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/signup";
		}

		String authority = "ROLE_USER";

		userService.addUser(userbean);
		userService.addAuthority(userbean.getUserid(), authority);

		return "redirect:/user/main";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "user/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * String login(String userid, String passwd, HttpServletRequest request)
	 * throws ServletException { userService.login(userid, passwd); return
	 * "user/login";
	 * 
	 * }
	 */

	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public String editAccount(Principal principal, Model model) {
		UserBean userbean = userService.getUser(principal.getName());
		model.addAttribute(Command.USER_KEY, userbean);

		return "user/editAccount";
	}

	@RequestMapping(value = "/editAccount", method = RequestMethod.POST)
	public String editAccount(@Valid UserBean userbean,
			BindingResult bindingResult, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "user/editAccount";
		}

		userbean.setUserid(principal.getName());
		int check = userService.editAccount(userbean);

		if (check < 1) {
			try {
				throw new AccessDeniedException("현재 비밀번호가 틀립니다.");
			} catch (AccessDeniedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "redirect:/user/changePasswd";

	}

	@RequestMapping(value = "/changePasswd", method = RequestMethod.GET)
	public String changePasswd(Principal principal, Model model) {
		UserBean userbean = userService.getUser(principal.getName());
		
		model.addAttribute(Command.USER_KEY, userbean);
		model.addAttribute("password", new Password());
		
		return "user/changePasswd";

	}
	  @RequestMapping(value="/changePasswd", method=RequestMethod.POST)
	  public String changePasswd(@Valid Password password, 
			  BindingResult bindingResult, 
			  Model model,
			  Principal principal) {
		  
	    if (bindingResult.hasErrors()) {
	    	UserBean userbean = userService.getUser(principal.getName());
	    	model.addAttribute(Command.USER_KEY, userbean);
	    	
	    	return "user/changePasswd";
	    }
	    
	    int check = userService.changePasswd(password.getCurrentPasswd(), 
	    		password.getNewPasswd(), principal.getName());
	    
	    if (check < 1) {
	      try {
			throw new AccessDeniedException("현재 비밀번호가 틀립니다.");
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    } 
	    
	    return "redirect:/user/changePasswd_confirm";
	        
	  }
	    
	  @RequestMapping(value="/changePasswd_confirm", method=RequestMethod.GET)
	  public String changePasswd_confirm() {
	    return "user/changePasswd_confirm";
	  }
	    
	  @RequestMapping(value="/bye", method=RequestMethod.GET)
	  public String bye() {
	    return "user/bye";
	  }

	  @RequestMapping(value="/bye", method=RequestMethod.POST)
	  public String bye(String email, String passwd, HttpServletRequest req) 
			throws ServletException {
	    
	    UserBean userbean = userService.login(email, passwd);
	    userService.bye(userbean);
	    req.logout();
	    
	    return "redirect:/user/bye_confirm";
	  }

	  @RequestMapping(value="/bye_confirm", method=RequestMethod.GET)
	  public String bye_confirm() {
	    return "user/bye_confirm";	  
	  }
}

