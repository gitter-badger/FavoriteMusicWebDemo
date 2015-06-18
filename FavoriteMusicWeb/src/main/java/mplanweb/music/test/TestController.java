package mplanweb.music.test;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import mplanweb.music.web.admin.WebController;
import mplanweb.music.web.board.ResultJSON;
import mplanweb.music.web.board.YKStringUtil;
import mplanweb.music.web.board.Yboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/*
 * 
 * Title : 음원관리 컨트롤러
 * Author : 김정훈 (2015.05.15)
 *
 * 
 * 
 * 
 */

@Controller
@RequestMapping("/appler")
public class TestController {

	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);

	@Autowired
	private MusicService musicService;

	// /////////////////////////////////////////////////////////////////////////
	// //
	// main =========> musicview =========> ssview.jsp //
	// 음원관리 //
	// /////////////////////////////////////////////////////////////////////////
	// //
	@RequestMapping(value = "/ssview", method = RequestMethod.GET)
	public String SsView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		 model.addAttribute("ssearch", new Ssearch());
		return "/mplan/ssview";
	}

	// ///////////////////////////////////////////////////////////////////////
	// //
	// main =========> musicview =========> ssview.jsp //
	// 회사관리 //
	// ///////////////////////////////////////////////////////////////////////
	// //
	@RequestMapping(value = "/corpview", method = RequestMethod.GET)
	public String CorpView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/mplan/corpview";
	}

	// ///////////////////////////////////////////////////////////////////////
	// //
	// main =========> musicview =========> ssview.jsp //
	// 앨범관리 //
	// ///////////////////////////////////////////////////////////////////////
	// //
	@RequestMapping(value = "/albumview", method = RequestMethod.GET)
	public String AlbumView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/mplan/albumview";
	}

	// ///////////////////////////////////////////////////////////////////////
	// //
	// main =========> musicview =========> ssview.jsp //
	// 레이블관리 //
	// ///////////////////////////////////////////////////////////////////////
	// //
	@RequestMapping(value = "/labelview", method = RequestMethod.GET)
	public String LabelView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/mplan/labelview";
	}

	// ///////////////////////////////////////////////////////////////////////
	// //
	// main =========> musicview =========> ssview.jsp //
	// 아티스트 관리 //
	// ///////////////////////////////////////////////////////////////////////
	// //
	@RequestMapping(value = "/artistview", method = RequestMethod.GET)
	public String ArtistView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/mplan/artistview";
	}

	// ///////////////////////////////////////////////////////////////////////
	// //
	// main =========> musicview =========> ssview.jsp //
	// 정산관리 //
	// ///////////////////////////////////////////////////////////////////////
	// //
	@RequestMapping(value = "/musicview", method = RequestMethod.GET)
	public String MusicView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/mplan/ssview";
	}

	// ///////////////////////////////////////////////////////////////////////
	// //
	// SSview select //
	// ///////////////////////////////////////////////////////////////////////
	// //

	@RequestMapping(value = "/ssviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal ssviewselect(@RequestBody Ssearch ssearch) {
		// Json 형식으로 변환할려고 생성 parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		// 카운트 계산
		System.out.println("ssearch : " + ssearch);
		int totalCount = musicService.selecttotalcount(ssearch);
		System.out.println("totalCount : " + totalCount);
		// 리스트 형식
		List<Ssview> musiclist = musicService.selectSsview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		System.out.println("Jsontotal : " + jsontotal);
		System.out.println("musiclist : " + musiclist);
		jsontotal.setSuccess(true);
		System.out.println("musiclist : " + musiclist);
		System.out.println("Jsontotal : " + jsontotal);
		// 리턴
		return jsontotal;
	}

	@RequestMapping(value = "/viewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal ViewSelect(@PathVariable String mpssnumEncrypt) {
		System.out.println("mpssnumEncrypt : " + mpssnumEncrypt);
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_mpnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewSSview(map));
		System.out.println("jsontotal : " + jsontotal);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	@RequestMapping(value = "/ssviewinsert", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal insertssview(@RequestBody Ssview ssview) {
		System.out.println("ssview : " + ssview);
		Jsontotal jsontotal = new Jsontotal();
		musicService.insertssearch(ssview);
		System.out.println("Jsontotal : " + jsontotal);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	/*
	@RequestMapping(value = "/ssviewinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertssview(MultipartHttpServletRequest request) throws Exception {
	
		int mp_num = Integer.parseInt(request.getParameter("num")); // 아티스트 이름 Request
		String mp_artist = request.getParameter("artist"); // 음원제목 Request
		String mp_title = request.getParameter("title"); // 앨범명 Request
		String mp_album = request.getParameter("album"); // 가사 Request
		String mp_lyric = request.getParameter("lyric"); // 아티스트 이름 Request
		String mp_label = request.getParameter("label"); // 음원제목 Request
		String mp_corp = request.getParameter("corp"); // 앨범명 Request
		String mp_year = request.getParameter("year"); // 가사 Request
		String mp_genre1 = request.getParameter("genre1"); // 아티스트 이름 Request
		String mp_genre2 = request.getParameter("genre2"); // 음원제목 Request
		String mp_etc = request.getParameter("etc"); // 앨범명 Request
		String mp_open_date = request.getParameter("copy"); // 가사 Request
		String mp_age = request.getParameter("age"); // 아티스트 이름 Request
		String mp_useyn = request.getParameter("RadioGroup1"); // 음원제목 Request
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m320kupload");
		MultipartFile m192k = request.getFile("m192kupload");
		Jsontotal jsontotal = new Jsontotal();
			if (mimg != null && m192k != null && m192k != null) {

				String mp_img = mimg.getOriginalFilename();
				String mp_192k = m192k.getOriginalFilename();
				String mp_320k = m320k.getOriginalFilename();
				long mp_imgsize = mimg.getSize();
				long mp_192size = m192k.getSize();
				long mp_320size = m320k.getSize();

				// ///////////////////////////////////////////////////////////////////////
				// Upload 파일명 UUID변경 (임의 랜덤 파일이름 변경)
				// ///////////////////////////////////////////////////////////////////////
				String mp_imgo = System.currentTimeMillis()
						+ UUID.randomUUID().toString()
						+ mp_img.substring(mp_img.lastIndexOf("."));
				String mp_320ko = System.currentTimeMillis()
						+ UUID.randomUUID().toString()
						+ mp_320k.substring(mp_320k.lastIndexOf("."));
				String mp_192ko = System.currentTimeMillis()
						+ UUID.randomUUID().toString()
						+ mp_192k.substring(mp_192k.lastIndexOf("."));

				// ///////////////////////////////////////////////////////////////////////
				// Upload 폴더위치 설정
				// ///////////////////////////////////////////////////////////////////////
				String uploadimgPath = "E://upload//img//";
				String upload192Path = "E://upload//music192k//";
				String upload320Path = "E://upload//music320k//";

				// ///////////////////////////////////////////////////////////////////////
				// Upload 파일사이즈 0이 아니라면... 업로드
				// ///////////////////////////////////////////////////////////////////////
				if (mimg.getSize() != 0) {
					mimg.transferTo(new File(uploadimgPath + "/" + mp_imgo));
				}
				if (m192k.getSize() != 0) {
					m192k.transferTo(new File(upload192Path + "/" + mp_320ko));
				}
				if (m320k.getSize() != 0) {
					m320k.transferTo(new File(upload320Path + "/" + mp_192ko));
				}
	
				
				// ///////////////////////////////////////////////////////////////////////
				// Hashput 입력
				// ///////////////////////////////////////////////////////////////////////
		
				Ssview ssview = new Ssview();
				ssview.setMp_img(mp_img);
				ssview.setMp_320k(mp_320k);
				ssview.setMp_192k(mp_192k);
				ssview.setMp_imgsize(mp_imgsize);
				ssview.setMp_320size(mp_320size);
				ssview.setMp_192size(mp_192size);
				ssview.setMp_imgo(mp_imgo);
				ssview.setMp_320ko(mp_320ko);
				ssview.setMp_192ko(mp_192ko);
				ssview.setMp_num(mp_num);
				ssview.setMp_artist(mp_artist);
				ssview.setMp_title(mp_title);
				ssview.setMp_album(mp_album);
				ssview.setMp_lyric(mp_lyric);
				ssview.setMp_label(mp_label);
				ssview.setMp_corp(mp_corp);
				ssview.setMp_year(mp_year);
				ssview.setMp_genre1(mp_genre1);
				ssview.setMp_genre2(mp_genre2);
				ssview.setMp_etc(mp_etc);
				ssview.setMp_open_date(mp_open_date);
				ssview.setMp_age(mp_age);
				ssview.setMp_useyn(mp_useyn);

				
				musicService.insertssearch(ssview);
				System.out.println("Jsontotal : " + jsontotal);
				jsontotal.setSuccess(true);

			}
			
	
		return jsontotal;
	}
	*/
	
	@RequestMapping(value = "/ssviewdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletessview(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_mpnum"));
		System.out.println("mp_mpnum : " + mp_mpnum);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mpnum.split(",");
		
		for (String mpssnumEncrypt: mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_mpnum", MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deletessearch(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	
	
}
