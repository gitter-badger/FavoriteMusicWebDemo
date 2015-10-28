package mplanweb.music.web.music;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListDAOImpl implements ListDAO {

	@Autowired
	private SqlSession sqlSession;

	// SSView

	@Override
	public int listcount(Listsearch listsearch) {
		return sqlSession.selectOne("Listmusic.listcount", listsearch);

	}

	public List<Listview> listview(Listsearch listsearch) {
		return sqlSession.selectList("Listmusic.listresult", listsearch);
	}

	public List<Listview> kpoplistview(Listsearch listsearch) {
		return sqlSession.selectList("Listmusic.kpoplistresult", listsearch);
	}

	public List<Listview> poplistview(Listsearch listsearch) {
		return sqlSession.selectList("Listmusic.poplistresult", listsearch);
	}

	public List<Listview> ostlistview(Listsearch listsearch) {
		return sqlSession.selectList("Listmusic.ostlistresult", listsearch);
	}

	public List<Listview> jpoplistview(Listsearch listsearch) {
		return sqlSession.selectList("Listmusic.jpoplistresult", listsearch);
	}

	public List<Listview> radiolistview(Listsearch listsearch) {
		return sqlSession.selectList("Listmusic.radiolistresult", listsearch);
	}

}