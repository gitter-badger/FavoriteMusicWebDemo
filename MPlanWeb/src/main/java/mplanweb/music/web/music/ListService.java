package mplanweb.music.web.music;

import java.util.List;
import java.util.Map;

import mplanweb.music.web.source.Ssearch;
import mplanweb.music.web.source.Ssview;

public interface ListService {

	public int listcount(Listsearch listsearch);

	public List<Listview> listview(Listsearch listsearch);
	public List<Listview> kpoplistview(Listsearch listsearch);
	public List<Listview> poplistview(Listsearch listsearch);
	public List<Listview> ostlistview(Listsearch listsearch);
	public List<Listview> jpoplistview(Listsearch listsearch);
	public List<Listview> radiolistview(Listsearch listsearch);
}
