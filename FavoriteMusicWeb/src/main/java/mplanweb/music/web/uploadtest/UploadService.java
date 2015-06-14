package mplanweb.music.web.uploadtest;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;

public interface UploadService {
	//public Upload uploadfile(Upload result);


	public Upload uploadfile(HashMap<String, Object> result);
}
