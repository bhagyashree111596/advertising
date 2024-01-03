package org.advertise.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	private String authority;

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	public void setAuthority() {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
