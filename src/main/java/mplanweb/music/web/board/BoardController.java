package mplanweb.music.web.board;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mplanweb.music.web.search.MsearchDTO;
import mplanweb.music.web.source.SsAlbum;
import mplanweb.music.web.source.Sscorp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardController.class);

	@Autowired
	private BoardService boardservice;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/main/board/boardwrite";
	}

	// 게시판 등록
	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView Boardwrite(@Valid BoardDTO boarddto,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		logger.info("num : " + boarddto);
		logger.info("title : " + boarddto);
		logger.info("content  : " + boarddto);

		ModelAndView mv = new ModelAndView();
		boarddto.setMp_boardnum(num);
		boarddto.setMp_contents(content);
		boarddto.setMp_title(title);
		boardservice.boardinsert(boarddto);

		mv.setViewName("redirect:/board/view");
		return mv;

	}

	// 게시판 뷰
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ResponseBody
	public String Boardview(@RequestBody BoardCount boardcount, Model model) {
		int totalcount = boardservice.boardcount(boardcount);
		System.out.println("totalcount" + totalcount );
		logger.info("총 카운트 : " + totalcount);
		List<BoardDTO> listview = boardservice.boardsearch(boardcount);
		System.out.println("listview" + listview );
		model.addAttribute("listview", listview);
		return "/main/board/boardview";
	}
	
	
	// 게시판 읽기
}
