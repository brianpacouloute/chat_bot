package Main;

import java.awt.Color;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter{
	
	String[] messages = {
			"Welcome to the discord server [member]!",
			"Enjoy your stay [member]!",
			"A wild [member] appeared.",
			"I now declare [member] part of this server.",
			"[member] has joined the server!",
			"Welcome to the party [member]!",
			"Voided says hi [member]."
	};
	
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Member member = event.getMember();
		event.getGuild().addRoleToMember(member, event.getMember().getGuild().getRolesByName("verified ✿", true).get(0)).queue();
		
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		
		String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
		String Title = "Member Joined";
		String Description = messages[number].replace("[member]", event.getMember().getAsMention());
		String Footer = "Message by Servant Of LOSS";
		String Footer2 = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
		SEND_RESPONSE_MESSAGE_CYAN(Thumbnail,Title,Description,Footer,Footer2,event.getGuild());
	
		
		
	}
	
	

	private void SEND_RESPONSE_MESSAGE_CYAN(String thumbnail, String title, String description, String footer, String footer2, Guild guild) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setThumbnail(thumbnail);
		embed.setTitle(title);
		embed.setDescription(description);
		embed.setFooter(footer,footer2);
		embed.setColor(Color.cyan);
		guild.getDefaultChannel().sendMessage(embed.build()).queue(); ;
		embed.clear();
	}
	
}
