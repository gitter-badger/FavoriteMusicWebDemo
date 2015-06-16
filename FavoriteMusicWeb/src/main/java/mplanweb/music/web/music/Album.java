package mplanweb.music.web.music;

/*
 * 음원관리 
 * Method : Artist.java
 * Author : M!Plan 
 * Date : 2015/06/01
 * Copyright : M!Plan lab (2015)
 * 문제점 : 현재 없음
 */


public class Album {

	private String artist;
	private String album;
	private String year;
	private String content;
	private String corp;
	private String RadioGroup1;
	private String fimgName;
	private String uploadFimgName;
	private long imgsize;
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	public String getRadioGroup1() {
		return RadioGroup1;
	}
	public void setRadioGroup1(String radioGroup1) {
		RadioGroup1 = radioGroup1;
	}
	public String getFimgName() {
		return fimgName;
	}
	public void setFimgName(String fimgName) {
		this.fimgName = fimgName;
	}
	public String getUploadFimgName() {
		return uploadFimgName;
	}
	public void setUploadFimgName(String uploadFimgName) {
		this.uploadFimgName = uploadFimgName;
	}
	public long getImgsize() {
		return imgsize;
	}
	public void setImgsize(long imgsize) {
		this.imgsize = imgsize;
	}

}