package org.advertise.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_userrole")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userroleId;

	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	@ManyToOne()
	private Role role;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserroleId() {
		return userroleId;
	}

	public void setUserroleId(Long userroleId) {
		this.userroleId = userroleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



}
