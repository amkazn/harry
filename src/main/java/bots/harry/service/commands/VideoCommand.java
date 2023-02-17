package bots.harry.service.commands;

import java.util.Random;

import org.telegram.telegrambots.meta.api.objects.Update;

import bots.harry.service.TelegramBot;

public class VideoCommand implements BotCommandHandler {

	@Override
	public void handleUpdate(TelegramBot bot, Update update) {
		// TODO Auto-generated method stub
		
		String [] videos = {
				"https://www.youtube.com/watch?v=DDAvgGzBXw8", 
				"https://www.youtube.com/watch?v=uEhw8urePQM", 
				"https://www.youtube.com/watch?v=Buk_dcUTF_k", 
				"https://www.youtube.com/watch?v=YxhJra1y3H4"
				};
		Random random = new Random();
		
		
		bot.sendMessage(update.getMessage().getChatId(),
				videos[random.nextInt(videos.length)]);	
		

	}

}
