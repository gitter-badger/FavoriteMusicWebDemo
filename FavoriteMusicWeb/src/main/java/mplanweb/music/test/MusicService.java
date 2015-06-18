package mplanweb.music.test;

import java.util.List;
import java.util.Map;

public interface MusicService {

	public int selecttotalcount(Ssearch ssearch);

	public List<Ssview> selectSsview(Ssearch ssearch);

	public Ssview viewSSview(Map<String, Object> map);

	public int insertssearch(Ssview ssview);

	public void deletessearch(List<Map<String, Object>> mapList);


}
