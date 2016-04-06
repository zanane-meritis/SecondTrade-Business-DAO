package fr.secondtrade.businessdao.securitytest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;

import fr.secondtrade.businessdao.configuration.PersistenceConfiguration;
import fr.secondtrade.businessdao.security.Role;
import fr.secondtrade.businessdao.security.RoleRepository;
import fr.secondtrade.businessdao.security.User;
import fr.secondtrade.businessdao.security.UserRepository;
import fr.secondtrade.businessdao.security.UserRole;
import fr.secondtrade.businessdao.security.UserRoleRepository;



public class CreateUser {
	
	public static void main(String[] args) {
		if (args.length != 3 ){
			System.out.println("Syntaxe : [pg] user password role");
			System.exit(0);
		}
		
		String login = args[0];
		String password = args[1];
		String roleName = args[2];
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfiguration.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		UserRoleRepository userRoleRepository = context.getBean(UserRoleRepository.class);
		Role role = roleRepository.findRoleByName(roleName);
		if (role==null){
			role = roleRepository.save(new Role(roleName));
		}
		User user = userRepository.findUserByLogin(login);
		if (user == null){
			String crypt = BCrypt.hashpw(password, BCrypt.gensalt());
			user = userRepository.save(new User(login, login, crypt));
			userRoleRepository.save(new UserRole(user,role));
		}else {
			boolean trouve = false;
			for (Role r : userRepository.getRoles(user.getId())){
				if(r.getName().equals(roleName)){
					trouve = true;
					break;
				}
			}
			if (!trouve){
				userRoleRepository.save(new UserRole(user, role));
			}
		}
		context.close();
	}

}
