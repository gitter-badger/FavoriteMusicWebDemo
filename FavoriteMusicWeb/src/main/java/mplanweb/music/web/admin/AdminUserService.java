package mplanweb.music.web.admin;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminUserService implements UserDetailsService {

	private MainDAO maindao;

	public void setMainDao(MainDAO maindao) {
		this.maindao = maindao;
	}

	public UserDetails loadUserByUsername(String userid)
			throws UsernameNotFoundException {

		// id, passwd
		String userPwd = maindao.getUserPwd(userid);

		// "ROLE_USER 이름 권한 설정
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 로그인 정보 return
		UserDetails user = new User(userid, userPwd, roles);
		return user;
	}

}
