package bots.harry.service;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


import bots.harry.config.BotConfig;
import bots.harry.config.BotInitializer;
import bots.harry.service.commands.BotCommandHandler;
import bots.harry.service.commands.CommandsConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {
	

    @Autowired
	private BotConfig config;	

    ApplicationContext context = new AnnotationConfigApplicationContext(CommandsConfig.class);	

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return config.getBotName();
	}
	
	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return config.getToken();
	}
	
	
	@Override
	public void onUpdateReceived(Update update) {
		
		if (update.hasMessage() && update.getMessage().hasText()) {			
			processUpdate(update);
		}		
	}


	public void clearWebhook() throws TelegramApiRequestException {
		// TODO Auto-generated method stub
		
	}
	
	public void sendMessage(long chatId, String textToSend) {
		SendMessage message = new SendMessage();
		message.setChatId(String.valueOf(chatId));
		message.setText(textToSend);
		
		try {
			execute(message);
		} catch (TelegramApiException e) {
			// TODO: handle exception
			log.error("Error occurred: "+e.getMessage());
		}
		
	}
	
	private void processUpdate(Update update) {
		
		String messageText = update.getMessage().getText();
		String commandName= "";
		
		if (messageText.contains("/")) {
			for (char ch : messageText.toCharArray()) {
				commandName = ch == '/'? (commandName) : (commandName.concat(String.valueOf(ch)));
			}			
		} else commandName = "DEFAULT";
		
		commandName = commandName.toUpperCase();
		
		try {
			
			context.getBean("get" + commandName + "Command", BotCommandHandler.class).handleUpdate(this, update);
			log.info("Command " + commandName + " from user: " + update.getMessage().getFrom().getUserName());
			
		} catch (NoSuchBeanDefinitionException e) {
			
			log.error("Unsupported command " + commandName + " from user: " + update.getMessage().getFrom().getUserName());

		}
	}
}
