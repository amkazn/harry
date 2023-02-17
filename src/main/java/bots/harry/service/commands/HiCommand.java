package bots.harry.service.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import bots.harry.service.TelegramBot;

@Component
public class HiCommand implements BotCommandHandler {

	@Override
	public void handleUpdate(TelegramBot bot, Update update) {
					
		bot.sendMessage(update.getMessage().getChatId(), 
				"Hi " + update.getMessage().getFrom().getFirstName());
		
	}

}
