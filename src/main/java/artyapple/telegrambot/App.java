package artyapple.telegrambot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * 
 *
 */
public class App {
	public static void main(String[] args) {
		ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new JETelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}
}
