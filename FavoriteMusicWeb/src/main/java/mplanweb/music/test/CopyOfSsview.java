package mplanweb.music.test;

import java.io.Serializable;

import mplanweb.music.web.board.YKStringUtil;

@SuppressWarnings("serial")
public class CopyOfSsview implements Serializable {
	private int mpssnum; // : 음원넘버
	private int mpnum; // : 싱글넘버
	private String artist; // : 아티스트
	private String title; // : 아티스트
	private String album; // : 아티스트
	private String lryic; // : 아티스트
	private String year; // : 아티스트
	private String corp; // : 아티스트
	private String label; // : 아티스트
	private String genre1; // : 아티스트
	private String genre2; // : 아티스트
	private String etc; // : 아티스트
	private String img; // : 아티스트
	private long imgsize; // : 아티스트
	private String imgo; // : 아티스트
	private String m320k; // : 아티스트
	private long m320size; // : 아티스트
	private String m320ko; // : 아티스트
	private String m192k; // : 아티스트
	private long m192size; // : 아티스트
	private String m192ko; // : 아티스트
	private int age; // : 아티스트
	private String useyn; // : 아티스트
	private String date; // : 아티스트
	private String mpssnumEncrypt; // : 고유키 암호화
	
	public int getMpssnum() {
		return mpssnum;
	}
	public void setMpssnum(int mpssnum) {
		setMpssnumEncrypt(MusicStringUtil.getStringTmsEncryptoAesForInt(mpssnum));
		this.mpssnum = mpssnum;
	}
	public int getMpnum() {
		return mpnum;
	}
	public void setMpnum(int mpnum) {
		this.mpnum = mpnum;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getLryic() {
		return lryic;
	}
	public void setLryic(String lryic) {
		this.lryic = lryic;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getGenre1() {
		return genre1;
	}
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public long getImgsize() {
		return imgsize;
	}
	public void setImgsize(long imgsize) {
		this.imgsize = imgsize;
	}
	public String getImgo() {
		return imgo;
	}
	public void setImgo(String imgo) {
		this.imgo = imgo;
	}
	public String getM320k() {
		return m320k;
	}
	public void setM320k(String m320k) {
		this.m320k = m320k;
	}
	public long getM320size() {
		return m320size;
	}
	public void setM320size(long m320size) {
		this.m320size = m320size;
	}
	public String getM320ko() {
		return m320ko;
	}
	public void setM320ko(String m320ko) {
		this.m320ko = m320ko;
	}
	public String getM192k() {
		return m192k;
	}
	public void setM192k(String m192k) {
		this.m192k = m192k;
	}
	public long getM192size() {
		return m192size;
	}
	public void setM192size(long m192size) {
		this.m192size = m192size;
	}
	public String getM192ko() {
		return m192ko;
	}
	public void setM192ko(String m192ko) {
		this.m192ko = m192ko;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMpssnumEncrypt() {
		return mpssnumEncrypt;
	}
	public void setMpssnumEncrypt(String mpssnumEncrypt) {
		this.mpssnumEncrypt = mpssnumEncrypt;
	}

}
