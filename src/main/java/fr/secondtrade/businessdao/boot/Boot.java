package fr.secondtrade.businessdao.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import fr.secondtrade.businessdao.business.IBusiness;
import fr.secondtrade.businessdao.configuration.PersistenceConfiguration;

public class Boot {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PersistenceConfiguration.class); 
		app.setLogStartupInfo(false);

		ConfigurableApplicationContext context = app.run(args);
		IBusiness business = context.getBean(IBusiness.class);
		
		
		// fermeture du contexte Spring
		context.close();
		
		
	}

}
