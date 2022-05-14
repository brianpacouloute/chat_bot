package Main;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class BASE_COMMAND{

	public String prefix;
	private String errorModerator;
	public String description;
	private String error;
	public String thumbnail;
	public String title;
	public String footer;
	public TextChannel textChannel;
	public Color color;
	
	public BASE_COMMAND(String prefix, String description, String error, String thumbnail, String title, String footer, String errorModerator, TextChannel textChannel, Color color) {
		this.prefix = "!";
		this.description = description;
		this.error = error;
		this.thumbnail = thumbnail;
		this.title = title;
		this.footer = footer;
		this.errorModerator = errorModerator;
		this.textChannel = textChannel;
		this.color = color;
	}
	
	public int PERMISSION_CHECKER(Member userMember) {
		int perm;
        if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {
        	perm = 1; // This means that the user does not have this permission.
        } else {
        	perm = 0; // This means that the user does have this permission.
        }
		return perm;
	}
	
	
	public void LOG_COMMAND(Message message) {
		
        TextChannel textChannel = gettextChannel();
        EmbedBuilder embed1 = new EmbedBuilder();
        embed1.setTitle(getTitle());
        embed1.setDescription(getDescription());
        embed1.setFooter(getFooter(),message.getAuthor().getAvatarUrl());
        embed1.setColor(getColor());
        embed1.setThumbnail(getThumbnail());
        textChannel.sendMessage(embed1.build()).queue();
        embed1.clear();
	}
	
	public void REPLY_IN_CHANNEL(Message message) {
		
        EmbedBuilder embed = new EmbedBuilder();
        embed.setThumbnail(getThumbnail());
        embed.setTitle(getTitle()); 
        embed.setDescription(getDescription());
        embed.setFooter(getFooter(),message.getAuthor().getAvatarUrl());
        embed.setColor(getColor());
        message.reply(embed.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
        embed.clear();
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	//Color part
	public Color getColor() {
		return color;
	}
	public void setColor(Color setcolor) {
		this.color = setcolor;
	}
	//Error mod part
	public String getErrorModerator() {
		return errorModerator;
	}
	public void setErrorModerator(String seterrormoderator) {
		this.errorModerator = seterrormoderator;
	}
	//Text channel 
	public TextChannel gettextChannel() {
		return textChannel;
	}
	public void setTextChannel(TextChannel settextchannel) {
		this.textChannel = settextchannel;
	}
	//Thumbnail part
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumnbnail(String setthumbnail) {
		this.thumbnail = setthumbnail;
	}
	//Title part
	public String getTitle() {
		return title;
	}
	public void setTitle(String settitle) {
		this.title = settitle;
	}
	//footer part
	public String getFooter() {
		return footer;
	}
	public void setfooter(String setfooter) {
		this.footer = setfooter;
	}
	//description part
	public String getDescription() {
		return description; 
	}
	public void setDescription(String setdescription) {
		this.description = setdescription;
	}
	//error part
	public String getError() {
		return error;
	}
	public void setError(String seterror) {
		this.error = seterror;
	}
	
	
	
	
	
	
	
	
}

