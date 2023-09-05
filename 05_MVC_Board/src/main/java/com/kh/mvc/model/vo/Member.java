package com.kh.mvc.model.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data 
public class Member implements UserDetails {
	
	private String id;
	private String password;
	private String name;
	private String address;
	private String auth; //인증
	private int enabled; //상태 표시기, 이진 상태를 나타내는 데 사용될 수 있음을 시사합니다(예: 비활성화된 경우 0, 활성화된 경우 1).
	
	// getAuthorities : 회원의 auth(role) 역할에 해당하는 정보 getter
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList();
		authList.add(new SimpleGrantedAuthority(auth));
		return authList;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return id;
	}
	
	@Override
	public boolean isAccountNonExpired() { //계정과 관련된거 true
		return true; 
	}
	
	@Override
	public boolean isAccountNonLocked() { // 권한 관련된거 true
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled == 1 ? true : false;
	}

}
