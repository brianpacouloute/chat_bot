package Main;

import java.awt.Color;
import java.util.List;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class PURGE_CLASS_CMD extends BASE_COMMAND{
	private String[] args;
	private List < Message > messages;
	
	public PURGE_CLASS_CMD(String prefix, String description, String error, String thumbnail, String title,
			String footer, String errorModerator, TextChannel textChannel, Color color,String[] args,List < Message > messages) {
		super(prefix, description, error, thumbnail, title, footer, errorModerator, textChannel, color);
		// TODO Auto-generated constructor stub
		this.args = args;
		this.messages = messages;
	}
	
	public void setArgs(String[] ARGS) {
		this.args = ARGS;
	}
	public String[] getArgs() {
		return args;
	}
	//list part
	public void setList(List<Message> MESSAGES) {
		this.messages = MESSAGES;
	}
	public List<Message> getList(){
		return messages;
	}
	
	public void PURGE_MESSAGES(Message MESSAGE) {

		 try {
             MESSAGE.getChannel().purgeMessages(getList());
             setTextChannel(MESSAGE.getGuild().getTextChannelsByName("picnic-dump", true).get(0));
             setTitle("Purge Handler");
             setDescription(getArgs()[1] + " Messages purged from " + MESSAGE.getChannel().getName() + " by " + MESSAGE.getAuthor().getAsMention());
             LOG_COMMAND(MESSAGE);

             REPLY_IN_CHANNEL(MESSAGE);

         } catch (IllegalArgumentException e) {
             if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
            	 setDescription("Error please try again too many messages selected. Between 1-100 messages can be deleted.");
                 REPLY_IN_CHANNEL(MESSAGE);

             } else {
            	 
            	 setDescription("Error please try again. Please use this format !purge [amount]");
            	 REPLY_IN_CHANNEL(MESSAGE);
                
             }

         }
	}
}
