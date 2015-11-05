package mplanweb.music.web.music;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private ListDAO listdao;

	// Count
	public int listcount(Listsearch listsearch) {
		return listdao.listcount(listsearch);

	}

	public List<Listview> listview(Listsearch listsearch) {

		return listdao.listview(listsearch);
	}

	public List<Listview> kpoplistview(Listsearch listsearch) {
		return listdao.kpoplistview(listsearch);
	}

	public List<Listview> poplistview(Listsearch listsearch) {
		return listdao.poplistview(listsearch);
	}

	public List<Listview> ostlistview(Listsearch listsearch) {
		return listdao.ostlistview(listsearch);
	}

	public List<Listview> jpoplistview(Listsearch listsearch) {
		return listdao.jpoplistview(listsearch);
	}

	public List<Listview> radiolistview(Listsearch listsearch) {
		return listdao.radiolistview(listsearch);
	}
}