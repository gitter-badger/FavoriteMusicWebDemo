package mplanweb.music.web.test;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.test.Member;
import mplanweb.music.web.test.MemberDAOService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {

	@Autowired
	private MemberDAOService memberDAOService;

	private static final Logger logger = LoggerFactory
			.getLogger(MybatisController.class);

	// 시작화면
	@RequestMapping("/main")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome main", locale);

		// view 화면인 main.jsp에 DB로 부터 읽어온 데이터를 보여준다.
		ModelAndView result = new ModelAndView();
		// addObject View에 넘어가는 데이터
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("main");
		return result;

	}

	// insert 버튼 클릭시 값을 가져와서 result.jsp로 화면전환 해준다.
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request) {

		// HttpServletRequest를 이용하여 main.jsp로 부터 값을 가져온다. getParameter로는 id값을
		// 가져옴

		Member member = new Member();
		member.setName((String) request.getParameter("name"));
		member.setEmail((String) request.getParameter("email"));
		member.setPhone((String) request.getParameter("phone"));

		memberDAOService.insertMember(member);
		System.out.println("insert complet");

		// 아래부분은 select값을 result.jsp 파일에 보여주기 위해 또 사용
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("result");
		return result;

	}
}
