package bots.harry.service.commands;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.meta.api.objects.Update;

import bots.harry.service.TelegramBot;

//TODO add an random AI event
//TODO add timer that breaks the connection if an amount of time since the last message expired
public class DefaultCommand implements BotCommandHandler {
	
    private Map<Long, Long> contacts = new HashMap<>();		

	@Override
	public void handleUpdate(TelegramBot bot, Update update) {

		long chatId = update.getMessage().getChatId();
		long visavis = 0;		
		
		if (contacts.containsKey(chatId)) 
			visavis = contacts.get(chatId);
		else 
			contacts.put(chatId, (long) 0);
		
		if (visavis == 0) {
			for(Map.Entry<Long, Long> entry : contacts.entrySet()) {
				if (entry.getKey() != chatId && entry.getValue() == 0) {
					visavis = entry.getKey();
					contacts.put(chatId, visavis);
					contacts.put(visavis, chatId);
					break;
				}				
			}
		}
		
		if (visavis != 0)
			bot.sendMessage(visavis, update.getMessage().getText());
	}

}
