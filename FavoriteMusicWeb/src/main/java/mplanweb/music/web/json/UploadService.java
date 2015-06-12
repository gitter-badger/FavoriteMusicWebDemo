package mplanweb.music.web.json;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private Map<String, UploadFile> uploadFilesMap;
	
	public UploadService(){
		init();
	}
	
	private void init(){
		uploadFilesMap = new HashMap<String, UploadFile>();
		
		
	}
	
	public UploadFile get(String id){
		return uploadFilesMap.get(id);
		
	}
	
	
	public UploadFile save(MultipartFile multipartFile){
		
		
		
		// 랜덤
		String genId = UUID.randomUUID().toString();
		UploadFile uploadFile = null;
		
		try {
			String savedFileName = saveToFile(multipartFile, genId);
			
			uploadFile = new UploadFile(genId, multipartFile.getContentType(), (int)multipartFile.getSize(), savedFileName);
			
			uploadFilesMap.put(genId, uploadFile);
			
		} catch (IOException e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		return uploadFile;
	}
	
	private String saveToFile(MultipartFile src, String id) throws IOException{
		
		String fileName = src.getOriginalFilename();
		byte[] bytes = src.getBytes();
		String saveFileName = id + "." + getExtension(fileName);
		String savePath = UploadFile.Img_dir + saveFileName;
		String savePath2 = UploadFile.Music192k_dir + saveFileName;
		String savePath3 = UploadFile.Music320k_dir + saveFileName;
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));
		bos.write(bytes);
		bos.flush();
		bos.close();
		
		return saveFileName;
	}
	
	private String getExtension(String fileName){
		int dotPosition = fileName.lastIndexOf(".");
		
		if(-1 != dotPosition && fileName.length() - 1 > dotPosition){
			return fileName.substring(dotPosition + 1); 
		}else{
			return "";
		}
	}
	
}
