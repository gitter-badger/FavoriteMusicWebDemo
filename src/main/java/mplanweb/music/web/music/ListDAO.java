package mplanweb.music.web.music;

import java.util.List;

public interface ListDAO {

	// SSView
	public int listcount(Listsearch listsearch);

	public List<Listview> listview(Listsearch listsearch);
	public List<Listview> kpoplistview(Listsearch listsearch);
	public List<Listview> poplistview(Listsearch listsearch);
	public List<Listview> ostlistview(Listsearch listsearch);
	public List<Listview> jpoplistview(Listsearch listsearch);
	public List<Listview> radiolistview(Listsearch listsearch);
}