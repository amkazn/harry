package bots.harry.service.commands;

import java.util.Random;

import org.telegram.telegrambots.meta.api.objects.Update;

import bots.harry.service.TelegramBot;

public class SayMyNameCommand implements BotCommandHandler {

	@Override
	public void handleUpdate(TelegramBot bot, Update update) {
		// TODO Auto-generated method stub
		
		String [] names = {"Willie Wonka", "Walter White", "Hey fuck off", update.getMessage().getFrom().getFirstName()};
		Random random = new Random();
		
		bot.sendMessage(update.getMessage().getChatId(),
				names[random.nextInt(names.length)]);		

	}

}
