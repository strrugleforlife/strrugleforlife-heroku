package jp.co.strrugleforlife.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordTest extends ListenerAdapter{
	public static JDA jda = null;
	
	public static void main(String[] args) {
		JDABuilder b = new JDABuilder();
		
		try {
			jda = b.setToken("Njg3NTc3MjYwNTU5MTcxNTk0.Xmnycg.jak0GS1a9uw76gs76tBPi0sbiKk").build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		jda.addEventListener(new DiscordTest());
	}
	
	@Override 
	public void onMessageReceived(MessageReceivedEvent e) {
		String s = e.getMessage().getContentRaw();
		if(s.matches(".*Hello.*")) {
			if(!e.getAuthor().equals(jda.getSelfUser())) {
				e.getTextChannel().sendMessage("Hello").queue();
			}
		}
		if(s.equals("あなさん")) {
			if(!e.getAuthor().equals(jda.getSelfUser())) {
				e.getTextChannel().sendMessage("変態").queue();
			}
		}
		if(s.equals("るいくん")) {
			if(!e.getAuthor().equals(jda.getSelfUser())) {
				e.getTextChannel().sendMessage("おっぱい").queue();
			}
		}
	}
}
