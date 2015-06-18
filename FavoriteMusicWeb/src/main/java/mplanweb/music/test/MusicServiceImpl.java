package mplanweb.music.test;

import java.util.List;


import java.util.Map;




import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	private MusicDAO musicDAO;

	@Override
	public int selecttotalcount(Ssearch ssearch) {
		return musicDAO.selecttotalcount(ssearch);

	}


	@Override
	public List<Ssview> selectSsview(Ssearch ssearch) {

		return musicDAO.selectSsview(ssearch);
	}
	

	@Override
	public Ssview viewSSview(Map<String, Object> map) {
		return musicDAO.viewSSview(map);
	}


	@Override
	public int insertssearch(Ssview ssview) {
		// TODO Auto-generated method stub
		return musicDAO.insertssearch(ssview);
	}


	@Override
	public void deletessearch(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub
		System.out.println("deletessearch" + mapList);
		musicDAO.deletessearch(mapList);
	}
}
