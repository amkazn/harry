package bots.harry.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@Data
//@PropertySource("application.properties")
public class BotConfig {    
    
//    @Value("${bot.name}")
//    String botName;
//
//    @Value("${bot.token}")
//    String token;
    
//
    String botName = "superstar_cop_bot";

    String token = "6013199424:AAHQzL9vz2Xybc1-J3r8aSNRl4Pl8qs_fSo";
//    
//    @Bean
//    public BotCommandHandler getHiCommand() {
//    	return new hiCommand();
//    }
    
//    @Bean
//    @Primary
//    public TelegramBot getBot() {
//    	return new TelegramBot();
//    }
//    
//    @Bean
//    @Primary
//    public BotInitializer getInitializer() {
//    	return new BotInitializer();
//    }  
    
	
}
