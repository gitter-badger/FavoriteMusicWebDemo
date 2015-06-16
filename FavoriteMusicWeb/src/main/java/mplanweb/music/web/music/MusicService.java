package mplanweb.music.web.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.web.servlet.ModelAndView;

public interface MusicService {


	public void artistinsert(Artist artist) ;
	public void albuminsert(Album album) ;
	public void Soundsourceinsert(Soundsource Soundsource) ;
}
