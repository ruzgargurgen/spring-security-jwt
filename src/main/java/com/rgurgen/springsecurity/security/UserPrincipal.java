package com.rgurgen.springsecurity.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rgurgen.springsecurity.model.Role;
import com.rgurgen.springsecurity.model.User;
import com.rgurgen.springsecurity.utils.SecurityUtils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
		private Long id;
	    private String username;
	    transient private String password;
	    transient private User user; 
	    private Set<GrantedAuthority> authorities;
	    
	    public static UserPrincipal createSuperUser()
	    {
	        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));

	        return UserPrincipal.builder()
	                .id(-1L)
	                .username("system-administrator")
	                .authorities(authorities)
	                .build();
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities()
	    {
	        return authorities;
	    }

	    @Override
	    public String getPassword()
	    {
	        return password;
	    }

	    @Override
	    public String getUsername()
	    {
	        return username;
	    }

	    @Override
	    public boolean isAccountNonExpired()
	    {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked()
	    {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired()
	    {
	        return true;
	    }

	    @Override
	    public boolean isEnabled()
	    {
	        return true;
	    }
}
