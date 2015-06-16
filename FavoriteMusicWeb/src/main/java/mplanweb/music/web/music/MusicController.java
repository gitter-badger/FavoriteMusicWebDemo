package mplanweb.music.web.music;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/*
 * M!Plan Fileupload
 * Method : UploadContoller.java
 * Author : M!Plan 
 * Date : 2015/06/01
 * Copyright : M!Plan lab (2015)
 * 문제점 : DB에 날짜가 안들어가서 수정해야됨.. 
 */
@Controller
public class MusicController {
	private static final Logger logger = LoggerFactory
			.getLogger(MusicController.class);

	@Autowired
	MusicServiceImpl musicserviceimpl;

	// Music 목록
	@RequestMapping("/")
	public String MusicLable() {
		return "";
	}

	// 저장
	@RequestMapping(value = "/artistinsert", produces = "application/json")
	@ResponseBody
	public void ArtistUpload(
			MultipartHttpServletRequest request) throws Exception {
		// ///////////////////////////////////////////////////////////////////////
		// Hashmap 생성
		// ///////////////////////////////////////////////////////////////////////


		// ///////////////////////////////////////////////////////////////////////
		// Text Request => 값가지고 오기 (Html name=[name] ===> String [name]
		// ///////////////////////////////////////////////////////////////////////
		String artist = request.getParameter("artist"); // 아티스트 이름 Request
		String debut = request.getParameter("debut"); // 음원제목 Request
		String content = request.getParameter("content"); // 앨범명 Request
		String label = request.getParameter("label"); // 가사 Request
		String RadioGroup1 = request.getParameter("RadioGroup1"); // 음원제목
																	// Request
		// ///////////////////////////////////////////////////////////////////////
		// 업로드 파일 Request Html File name=[getFile] ==> MultipartFile = [getFile]
		// ///////////////////////////////////////////////////////////////////////
		MultipartFile mimg = request.getFile("imgupload");
		// ///////////////////////////////////////////////////////////////////////
		// 이미지 업로드 처리
		// ///////////////////////////////////////////////////////////////////////
		if (mimg != null) {

			String pimgName = mimg.getName();
			String fimgName = mimg.getOriginalFilename();
			String imgcontentType = mimg.getContentType();
			long imgsize = mimg.getSize();

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일명 UUID변경 (임의 랜덤 파일이름 변경)
			// ///////////////////////////////////////////////////////////////////////
			String uploadFimgName = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ fimgName.substring(fimgName.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload 폴더위치 설정
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//artistimg//";
			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일사이즈 0이 아니라면... 업로드
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + uploadFimgName));
			}
	
	
			Artist artist1 = new Artist();
			artist1.setArtist(artist);
			artist1.setDebut(debut);
			artist1.setContent(content);
			artist1.setLabel(label);
			artist1.setFimgName(fimgName);
			artist1.setImgsize(imgsize);
			artist1.setUploadFimgName(uploadFimgName);
			artist1.setRadioGroup1(RadioGroup1);

			musicserviceimpl.artistinsert(artist1);

		}
	}
}
	