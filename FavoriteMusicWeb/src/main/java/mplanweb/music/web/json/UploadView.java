package mplanweb.music.web.json;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;


@Component("uploadView")
public class UploadView extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		UploadFile uploadFile = (UploadFile)model.get("uploadFile");
		
		res.setContentLength(uploadFile.getContentLength());
		res.setContentType(uploadFile.getContentType());
		
		byte[] bytes = readFile(uploadFile.getFileName());
		write(res, bytes);
	}
	
	private byte[] readFile(String fileName) throws IOException{
		String path = UploadFile.Img_dir + fileName;
		String path2 = UploadFile.Music192k_dir + fileName;
		String path3 = UploadFile.Music320k_dir + fileName;
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		int length = bis.available();
		byte[] bytes = new byte[length];
		bis.read(bytes);
		bis.close();
		
		return bytes;

	}
	
	private void write(HttpServletResponse res, byte[] bytes) throws IOException{
		OutputStream output = res.getOutputStream();
		output.write(bytes);
		output.flush();
	}

}
