package pl.edu.agh.school;
import java.util.ArrayList;  
import java.util.Collection;  
import java.util.List;  
  







import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;  
import org.springframework.security.core.authority.SimpleGrantedAuthority;  
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;    

import pl.edu.agh.school.dao.UserDAO;
import pl.edu.agh.school.dao.impl.UserDAOImpl;
  
@Service  
@Transactional(readOnly=true)  
public class CustomUserDetailsService implements UserDetailsService {  
      
	@Autowired
	private UserDAO userDAO;     
  
    public UserDetails loadUserByUsername(String login)  
            throws UsernameNotFoundException {  
        pl.edu.agh.school.models.User domainUser = userDAO.getUser(login);  
        boolean enabled = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;  
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(domainUser.getUsername());
        System.out.println(domainUser.getPassword());
        System.out.println(domainUser.getRole());
        return new User(  
                domainUser.getUsername(),   
                domainUser.getPassword(),   
                enabled,   
                accountNonExpired,   
                credentialsNonExpired,   
                accountNonLocked,  
                getAuthorities(domainUser.getRole().getId())  
        );  
    }  
      
    public Collection<GrantedAuthority> getAuthorities(Integer role) {  
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));  
        return authList;  
    }  
      
    public List<String> getRoles(Integer role) {  
  
        List<String> roles = new ArrayList<String>();  
  
        if (role.intValue() == 1) {  
            roles.add("admin");   
        } else if (role.intValue() == 2) {  
            roles.add("teacher");  
        } 
        else {
        	roles.add("student");
        }
        System.out.println(roles);
        return roles;  
    }  
      
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {  
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
          
        for (String role : roles) {  
            authorities.add(new SimpleGrantedAuthority(role));  
        }  
        return authorities;  
    }  
  
}