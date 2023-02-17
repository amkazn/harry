package bots.harry.service.commands;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CommandsConfig {
	
	  @Bean
	  public DefaultCommand getDEFAULTCommand() {
	  	return new DefaultCommand();
	  }
	
	  @Bean
	  public HiCommand getHICommand() {
	  	return new HiCommand();
	  }
	  
	  @Bean
	  public SayMyNameCommand getSAYMYNAMECommand() {
	  	return new SayMyNameCommand();
	  }
	  
	  @Bean
	  public VideoCommand getVIDEOCommand() {
	  	return new VideoCommand();
	  }
	  
	  @Bean
	  public TestCommand getTESTCommand() {
	  	return new TestCommand();
	  }
	  
	  
	  


}
