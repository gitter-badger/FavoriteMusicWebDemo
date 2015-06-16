package mplanweb.music.web;


import java.security.Principal;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//Main Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/index";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String Main4(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/test";
	}
	//admin Page
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String Admin(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/admin/index";
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String action(Locale locale, Model model) {
		logger.info("MainPage ==> ??? : ", locale);

		return "/admin/home";
	}
	@RequestMapping(value = "/blacklist", method = RequestMethod.GET)
	public String blacklist(Locale locale, Model model) {
		logger.info("MainPage ==> blacklist : ", locale);

		return "/admin/member/blacklist";
	}
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public String memberlist(Locale locale, Model model) {
		logger.info("MainPage ==> memberlist : ", locale);

		return "/admin/member/memberlist";
	}
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String group(Locale locale, Model model) {
		logger.info("MainPage ==> group : ", locale);

		return "/admin/member/group";
	}
	@RequestMapping(value = "/memberdel", method = RequestMethod.GET)
	public String memberdel(Locale locale, Model model) {
		logger.info("MainPage ==> memberdel : ", locale);

		return "/admin/member/memberdel";
	}

	//music
	@RequestMapping(value = "/musical", method = RequestMethod.GET)
	public String musical(Locale locale, Model model) {
		logger.info("MainPage ==> musical : ", locale);

		return "/admin/music/musical";
	}
	@RequestMapping(value = "/musicda", method = RequestMethod.GET)
	public String musicda(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : ", locale);

		return "/admin/music/musicda";
	}
	@RequestMapping(value = "/musicin", method = RequestMethod.GET)
	public String musicin(Locale locale, Model model) {
		logger.info("MainPage ==> musicin : ", locale);

		return "/admin/music/musicin";
	}
	@RequestMapping(value = "/musicup", method = RequestMethod.GET)
	public String musicup(Locale locale, Model model) {
		logger.info("MainPage ==> musicup : ", locale);

		return "/admin/music/musicup";
	}
	//radio
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		logger.info("MainPage ==> board : ", locale);

		return "/admin/radio/board";
	}
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String data(Locale locale, Model model) {
		logger.info("MainPage ==> data : ", locale);

		return "/admin/radio/data";
	}
	@RequestMapping(value = "/proin", method = RequestMethod.GET)
	public String proin(Locale locale, Model model) {
		logger.info("MainPage ==> proin : ", locale);

		return "/admin/radio/proin";
	}
	@RequestMapping(value = "/propage", method = RequestMethod.GET)
	public String propage(Locale locale, Model model) {
		logger.info("MainPage ==> propage : ", locale);

		return "/admin/radio/propage";
	}
	@RequestMapping(value = "/qsheet", method = RequestMethod.GET)
	public String qsheet(Locale locale, Model model) {
		logger.info("MainPage ==> qsheet : ", locale);

		return "/admin/radio/qsheet";
	}
	
	//fix
	@RequestMapping(value = "/adapi", method = RequestMethod.GET)
	public String adapi(Locale locale, Model model) {
		logger.info("MainPage ==> adapi : ", locale);

		return "/admin/fix/adapi";
	}
	@RequestMapping(value = "/admail", method = RequestMethod.GET)
	public String admail(Locale locale, Model model) {
		logger.info("MainPage ==> admail : ", locale);

		return "/admin/fix/admail";
	}
	@RequestMapping(value = "/adnotice", method = RequestMethod.GET)
	public String adnotice(Locale locale, Model model) {
		logger.info("MainPage ==> adnotice : ", locale);

		return "/admin/fix/adnotice";
	}
	@RequestMapping(value = "/adqna", method = RequestMethod.GET)
	public String adqna(Locale locale, Model model) {
		logger.info("MainPage ==> adqna : ", locale);

		return "/admin/fix/adqna";
	}
	@RequestMapping(value = "/adsns", method = RequestMethod.GET)
	public String adsns(Locale locale, Model model) {
		logger.info("MainPage ==> adsns : ", locale);

		return "/admin/fix/adsns";
	}
	//chart
	@RequestMapping(value = "/allchart", method = RequestMethod.GET)
	public String allchart(Locale locale, Model model) {
		logger.info("MainPage ==> allchart : ", locale);

		return "/admin/chart/allchart";
	}
	@RequestMapping(value = "/downchart", method = RequestMethod.GET)
	public String downchart(Locale locale, Model model) {
		logger.info("MainPage ==> downchart : ", locale);

		return "/admin/chart/downchart";
	}
	@RequestMapping(value = "/jchart", method = RequestMethod.GET)
	public String jchart(Locale locale, Model model) {
		logger.info("MainPage ==> jchart : ", locale);

		return "/admin/chart/jchart";
	}
	@RequestMapping(value = "/kchart", method = RequestMethod.GET)
	public String kchart(Locale locale, Model model) {
		logger.info("MainPage ==> kchart : ", locale);

		return "/admin/chart/kchart";
	}
	@RequestMapping(value = "/pchart", method = RequestMethod.GET)
	public String pchart(Locale locale, Model model) {
		logger.info("MainPage ==> pchart : ", locale);

		return "/admin/chart/pchart";
	}
	@RequestMapping(value = "/realchart", method = RequestMethod.GET)
	public String realchart(Locale locale, Model model) {
		logger.info("MainPage ==> realchart : ", locale);

		return "/admin/chart/realchart";
	}
	@RequestMapping(value = "/stchart", method = RequestMethod.GET)
	public String stchart(Locale locale, Model model) {
		logger.info("MainPage ==> stchart : ", locale);

		return "/admin/chart/stchart";
	}
	
	
}
