package mplanweb.music.web.music;


import java.util.List;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/allnew")
public class ListController {

	private static final Logger logger = LoggerFactory
			.getLogger(ListController.class);

	@Autowired
	private ListService listService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/allnew/allnew";
	}
	@RequestMapping(value = "/kpoplist", method = RequestMethod.GET)
	public String kpoplist(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/allnew/kpop";
	}
	@RequestMapping(value = "/poplist", method = RequestMethod.GET)
	public String poplist(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/allnew/pop";
	}
	@RequestMapping(value = "/ostlist", method = RequestMethod.GET)
	public String ostlist(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/allnew/ost";
	}
	@RequestMapping(value = "/jpoplist", method = RequestMethod.GET)
	public String jpoplist(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/allnew/jpop";
	}
	@RequestMapping(value = "/radiolist", method = RequestMethod.GET)
	public String radiolist(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/allnew/radio";
	}
	
	@RequestMapping(value = "/musiclist", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal listmusic(@RequestBody Listsearch listsearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		logger.info("listsearch" + listsearch);
		// 카운트 계산
		int totalCount = listService.listcount(listsearch);
		System.out.println("총 갯수 : " + totalCount);
		// 리스트 형식
		List<Listview> musiclist = listService.listview(listsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// 리턴
		return jsontotal;
	}
	@RequestMapping(value = "/musiclistkpop", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal kpoplistmusic(@RequestBody Listsearch listsearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		logger.info("listsearch" + listsearch);
		// 카운트 계산
		int totalCount = listService.listcount(listsearch);
		System.out.println("총 갯수 : " + totalCount);
		// 리스트 형식
		List<Listview> musiclist = listService.kpoplistview(listsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// 리턴
		return jsontotal;
	}

	@RequestMapping(value = "/musiclistpop", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal poplistmusic(@RequestBody Listsearch listsearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		logger.info("listsearch" + listsearch);
		// 카운트 계산
		int totalCount = listService.listcount(listsearch);
		System.out.println("총 갯수 : " + totalCount);
		// 리스트 형식
		List<Listview> musiclist = listService.poplistview(listsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// 리턴
		return jsontotal;
	}
	
	@RequestMapping(value = "/musiclistost", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal ostlistmusic(@RequestBody Listsearch listsearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		logger.info("listsearch" + listsearch);
		// 카운트 계산
		int totalCount = listService.listcount(listsearch);
		System.out.println("총 갯수 : " + totalCount);
		// 리스트 형식
		List<Listview> musiclist = listService.ostlistview(listsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// 리턴
		return jsontotal;
	}
	
	@RequestMapping(value = "/musiclistjpop", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal jpoplistmusic(@RequestBody Listsearch listsearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		logger.info("listsearch" + listsearch);
		// 카운트 계산
		int totalCount = listService.listcount(listsearch);
		System.out.println("총 갯수 : " + totalCount);
		// 리스트 형식
		List<Listview> musiclist = listService.jpoplistview(listsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// 리턴
		return jsontotal;
	}
	
	
	@RequestMapping(value = "/musiclistradio", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal radiolistmusic(@RequestBody Listsearch listsearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		logger.info("listsearch" + listsearch);
		// 카운트 계산
		int totalCount = listService.listcount(listsearch);
		System.out.println("총 갯수 : " + totalCount);
		// 리스트 형식
		List<Listview> musiclist = listService.radiolistview(listsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// 리턴
		return jsontotal;
	}
}
