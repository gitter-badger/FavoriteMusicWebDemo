package mplanweb.music.web.user.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserBean {
	@Size(max = 10, message = "아이디 10글자 이하여만 합니다.")
	private String userid;
	private String passwd;
	@NotBlank(message = "이메일 형식이 아닙니다.")
	@Email(message = "이메일 형식이 아닙니다.")
	private String email;
	@Size(min = 2, message = "이름은 2글자 이상여만 합니다.")
	private String name;
	@Size(min = 6, message = "전화번호 형식이 다릅니다.")
	private String phone;

	public UserBean() {
	}

	public UserBean(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}

	public UserBean(String userid, String passwd, String name, String phone) {
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
