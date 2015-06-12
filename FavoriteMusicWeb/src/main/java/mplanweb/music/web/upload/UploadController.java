package mplanweb.music.web.upload;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/*
 * 
 * 
 * 
 */

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory
			.getLogger(UploadController.class);

	private UploadDAO uploaddao;

	// Single Upload => Form
	@RequestMapping("/fileuploadsingle")
	public String fileUploadForm() {
		return "upload/upload";
	}

	// multi Upload => Form
	@RequestMapping("/mutiuploadmulti")
	public String fileUploadForm2() {
		return "upload/uploadmuti";
	}

	// Single Upload

	@RequestMapping(value = "/fileuploads", produces = "application/json")
	@ResponseBody
	public HashMap<String, Object> fileUploads(
			MultipartHttpServletRequest request) throws Exception {

		String artist = request.getParameter("artist"); // 아티스트 이름 Request
		String title = request.getParameter("title"); // 음원제목 Request
		String album = request.getParameter("album"); // 앨범명 Request
		String lyric = request.getParameter("lyric"); // 가사 Request
		String year = request.getParameter("year"); // 년도 Request
		String corp = request.getParameter("corp"); // 레이블 Request

		// Request 정확히 받냐 안받냐 Test
		System.out.println("아티스트 : " + artist);
		logger.info("아티스트 : " + artist);
		System.out.println("음원제목 : " + title);
		logger.info("음원제목 : " + title);
		System.out.println("앨범명 : " + album);
		logger.info("앨범명 : " + album);
		System.out.println("가사 : " + lyric);
		logger.info("가사 : " + lyric);
		System.out.println("년도 : " + year);
		logger.info("년도 : " + year);
		System.out.println("레이블 : " + corp);
		logger.info("레이블 : " + corp);

		HashMap<String, Object> result = new HashMap<String, Object>();

		// 업로드 파일 Request
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m192kupload");
		MultipartFile m192k = request.getFile("m320kupload");

		if (m320k != null) {
			// Request 업로드 정확히 받냐 안받냐 Test
			System.out.println("Parameter Name : " + mimg.getName());
			System.out.println("File Name : " + mimg.getOriginalFilename());
			System.out.println("File Size : " + mimg.getSize());

			System.out.println("Parameter Name : " + m320k.getName());
			System.out.println("File Name : " + m320k.getOriginalFilename());
			System.out.println("File Size : " + m320k.getSize());

			System.out.println("Parameter Name : " + m192k.getName());
			System.out.println("File Name : " + m192k.getOriginalFilename());
			System.out.println("File Size : " + m192k.getSize());

			String pimgName = mimg.getName();
			String fimgName = mimg.getOriginalFilename();
			String imgcontentType = mimg.getContentType();
			long imgsize = mimg.getSize();

			String p320Name = m320k.getName();
			String f320Name = m320k.getOriginalFilename();
			String m320contentType = m320k.getContentType();
			long m320size = m320k.getSize();
			
			String p192Name = m192k.getName();
			String f192Name = m192k.getOriginalFilename();
			String m192contentType = m192k.getContentType();
			long m192size = m192k.getSize();
			
			// Upload 파일명 uuid변경
			String uploadFimgName = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ fimgName.substring(fimgName.lastIndexOf("."));
			String uploadF320Name = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ f320Name.substring(f320Name.lastIndexOf("."));
			String uploadF192Name = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ f192Name.substring(f192Name.lastIndexOf("."));

			String uploadimgPath = "E://upload//img//";
			String upload320Path = "E://upload//music192k//";
			String upload192Path = "E://upload//music320k//";

			// String uploadPath =
			// request.getSession().getServletContext().getRealPath("upload");
			logger.info("File img = " + uploadimgPath);
			logger.info("File 320 = " + upload320Path);
			logger.info("File 192 = " + upload192Path);

			// 파일 저장
			if (m320k.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/"
						+ uploadFimgName));
				m320k.transferTo(new File(upload320Path + "/"
						+ uploadF320Name));
				m192k.transferTo(new File(upload192Path + "/"
						+ uploadF192Name));
			}

			result.put("paramname", pimgName);
			result.put("fileName", fimgName);
			result.put("uploadedFileName", uploadFimgName);
			result.put("fileSize", imgsize);
			result.put("contentType", imgcontentType);
			String downlinkimg = "fileDownloads?of="
					+ URLEncoder.encode(fimgName, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadFimgName, "UTF-8");
			result.put("downlink", downlinkimg);

			result.put("paramname", p320Name);
			result.put("fileName", f320Name);
			result.put("uploadedFileName", uploadF320Name);
			result.put("fileSize", m320size);
			result.put("contentType", m320contentType);
			String downlink320k = "fileDownloads?of="
					+ URLEncoder.encode(f320Name, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadF192Name, "UTF-8");
			result.put("downlink", downlink320k);

			result.put("paramname", p192Name);
			result.put("fileName", f192Name);
			result.put("uploadedFileName", uploadF192Name);
			result.put("fileSize", m192size);
			result.put("contentType", m192contentType);
			String downlink192k = "fileDownloads?of="
					+ URLEncoder.encode(f192Name, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadF192Name, "UTF-8");
			result.put("downlink", downlink192k);
			
			logger.info("downlinkimg= " + downlinkimg);
			logger.info("downlink320k= " + downlink320k);
			logger.info("downlink192k = " + downlink192k);
			
			
			
			//FileInfoModel2 file = new FileInfoModel2(pimgName, p320Name,  p192Name, fimgName, f320Name, f192Name, uploadFimgName, uploadF320Name, uploadF192Name,   
			//		imgsize, m320size, m192size, imgcontentType, m320contentType, m192contentType, downlinkimg, downlink320k, downlink192k);
			
			
			FileInfoModel2.FileInfoModel2(result);
	
			
		}

		// View Data Save

		result.put("artist", artist);
		result.put("title", title);
		result.put("album", album);
		result.put("lyric", lyric);
		result.put("year", year);
		result.put("corp", corp);
		return result;
		
		
		
	}

	// Multiupload upload

	@RequestMapping(value = "/fileuploadm", produces = "application/json")
	@ResponseBody
	public HashMap<String, Object> fileUpload(
			MultipartHttpServletRequest request) throws Exception {

		String artist = request.getParameter("artist"); // 아티스트 이름 Request
		String title = request.getParameter("title"); // 음원제목 Request
		String album = request.getParameter("album"); // 앨범명 Request
		String lyric = request.getParameter("lyric"); // 가사 Request
		String year = request.getParameter("year"); // 년도 Request
		String corp = request.getParameter("corp"); // 레이블 Request

		// Request 정확히 받냐 안받냐 Test
		// System.out.println("아티스트 : " + artist);
		// logger.info("아티스트 : " + artist);
		// System.out.println("음원제목 : " + title);
		// logger.info("음원제목 : " + title);
		// System.out.println("앨범명 : " + album);
		// logger.info("앨범명 : " + album);
		// System.out.println("가사 : " + lyric);
		// logger.info("가사 : " + lyric);
		// System.out.println("년도 : " + year);
		// logger.info("년도 : " + year);
		// System.out.println("레이블 : " + corp);
		// logger.info("레이블 : " + corp);

		HashMap<String, Object> result = new HashMap<String, Object>();

		// list
		// List<MultipartFile> mlist = request.getFiles("imgupload");
		// List<MultipartFile> mlist = request.getFiles("imgupload");
		List<MultipartFile> mlist = request.getFiles("uploadFile");

		// MultipartFile mfile = request.getFile("uploadFile");

		// logger.info("test : " + mlist.get(i).getName());
		// logger.info("test : " + mlist.get(i).getOriginalFilename());
		// logger.info("test : " + mlist.get(i).getSize());

		// 1번 레이 이미지
		String img = mlist.get(0).getOriginalFilename();
		long imgsize = mlist.get(0).getSize();
		logger.info("<======================================>");
		logger.info("img : " + img);
		logger.info("imgsize : " + imgsize);
		logger.info("<======================================>");
		// String imguuid = mlist.get(0).getOriginalFilename();
		// 2번 레인 320k
		String m320k = mlist.get(1).getOriginalFilename();
		long m320ksize = mlist.get(1).getSize();
		logger.info("<======================================>");
		logger.info("m320k : " + m320k);
		logger.info("m320ksize : " + m320ksize);
		logger.info("<======================================>");
		// 3번레인 192k
		String m192k = mlist.get(2).getOriginalFilename();
		long m192ksize = mlist.get(2).getSize();
		logger.info("<======================================>");
		logger.info("m192k : " + m192k);
		logger.info("m192ksize : " + m192ksize);
		logger.info("<======================================>");

		List<FileInfoModel> filelist = new ArrayList<FileInfoModel>();

		for (MultipartFile mfile : mlist) {
			// Request 업로드 정확히 받냐 안받냐 Test
			System.out.println(mlist);

			// logger.info("mlist : " + ((Object) mlist).getNum());
			// System.out.println("Parameter Name : " + mfile.getName());
			// System.out.println("File Name : " + mfile.getOriginalFilename());
			// System.out.println("File Size : " + mfile.getSize());

			String pName = mfile.getName();
			String fName = mfile.getOriginalFilename();
			String contentType = mfile.getContentType();

			// Upload 파일명 uuid변경
			String uploadFname = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ fName.substring(fName.lastIndexOf("."));

			String uploadPath = "E://upload//";
			// String uploadPath =
			// request.getSession().getServletContext().getRealPath("upload");
			// logger.info("File src = " + uploadPath);

			// 파일 저장
			if (mfile.getSize() != 0) {
				mfile.transferTo(new File(uploadPath + "/" + uploadFname));
			}

			String downlink = "fileDownloadm?of="
					+ URLEncoder.encode(fName, "UTF-8") + "&f="
					+ URLEncoder.encode(uploadFname, "UTF-8");
			FileInfoModel file = new FileInfoModel(pName, fName, uploadFname,
					mfile.getSize(), contentType, downlink);
			filelist.add(file);

		}
		result.put("artist", artist);
		result.put("title", title);
		result.put("album", album);
		result.put("lyric", lyric);
		result.put("year", year);
		result.put("corp", corp);
		result.put("file", filelist);

		// List<Map<String, Object>> mapList = new ArrayList<Map<String,
		// Object>>();
		// uploaddao.uploadfile(result);
		// logger.info("result : " + result);
		return result;

	}

	@RequestMapping("fileDownloads")
	public ModelAndView fileDownloads(HttpServletRequest request)
			throws Exception {
		String f = request.getParameter("f");
		String of = request.getParameter("of");
		of = new String(f.getBytes("ISO8859_1"), "UTF-8");

		//String path = request.getServletContext().getRealPath("uploadFile");
	
		logger.info(f);
		logger.info(of);

		
		

		String mimgPath = "E://upload//img//";
		String m320Path = "E://upload//music192k//";
		String m192Path = "E://upload//music320k//";
		logger.info(mimgPath);
		logger.info(m320Path);
		logger.info(m192Path);
		
		String fullPath = mimgPath + f;
		String fullPath2 = m320Path + f;
		String fullPath3 = m192Path + f;
		logger.info(fullPath);
		logger.info(fullPath2);
		logger.info(fullPath3);
		File downloadFile = new File(fullPath);
		File downloadFile2 = new File(fullPath2);
		File downloadFile3 = new File(fullPath3);
		
		
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	@RequestMapping("fileDownloadm")
	public void fileDownloadm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String f = request.getParameter("f");
		String of = request.getParameter("of");
		of = new String(of.getBytes("ISO8859_1"), "UTF-8");

		logger.info(f);
		logger.info(of);

		// String path = request.getServletContext().getRealPath("uploadFile");
		// String path =
		// request.getSession().getServletContext().getRealPath("upload");
		// String path = WebUtils.getRealPath(request.getServletContext(),
		// "upload");
		String path = "E://upload//";

		String fullPath = path + "/" + f;

		logger.info("path : " + path);
		logger.info("fullPath : " + fullPath);
		File downloadFile = new File(fullPath);

		// response.setContentType("application/download; charset=utf-8");

		response.setContentLength((int) downloadFile.length());

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

		FileInputStream fin = new FileInputStream(downloadFile);
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
