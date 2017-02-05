package artyapple.telegrambot;

import java.util.Date;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;

public class DummyMessageHandler {

	public SendMessage handle(Update update) {
		// TODO Auto-generated method stub
		String answer = "";
		String text = update.getMessage().getText();
		String name = update.getMessage().getFrom().getFirstName();
		
		
		System.out.println("Is channel message: "+ update.getMessage().isChannelMessage());
		System.out.println("Date: "+ new Date(update.getMessage().getDate().longValue()));
		System.out.println("Chat id: "+ update.getMessage().getChatId());
		System.out.println("------------------sql------------------------");
		
		DBAuth dbaut = new DBAuth();
		dbaut.estabConn();
		
		
		text = text.toLowerCase();
		String[] txt = text.split(" ");
		
		for(String str : txt){
			
			}
		}
		
		
		
		
		
		return new SendMessage() // Create a SendMessage
				// object with mandatory
				// fields
				.setChatId(update.getMessage().getChatId())
				.setText(answer);
	}

}
