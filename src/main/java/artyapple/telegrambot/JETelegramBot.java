package artyapple.telegrambot;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class JETelegramBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {

	
	public String getBotUsername() {
		return Constants.username;
	}

	@Override
	public String getBotToken() {
		return Constants.token;
	}

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			
			DummyMessageHandler handler = new DummyMessageHandler();
			SendMessage message = handler.handle(update);
			
			try {
				sendMessage(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

}
