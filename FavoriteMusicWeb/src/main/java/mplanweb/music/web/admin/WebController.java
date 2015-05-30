package mplanweb.music.web.admin;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	//private MainService mainservice;

	@RequestMapping("/login.do")
	public void login(@RequestParam Map<String, Object> paramMap, ModelMap model)
			throws Throwable {

	}

	@RequestMapping("/loginFail.do")
	public void loginFail(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {

	}

	@RequestMapping("/main.do")
	public void main(@RequestParam Map<String, Object> paramMap,
			ModelMap model, Principal principal) throws Throwable {

		// 로그인 후 로그인 한 아이디를 가지고 온다.
		String name = principal.getName();

		model.addAttribute("username", name);

	}

	@RequestMapping("/logout.do")
	public void logout(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {

	}
}
