package mplanweb.music.web.upload;

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
public class UploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(UploadController.class);

	@Autowired
	private UploadServiceImpl uploadServiceImpl;
	private UploadService uploadService;

	// 싱글

	@RequestMapping("/fileuploadsingle")
	public String fileUploadForm() {
		return "upload/upload";
	}

	// 멀티 파일 업로드 폼으로 이동
	@RequestMapping("/muti")
	public String fileUploadForm2() {

		return "upload/uploadmuti";
	}

	// 싱글
	@RequestMapping(value = "/fileuploads", produces = "application/json")
	@ResponseBody
	public HashMap<String, Object> fileUploads(
			MultipartHttpServletRequest request) throws Exception {
		// ///////////////////////////////////////////////////////////////////////
		// Hashmap 생성
		// ///////////////////////////////////////////////////////////////////////
		HashMap<String, Object> result = new HashMap<String, Object>();
		DateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		// ///////////////////////////////////////////////////////////////////////
		// Text Request => 값가지고 오기 (Html name=[name] ===> String [name]
		// ///////////////////////////////////////////////////////////////////////
		String artist = request.getParameter("artist"); // 아티스트 이름 Request
		String title = request.getParameter("title"); // 음원제목 Request
		String album = request.getParameter("album"); // 앨범명 Request
		String lyric = request.getParameter("lyric"); // 가사 Request
		// String year = request.getParameter("year"); // 년도 Request
		String corp = request.getParameter("corp"); // 레이블 Request
		String num = request.getParameter("num");
		//int num = Integer.parseInt("num"); // 아티스트 이름 Request
		logger.info("num : " + num);
		String label = request.getParameter("label"); // 음원제목 Request
		String yearset = request.getParameter("year"); // 년도 Request
		Date year = day.parse(yearset);
		
		String genre1 = request.getParameter("genre1"); // 음원제목 Request
		String genre2 = request.getParameter("genre2"); // 음원제목 Request
		String etc = request.getParameter("etc"); // 음원제목 Request
		String copyset = request.getParameter("copy"); // 음원제목 Request
		Date copy = dt.parse(copyset);
		String age = request.getParameter("age");
		//int age = Integer.parseInt("age"); // 음원제목 Request
		String RadioGroup1 = request.getParameter("RadioGroup1"); // 음원제목
																	// Request

		result.put("artist", artist);
		result.put("title", title);
		result.put("album", album);
		result.put("lyric", lyric);
		result.put("year", year);
		result.put("corp", corp);

		logger.info("Artist : " + artist);
		logger.info("title : " + title);
		logger.info("album : " + album);
		logger.info("lyric : " + lyric);
		logger.info("year : " + year);
		logger.info("corp : " + corp);

		// ///////////////////////////////////////////////////////////////////////
		// 업로드 파일 Request Html File name=[getFile] ==> MultipartFile = [getFile]
		// ///////////////////////////////////////////////////////////////////////
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m320kupload");
		MultipartFile m192k = request.getFile("m192kupload");

		// ///////////////////////////////////////////////////////////////////////
		// 이미지 업로드 처리
		// ///////////////////////////////////////////////////////////////////////
		if (mimg != null && m192k != null && m320k != null) {

			String pimgName = mimg.getName();
			String p192Name = m192k.getName();
			String p320Name = m320k.getName();

			String fimgName = mimg.getOriginalFilename();
			String f192Name = m192k.getOriginalFilename();
			String f320Name = m320k.getOriginalFilename();

			String imgcontentType = mimg.getContentType();
			String m192contentType = m192k.getContentType();
			String m320contentType = m320k.getContentType();

			long imgsize = mimg.getSize();
			long m192size = m192k.getSize();
			long m320size = m320k.getSize();

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일명 UUID변경 (임의 랜덤 파일이름 변경)
			// ///////////////////////////////////////////////////////////////////////
			String uploadFimgName = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ fimgName.substring(fimgName.lastIndexOf("."));
			String uploadF192Name = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ f192Name.substring(f192Name.lastIndexOf("."));
			String uploadF320Name = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ f320Name.substring(f320Name.lastIndexOf("."));

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
				mimg.transferTo(new File(uploadimgPath + "/" + uploadFimgName));
			}
			if (m192k.getSize() != 0) {
				m192k.transferTo(new File(upload192Path + "/" + uploadF192Name));
			}
			if (m320k.getSize() != 0) {
				m320k.transferTo(new File(upload320Path + "/" + uploadF320Name));
			}
			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일다운 파라미터 생성
			// ///////////////////////////////////////////////////////////////////////
			String downlinkimg = "fileDownloads2?of="
					+ URLEncoder.encode(fimgName, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadFimgName, "UTF-8");
			String downlink192k = "fileDownloads2?of="
					+ URLEncoder.encode(f192Name, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadF192Name, "UTF-8");
			String downlink320k = "fileDownloads2?of="
					+ URLEncoder.encode(f320Name, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadF320Name, "UTF-8");

			// ///////////////////////////////////////////////////////////////////////
			// Hashput 입력
			// ///////////////////////////////////////////////////////////////////////

			result.put("fimgName", fimgName);
			result.put("f192Name", f192Name);
			result.put("f320Name", f320Name);
			result.put("imgsize", imgsize);
			result.put("m192size", m192size);
			result.put("m320size", m320size);
			result.put("uploadFimgName", uploadFimgName);
			result.put("uploadF192Name", uploadF192Name);
			result.put("uploadF320Name", uploadF320Name);
			result.put("pimgName", pimgName);
			result.put("p192Name", p192Name);
			result.put("p320Name", p320Name);
			result.put("imgcontentType", imgcontentType);
			result.put("m192contentType", m192contentType);
			result.put("m320contentType", m320contentType);
			result.put("downlinkimg", downlinkimg);
			result.put("downlink192k", downlink192k);
			result.put("downlink320k", downlink320k);


			Uploadfile uploadfile = new Uploadfile();
			uploadfile.setArtist(artist);
			uploadfile.setTitle(title);
			uploadfile.setAlbum(album);
			uploadfile.setLyric(lyric);
			uploadfile.setYear(year);
			uploadfile.setCorp(corp);
			uploadfile.setFimgName(fimgName);
			uploadfile.setImgsize(imgsize);
			uploadfile.setUploadFimgName(uploadFimgName);
			uploadfile.setF192Name(f192Name);
			uploadfile.setM192size(m192size);
			uploadfile.setUploadF192Name(uploadF192Name);
			uploadfile.setF320Name(f320Name);
			uploadfile.setM320size(m320size);
			uploadfile.setUploadF320Name(uploadF320Name);
			uploadfile.setNum(num);
			uploadfile.setLabel(label);
			uploadfile.setGenre1(genre1);
			uploadfile.setGenre2(genre2);
			uploadfile.setEtc(etc);
			uploadfile.setCopy(copy);
			uploadfile.setAge(age);
			uploadfile.setRadioGroup1(RadioGroup1);

			uploadServiceImpl.upfile(uploadfile);

		}

		return result;
	}

	@RequestMapping("/fileDownloads2")
	public void fileDownload2(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// ===전달 받은 정보를 가지고 파일객체 생성(S)===//

		String f = request.getParameter("f"); // 저장된 파일이름
		String of = request.getParameter("of"); // 원래 파일이름
		of = new String(of.getBytes("ISO8859_1"), "UTF-8");
		// 서버설정(server.xml)에 따로 인코딩을 지정하지 않았기 때문에 get방식으로 받은 값에 대해 인코딩 변환

		logger.info("f : " + f);
		logger.info("of : " + of);

		// 웹사이트 루트디렉토리의 실제 디스크상의 경로 알아내기.
		String mimgPath = "E://upload//img//";
		String m320Path = "E://upload//music192k//";
		String m192Path = "E://upload//music320k//";
		// String path =
		// request.getSession().getServletContext().getRealPath("upload");
		// String path = WebUtils.getRealPath(request.getServletContext(),
		// "upload");
		// String path = "D:\\upload\\";

		logger.info("mimgPath : " + mimgPath);
		logger.info("m320Path : " + m320Path);
		logger.info("m192Path : " + m192Path);

		String fullPath = mimgPath + f;
		String fullPath2 = m320Path + f;
		String fullPath3 = m192Path + f;

		logger.info("fullPath : " + fullPath);
		logger.info("fullPath2 : " + fullPath2);
		logger.info("fullPath3 : " + fullPath3);

		File downloadFile1 = new File(fullPath);
		File downloadFile2 = new File(fullPath2);
		File downloadFile3 = new File(fullPath3);
		// ===전달 받은 정보를 가지고 파일객체 생성(E)===//

		// 파일 다운로드를 위해 컨테츠 타입을 application/download 설정
		// response.setContentType("application/download; charset=utf-8");

		// 파일 사이즈 지정
		response.setContentLength((int) downloadFile1.length());
		response.setContentLength((int) downloadFile2.length());
		response.setContentLength((int) downloadFile3.length());
		// 다운로드 창을 띄우기 위한 헤더 조작
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(of.getBytes(), "ISO8859_1"));

		response.setHeader("Content-Transfer-Encoding", "binary");
		/*
		 * Content-disposition 속성 1) "Content-disposition: attachment" 브라우저 인식
		 * 파일확장자를 포함하여 모든 확장자의 파일들에 대해 , 다운로드시 무조건 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다
		 * 2) "Content-disposition: inline" 브라우저 인식 파일확장자를 가진 파일들에 대해서는 웹브라우저
		 * 상에서 바로 파일을 열고, 그외의 파일들에 대해서는 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다.
		 */

		FileInputStream fin = new FileInputStream(downloadFile1);
		// FileInputStream fin2 = new FileInputStream(downloadFile2);
		// FileInputStream fin3 = new FileInputStream(downloadFile3);
		ServletOutputStream sout = response.getOutputStream();

		byte[] buf = new byte[1024];
		int size = -1;

		while ((size = fin.read(buf, 0, buf.length)) != -1) {
			sout.write(buf, 0, size);
		}

		fin.close();
		sout.close();

	}

}
