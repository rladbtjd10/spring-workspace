package com.kh.security.model.vo;

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
	private String auth;
	private int enabled;
	
	// getAuthorities : 회원의 auth(role) 역할에 해당하는 정보 getter
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList();
		authList.add(new SimpleGrantedAuthority(auth));
		return authList;
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
