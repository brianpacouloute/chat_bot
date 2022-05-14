package Main;

import java.awt.Color;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class BAN_CLASS_CMD extends BASE_COMMAND{
	
	private String[] args;
	private Member target;
	
	public BAN_CLASS_CMD(String prefix, String description, String error, String thumbnail, String title, String footer,
			String errorModerator, TextChannel textChannel, Color color,String[] args,Member target) {
		super(prefix, description, error, thumbnail, title, footer, errorModerator, textChannel, color);
		// TODO Auto-generated constructor stub
		this.args = args;
		this.target = target;
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
	
	public void BANNING_HANDLER(Message message){

		try {
			if (getArgs().length < 2) {
				setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
				setTitle("Ban Handler");
				setDescription("Specify the person to ban. Please use this formate !ban [user][reason]");
				REPLY_IN_CHANNEL(message);
			}else {
				
				if (getTarg().hasPermission(Permission.MESSAGE_MANAGE)) {
					setTitle("Ban Handler");
					setDescription("Cannot ban " + getTarg().getAsMention() + " his permissions are too high.");
					REPLY_IN_CHANNEL(message);
				}else {
					if (getArgs().length >= 4) {
                        String reason = " ";
                        for (int i = 3; i < getArgs().length; i++) {
                            reason += getArgs()[i] + " ";
                        }
                        message.getGuild().ban(getTarg(), 0).queue();
    					setTitle("Ban Handler");
    					setDescription("Member " + getArgs()[1] + " was banned by " + message.getAuthor().getAsMention() + " because of the reason " + reason + ". ");
    					setColor(Color.CYAN);
    					LOG_COMMAND(message);
    					
    					REPLY_IN_CHANNEL(message);
					}else {
                        message.getGuild().ban(getTarg(), 0).queue();
    					setTitle("Ban Handler");
    					setColor(Color.CYAN);
    					setDescription("Member " + getArgs()[1] + " was banned by " + message.getAuthor().getAsMention()+ ". ");
    					LOG_COMMAND(message);
    					
    					REPLY_IN_CHANNEL(message);
					}
					
				}
			}
		}catch(Exception e) {
			setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
			setTitle("Ban Handler");
			setDescription("Specify the person to ban. Please use this formate !kick [user][reason]");
			REPLY_IN_CHANNEL(message);
		}
	}
	
}
