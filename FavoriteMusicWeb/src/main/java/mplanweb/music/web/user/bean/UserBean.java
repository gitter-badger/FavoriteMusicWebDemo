package mplanweb.music.web.user.bean;

public class UserBean {

	// login test
	private String userid;
	private String passwd;
	
	//login
	public UserBean(){}
	public UserBean(String userid, String passwd){
		this.userid = userid;
		this.passwd = passwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return passwd;
	}

	public void setPwd(String passwd) {
		this.passwd = passwd;
	}

}
