package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User extends BaseEntity {
    private String username;

    private String password;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();
<<<<<<< HEAD

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public CharSequence getPassword() {
		return password;
	}

	public void setPassword(String encode) {
		this.password = password;
		
	}
    
=======
>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3
}
