package bots.harry.service.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

import bots.harry.service.TelegramBot;

public class TestCommand implements BotCommandHandler {

	@Override
	public void handleUpdate(TelegramBot bot, Update update) {
	
		bot.sendMessage(update.getMessage().getChatId(), 
				update.getMessage().getFrom().toString());		

	}

}
