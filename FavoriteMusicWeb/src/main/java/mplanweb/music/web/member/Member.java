package mplanweb.music.web.member;

public class Member {
	private String userid; // 아이디
	private String passwd; // 패스워드
	private String name; // 이름
	private String nickname; // 닉네임
	private String email; // 이메일
	private String email_useyn; // 이메일 동의
	private String mobile; // 모바일
	private String mailaddress; // 우편주소
	private String houseaddress; // 동이름
	private String etcaddress; // 기타주소
	private String img; // 이미지
	private String imgsize; // 사이즈
	private String imgo; // 오리지널

	public Member() {

	}

	public Member(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}

	public Member(String userid, String passwd, String name, String nickname,
			String email, String email_useyn, String mobile,
			String mailaddress, String houseaddress, String etcaddress,
			String img, String imgsize, String imgo) {
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.email_useyn = email_useyn;
		this.mobile = mobile;
		this.mailaddress = mailaddress;
		this.houseaddress = houseaddress;
		this.etcaddress = etcaddress;
		this.img = img;
		this.imgsize = imgsize;
		this.imgo = imgo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_useyn() {
		return email_useyn;
	}

	public void setEmail_useyn(String email_useyn) {
		this.email_useyn = email_useyn;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public String getHouseaddress() {
		return houseaddress;
	}

	public void setHouseaddress(String houseaddress) {
		this.houseaddress = houseaddress;
	}

	public String getEtcaddress() {
		return etcaddress;
	}

	public void setEtcaddress(String etcaddress) {
		this.etcaddress = etcaddress;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgsize() {
		return imgsize;
	}

	public void setImgsize(String imgsize) {
		this.imgsize = imgsize;
	}

	public String getImgo() {
		return imgo;
	}

	public void setImgo(String imgo) {
		this.imgo = imgo;
	}

}
