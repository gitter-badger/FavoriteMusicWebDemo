package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YboardServiceImpl implements YboardService {

	@Autowired
	private YboardDAO yboardDAO;

	@Override
	public int selectTotalCountYboard(YboardSearch yboardSearch) {
		System.out.println("selectTotalCountYboard" + yboardSearch);
		return yboardDAO.selectTotalCountYboard(yboardSearch);
	}

	@Override
	public List<Yboard> selectYboard(YboardSearch yboardSearch) {
		System.out.println("selectYboard" + yboardSearch);
		return yboardDAO.selectYboard(yboardSearch);
	}

	@Override
	public Yboard viewYboard(Map<String, Object> map) {
		System.out.println("viewYboard" + map);
		return yboardDAO.viewYboard(map);
	}

	@Override
	public int insertYboard(Yboard yboard) {
		System.out.println("insertYboard" + yboard);
		return yboardDAO.insertYboard(yboard);
	}

	@Override
	public int updateYboard(Yboard yboard) {
		System.out.println("updateYboard" + yboard);
		return yboardDAO.updateYboard(yboard);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {
		System.out.println("deleteYboard" + mapList);
		yboardDAO.deleteYboard(mapList);
	}

}
