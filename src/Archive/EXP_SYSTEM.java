package Archive;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EXP_SYSTEM extends ListenerAdapter{
    public String prefix = "!";

	HashMap<Member, Integer> playerXp = new HashMap<>();
	HashMap<Member, Integer> playerTimer = new HashMap<>();
	
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    	System.out.println("Hi guys vsauce here");
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(prefix + "xp")) {
			debug("hi");
			SEND_RESPONSE_MESSAGE("You have " + getPlayerXp(event.getMember())+ " xp",event.getMessage());
			
		}
			
		if(canGetXp(event.getMember())) {
			randXp(event.getMember());
		setPlayerTime(event.getMember(),60);
	}
	}
	
	private int getPlayerXp(Member member){
		return playerXp.get(member);
	}
	private void setPlayerXp(Member member, int num) {
		playerXp.put(member, num);
	}
	private int getPlayerTime(Member member) {
		return playerTimer.get(member);
	}
	private void setPlayerTime(Member member, int num) {
		playerTimer.put(member,num);
	}
	public void randXp(Member member) {
		
		Random r = new Random();
		if (!playerXp.containsKey(member)) {
			setPlayerXp(member,0);
		}
		setPlayerXp(member,getPlayerXp(member)+ r.nextInt(25));
		
	}
	
	private boolean canGetXp(Member member) {
		if (playerTimer.containsKey(member)) {
			return true;			
		}
		return false;					
	}
	
    private void SEND_RESPONSE_MESSAGE( String description, Message message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
        embed.setTitle("Exp Handler"); 
        embed.setDescription(description);
        embed.setFooter("Message by " + message.getAuthor().getAsTag(), message.getAuthor().getAvatarUrl());
        embed.setColor(Color.cyan);
        message.reply(embed.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
        embed.clear();
    }
	public void startTimer() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				for(Member member : playerTimer.keySet()) {
					setPlayerTime(member, getPlayerTime(member)-1);
				}
			}
		};
		timer.schedule(task, 1000,1000);
	}
	
	private void debug(String test) {
		System.out.println(test);
	}
}
