package com.aeon.project.commons;

<<<<<<< HEAD

import lombok.Getter;
import lombok.Setter;
=======
import java.util.Collection;
>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<< HEAD
import java.util.Collection;

@Getter
@Setter
public class UserPrincipal implements UserDetails{
    private Long userId;
    private String username;
    private String password;
    private Collection authorities;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

=======
import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class UserPrincipal implements UserDetails{
	private Long userId;
    private String username;
    private String password;
    private Collection authorities;
>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD
=======
	
	
	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setAuthorities(Collection authorities) {
		this.authorities = authorities;
	}

>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD

=======
>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD
=======
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

   
>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3
}
