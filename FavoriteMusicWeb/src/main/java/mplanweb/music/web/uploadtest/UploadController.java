package mplanweb.music.web.uploadtest;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 */
@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(UploadController.class);

	private UploadServiceImpl uploadserviceImpl;

	// 싱글

	@RequestMapping("/fileuploadsingle")
	public String fileUploadForm() {
		return "upload/upload";
	}

	// 싱글
	@RequestMapping(value = "/fileuploads", produces = "application/json")
	@ResponseBody
	public Upload fileUploads(
			MultipartHttpServletRequest request) throws Exception {

		// ///////////////////////////////////////////////////////////////////////
		// Text Request => 값가지고 오기 (Html name=[name] ===> String [name]
		// ///////////////////////////////////////////////////////////////////////
		String artist = request.getParameter("artist"); // 아티스트 이름 Request
		String title = request.getParameter("title"); // 음원제목 Request
		String album = request.getParameter("album"); // 앨범명 Request
		String lyric = request.getParameter("lyric"); // 가사 Request
		String year = request.getParameter("year"); // 년도 Request
		String corp = request.getParameter("corp"); // 레이블 Request

		// ///////////////////////////////////////////////////////////////////////
		// 업로드 파일 Request Html File name=[getFile] ==> MultipartFile = [getFile]
		// ///////////////////////////////////////////////////////////////////////
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m320kupload");
		MultipartFile m192k = request.getFile("m192kupload");

		// ///////////////////////////////////////////////////////////////////////
		// Hashmap 생성
		// ///////////////////////////////////////////////////////////////////////
		HashMap<String, Object> result = new HashMap<String, Object>();

		// ///////////////////////////////////////////////////////////////////////
		// 이미지 업로드 처리
		// ///////////////////////////////////////////////////////////////////////
		if (mimg != null) {

			// ///////////////////////////////////////////////////////////////////////
			// getname(파라미터이름), getoriginalfilename(파일이름), getcontenttype(파일속성),
			// getsize (파일사이즈)
			// ///////////////////////////////////////////////////////////////////////
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
			String uploadimgPath = "E://upload//img//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일사이즈 0이 아니라면... 업로드
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + uploadFimgName));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일다운 파라미터 생성
			// ///////////////////////////////////////////////////////////////////////
			String downlinkimg = "fileDownloads2?of="
					+ URLEncoder.encode(fimgName, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadFimgName, "UTF-8");

			// ///////////////////////////////////////////////////////////////////////
			// Hashput 입력
			// ///////////////////////////////////////////////////////////////////////
			result.put("pimgName", pimgName);
			result.put("fimgName", fimgName);
			result.put("imgcontentType", imgcontentType);
			result.put("imgsize", imgsize);
			result.put("uploadFimgName", uploadFimgName);
			result.put("uploadimgPath", uploadimgPath);
			result.put("downlinkimg", downlinkimg);
			// ///////////////////////////////////////////////////////////////////////
			// 절되었는지 log
			// ///////////////////////////////////////////////////////////////////////
			logger.info("pimgName : " + pimgName);
			logger.info("fimgName : " + fimgName);
			logger.info("imgcontentType : " + imgcontentType);
			logger.info("imgsize : " + imgsize);
			logger.info("uploadFimgName : " + uploadFimgName);
			logger.info("uploadimgPath : " + uploadimgPath);
			logger.info("downlinkimg : " + downlinkimg);
		
		}

		// ///////////////////////////////////////////////////////////////////////
		// 192K 업로드 처리
		// ///////////////////////////////////////////////////////////////////////
		if (m192k != null) {

			// ///////////////////////////////////////////////////////////////////////
			// getname(파라미터이름), getoriginalfilename(파일이름), getcontenttype(파일속성),
			// getsize (파일사이즈)
			// ///////////////////////////////////////////////////////////////////////
			String p192Name = m192k.getName();
			String f192Name = m192k.getOriginalFilename();
			String m192contentType = m192k.getContentType();
			long m192size = m192k.getSize();

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일명 UUID변경 (임의 랜덤 파일이름 변경)
			// ///////////////////////////////////////////////////////////////////////
			String uploadF192Name = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ f192Name.substring(f192Name.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload 폴더위치 설정
			// ///////////////////////////////////////////////////////////////////////
			String upload192Path = "E://upload//music192k//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일사이즈 0이 아니라면... 업로드
			// ///////////////////////////////////////////////////////////////////////
			if (m192k.getSize() != 0) {
				m192k.transferTo(new File(upload192Path + "/" + uploadF192Name));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일다운 파라미터 생성
			// ///////////////////////////////////////////////////////////////////////
			String downlink192k = "fileDownloads2?of="
					+ URLEncoder.encode(f192Name, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadF192Name, "UTF-8");

			// ///////////////////////////////////////////////////////////////////////
			// Hashput 입력
			// ///////////////////////////////////////////////////////////////////////
			result.put("p192Name", p192Name);
			result.put("f192Name", f192Name);
			result.put("m192contentType", m192contentType);
			result.put("m192size", m192size);
			result.put("uploadF192Name", uploadF192Name);
			result.put("upload192Path", upload192Path);
			result.put("downlink192k", downlink192k);
			// ///////////////////////////////////////////////////////////////////////
			// 절되었는지 log
			// ///////////////////////////////////////////////////////////////////////
			logger.info("p192Name : " + p192Name);
			logger.info("f192Name : " + f192Name);
			logger.info("m192contentType : " + m192contentType);
			logger.info("m192size : " + m192size);
			logger.info("uploadF192Name : " + uploadF192Name);
			logger.info("upload192Path : " + upload192Path);
			logger.info("downlink192k : " + downlink192k);
	
		}
		// ///////////////////////////////////////////////////////////////////////
		// 320k 음원 업로드 처리
		// ///////////////////////////////////////////////////////////////////////
		if (m320k != null) {

			// ///////////////////////////////////////////////////////////////////////
			// getname(파라미터이름), getoriginalfilename(파일이름), getcontenttype(파일속성),
			// getsize (파일사이즈)
			// ///////////////////////////////////////////////////////////////////////
			String p320Name = m320k.getName();
			String f320Name = m320k.getOriginalFilename();
			String m320contentType = m320k.getContentType();
			long m320size = m320k.getSize();

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일명 UUID변경 (임의 랜덤 파일이름 변경)
			// ///////////////////////////////////////////////////////////////////////
			String uploadF320Name = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ f320Name.substring(f320Name.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload 폴더위치 설정
			// ///////////////////////////////////////////////////////////////////////
			String upload320Path = "E://upload//music320k//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일사이즈 0이 아니라면... 업로드
			// ///////////////////////////////////////////////////////////////////////
			if (m320k.getSize() != 0) {
				m320k.transferTo(new File(upload320Path + "/" + uploadF320Name));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Upload 파일다운 파라미터 생성
			// ///////////////////////////////////////////////////////////////////////
			String downlink320k = "fileDownloads2?of="
					+ URLEncoder.encode(f320Name, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadF320Name, "UTF-8");

			// ///////////////////////////////////////////////////////////////////////
			// Hashput 입력
			// ///////////////////////////////////////////////////////////////////////
			result.put("p320Name", p320Name);
			result.put("f320Name", f320Name);
			result.put("m320contentType", m320contentType);
			result.put("m320size", m320size);
			result.put("uploadF320Name", uploadF320Name);
			result.put("upload320Path", upload320Path);
			result.put("downlink320k", downlink320k);
			// ///////////////////////////////////////////////////////////////////////
			// 절되었는지 log
			// ///////////////////////////////////////////////////////////////////////
			logger.info("p320Name : " + p320Name);
			logger.info("f320Name : " + f320Name);
			logger.info("m320contentType : " + m320contentType);
			logger.info("m320size : " + m320size);
			logger.info("uploadF320Name : " + uploadF320Name);
			logger.info("upload320Path : " + upload320Path);
			logger.info("downlink320k : " + downlink320k);
	
		}

		// ///////////////////////////////////////////////////////////////////////
		// Hashput 입력
		// ///////////////////////////////////////////////////////////////////////
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
		logger.info("result : " + result);
		logger.info("p320Name : " + result);
		
		
		//String a = result.get("artist").toString();
		//String a = result.get("title").toString();
		//String a = result.get("album").toString();
		//String a = result.get("lyric").toString();
		//String a = result.get("year").toString();
		//String a = result.get("corp").toString();
		//String a = result.get("fimgName").toString();
		//String a = result.get("p320Name").toString();
		//String a = result.get("m320size").toString();
		return uploadserviceImpl.uploadfile(result);
	
		//System.out.println(a);
		// ///////////////////////////////////////////////////////////////////////
		// Test Hashmap => ArrayList => DAO => mybatis
		// ///////////////////////////////////////////////////////////////////////
		
	
		
		//uploadService.uploadfile(list);

		//logger.info("list : " + list.size());
		//logger.info("list : " + list);
		//for(int i = 0; i <list.size(); i++){
		//	logger.info("list : " + i);
		//logger.info("list : " + list.get(i).get("fimgName"));
		//}
		
		//logger.info("list : " + list);
	
		/*
		try {
			uploadService.uploadfile(list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		*/
		
		//uploadService.uploadfile(list);
		
		
		
		// ///////////////////////////////////////////////////////////////////////
		// Result Return
		// ///////////////////////////////////////////////////////////////////////
		//return result;

	}

	@RequestMapping("/filedownloads")
	public ModelAndView fileDownloads(HttpServletRequest request)
			throws Exception {
		String f = request.getParameter("f");

		f = new String(f.getBytes("ISO8859_1"), "UTF-8");

		// String path = request.getServletContext().getRealPath("uploadFile");

		logger.info("f : " + f);
		// logger.info(of);

		String mimgPath = "E://upload//img//";
		//String m320Path = "E://upload//music192k//";
		//String m192Path = "E://upload//music320k//";
		logger.info("mimgPath : " + mimgPath);
		//logger.info("m320Path : " + m320Path);
		//logger.info("m192Path : " + m192Path);

		String fullPath = mimgPath + f;
		//String fullPath2 = m320Path + f;
		//String fullPath3 = m192Path + f;
		logger.info("fullPath : " + fullPath);
		//logger.info("fullPath2 : " + fullPath2);
		//logger.info("fullPath3 : " + fullPath3);
		File downloadFile1 = new File(fullPath);
		//File downloadFile2 = new File(fullPath2);
		//File downloadFile3 = new File(fullPath3);

		// ModelAndView mp = new ModelAndView("download", "downloadFile",
		// downloadFile1);

		// String mp;

		return new ModelAndView("download", "downloadFile1", downloadFile1);
	}
	
	@RequestMapping("/fileDownloads2")
	public void fileDownload2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//===전달 받은 정보를 가지고 파일객체 생성(S)===//
		
		String f = request.getParameter("f"); //저장된 파일이름
		String of = request.getParameter("of"); //원래 파일이름
		of = new String(of.getBytes("ISO8859_1"),"UTF-8"); 
		//서버설정(server.xml)에 따로 인코딩을 지정하지 않았기 때문에 get방식으로 받은 값에 대해 인코딩 변환
		
		logger.info("f : " + f);
		logger.info("of : " + of);

		
		//웹사이트 루트디렉토리의 실제 디스크상의 경로 알아내기.
		String mimgPath = "E://upload//img//";
		String m320Path = "E://upload//music192k//";
		String m192Path = "E://upload//music320k//";
		//String path = request.getSession().getServletContext().getRealPath("upload");
		//String path = WebUtils.getRealPath(request.getServletContext(), "upload");		
		//String path = "D:\\upload\\";		
		
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
		//===전달 받은 정보를 가지고 파일객체 생성(E)===//
		
		
		//파일 다운로드를 위해 컨테츠 타입을 application/download 설정
		//response.setContentType("application/download; charset=utf-8");
				
		//파일 사이즈 지정
		response.setContentLength((int)downloadFile1.length());
		response.setContentLength((int)downloadFile2.length());
		response.setContentLength((int)downloadFile3.length());
		//다운로드 창을 띄우기 위한 헤더 조작
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
										+ new String(of.getBytes(), "ISO8859_1"));
		
		response.setHeader("Content-Transfer-Encoding","binary");
		/*
		 * Content-disposition 속성
		 * 1) "Content-disposition: attachment" 브라우저 인식 파일확장자를 포함하여 모든 확장자의 파일들에 대해
		 *                          , 다운로드시 무조건 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다
		 * 2) "Content-disposition: inline" 브라우저 인식 파일확장자를 가진 파일들에 대해서는 
		 *                                  웹브라우저 상에서 바로 파일을 열고, 그외의 파일들에 대해서는 
		 *                                  "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다.
		 */
		
		FileInputStream fin = new FileInputStream(downloadFile1);
		//FileInputStream fin2 = new FileInputStream(downloadFile2);
		//FileInputStream fin3 = new FileInputStream(downloadFile3);
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
