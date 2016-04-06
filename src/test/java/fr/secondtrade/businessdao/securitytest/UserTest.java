package fr.secondtrade.businessdao.securitytest;

import java.util.ArrayList;

import org.hibernate.hql.internal.ast.tree.DisplayableNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import antlr.collections.List;
import fr.secondtrade.businessdao.configuration.PersistenceConfiguration;
import fr.secondtrade.businessdao.security.AppUserDetails;
import fr.secondtrade.businessdao.security.AppUserDetailsService;
import fr.secondtrade.businessdao.security.Role;
import fr.secondtrade.businessdao.security.User;
import fr.secondtrade.businessdao.security.UserRepository;

@SpringApplicationConfiguration(classes = PersistenceConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Test
	public void findAllUserWithTheirRoles(){
		Iterable<User> users = userRepository.findAll();
		for (User user : users){
			System.out.println(user);
			display("Role:", userRepository.getRoles(user.getId()));
		}
	}
	
	@Test
	public void loadUserByUserName(){
		AppUserDetails userDetails = (AppUserDetails) appUserDetailsService.loadUserByUsername("admin");
		Assert.assertTrue(BCrypt.checkpw("admin", userDetails.getPassword()));
		@SuppressWarnings("unchecked")
		ArrayList<SimpleGrantedAuthority> authorities = (ArrayList<SimpleGrantedAuthority>) userDetails.getAuthorities();
		Assert.assertEquals(1L, authorities.size());
		Assert.assertEquals("ROLE_ADMIN",authorities.get(0).getAuthority());
	}

	private void display(String message, Iterable<?> elements) {
		System.out.println(message);
		for (Object element : elements) {
			System.out.println(element);
		}
	}
	
	
	
	

}
