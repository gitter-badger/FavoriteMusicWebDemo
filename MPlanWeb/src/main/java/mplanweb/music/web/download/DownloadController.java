package mplanweb.music.web.download;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DownloadController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
	//파일 다운로드 방식2
	@RequestMapping("/fileDownload")
	public void fileDownload2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//===전달 받은 정보를 가지고 파일객체 생성(S)===//
		
		String f = request.getParameter("f"); //저장된 파일이름
		String of = request.getParameter("of"); //원래 파일이름
		of = new String(of.getBytes("ISO8859_1"),"UTF-8"); 
		//서버설정(server.xml)에 따로 인코딩을 지정하지 않았기 때문에 get방식으로 받은 값에 대해 인코딩 변환
		
		logger.info(f);
		logger.info(of);
		
		//웹사이트 루트디렉토리의 실제 디스크상의 경로 알아내기.
		String path = "E://upload//";
		//String path = request.getSession().getServletContext().getRealPath("upload");
		//String path = WebUtils.getRealPath(request.getServletContext(), "upload");		
		//String path = "D:\\upload\\";		
		
		String fullPath = path+"/"+f;
		
		logger.info("path :"+path);		
		logger.info("fullPath:" + fullPath);
		File downloadFile = new File(fullPath);
		
		//===전달 받은 정보를 가지고 파일객체 생성(E)===//
		
		
		//파일 다운로드를 위해 컨테츠 타입을 application/download 설정
		//response.setContentType("application/download; charset=utf-8");
				
		//파일 사이즈 지정
		response.setContentLength((int)downloadFile.length());
		
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

