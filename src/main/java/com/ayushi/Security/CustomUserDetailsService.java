package com.ayushi.Security;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayushi.Entity.UserAuth;
import com.ayushi.Enum.Permission;
import com.ayushi.Repository.UserAuthRepository;


@Service
public class CustomUserDetailsService  implements UserDetailsService{
	
	@Autowired
	private UserAuthRepository userRepo;
	
	public UserDetails loadUserByEmail(String userOfficialEmail) {
		
		UserAuth user= userRepo.findByUserOfficialEmail(userOfficialEmail)
				         .orElseThrow(()->new RuntimeException("user notfound") );
		
		Set<Permission>perms= RolePermissionConfig.getRolePermission().get(user.getRole());
		List<GrantedAuthority> authorities = (perms== null)? Collections.emptyList():
				                            perms.stream().map(p-> new SimpleGrantedAuthority(p.name())).collect(Collectors.toList());	
		
		
		return new org.springframework.security.core.userdetails.User(user.getUserOfficialEmail(), user.getPassword(), authorities);
	}
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return loadUserByEmail(username);
    }

}

