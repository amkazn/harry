package bots.harry.service.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import bots.harry.service.TelegramBot;

@Component
public interface BotCommandHandler {
	
	public void handleUpdate(TelegramBot bot, Update update);

}
