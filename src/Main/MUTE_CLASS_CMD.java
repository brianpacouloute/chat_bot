package Main;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class MUTE_CLASS_CMD extends BASE_COMMAND{
	private String[] args;
	private Member target;
	private Role muted;
	public MUTE_CLASS_CMD(String prefix, String description, String error, String thumbnail, String title,
			String footer, String footer2, String errorModerator, TextChannel textChannel, Color color,String[] args,Member target,Role muted) {
		super(prefix, description, error, thumbnail, title, footer, footer2, textChannel, color);
		// TODO Auto-generated constructor stub
		this.args = args;
		this.target = target;
		this.muted = muted;
	}
	
	public void setArgs(String[]ARGS) {
		this.args = ARGS;
	}
	public String[] getArgs() {
		return args;
	}
	//target part
	public void setTarg(Member TARGET) {
		this.target = TARGET;
	}
	public Member getTarg() {
		return target;
	}
	//muted part
	public void setMuted(Role MUTED) {
		this.muted = MUTED;
	}
	public Role getMuted() {
		return muted;
	}

	
	public void MUTE_MEMBER(Message message) {
		
		// TODO Auto-generated method stub
        setTextChannel(message.getGuild().getTextChannelsByName("picnic-dump", true).get(0));
        //So what this does is it runs this piece of code in the background
        Runnable r = new Runnable() {
			
        	public void run() {
        		
        	 //run attempt
		try {
	
		 for (int i = 0; i < Integer.parseInt(getArgs()[3]); i++) {
             if (i == 0) {
            			String reason = " ";
                    	if (getArgs().length>=3) {
                    	for (int y = 4; y < getArgs().length; y++) {
                    		reason += getArgs()[y] + " ";
                    	}
                    	
            	 setTitle("Mute Handler");
            	 if (reason == " ") {
                  	 setDescription("Member " + getArgs()[1] + " was muted by " + message.getAuthor().getAsMention() + " for " + getArgs()[3] + " seconds.");

            	 }else {
                	 setDescription("Member " + getArgs()[1] + " was muted by " + message.getAuthor().getAsMention() + " for " + getArgs()[3] + " seconds because of the reason "+ reason+".");

            	 }

               	 //This posts the response in the log channel where all commands and bot actions are logged
            	 LOG_COMMAND(message);
            	 message.getGuild().addRoleToMember(getTarg(),getMuted()).queue();
            	 
            	 //This posts the response in the same channel that the command was made
            	 REPLY_IN_CHANNEL(message);
                 
                    	} else {
                          	 setDescription("Member " + getArgs()[1] + " was muted by " + message.getAuthor().getAsMention() + " for " + getArgs()[3] + " seconds.");

                    	}
             }
              
             try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		}catch(Exception e) {
			setTitle("Mute Handler");
			setDescription("Please try again. Please use this format !mute [user][time][reason]");
			REPLY_IN_CHANNEL(message);
		}
			UNMUTE(message);
	        
	       	//Posting unmute message
	       	setDescription("Member " + getArgs()[1] + " was unmuted automatically.");
	         LOG_COMMAND(message); 
        	}
	};//ATTEMPT
	Thread t = new Thread(r);
	t.start();
}


	public void UNMUTE(Message message) {

        message.getGuild().removeRoleFromMember(getTarg(), getMuted()).queue();

	}

	
}

