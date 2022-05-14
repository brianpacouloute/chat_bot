package Main;

import java.awt.Color;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class REMOVE_ROLE extends BASE_COMMAND{

	private Member member;
	private Role roleToRemove;
	
	public REMOVE_ROLE(String prefix, String description, String error, String thumbnail, String title,
			String footer, String errorModerator, TextChannel textChannel, Color color, Member member, Role roleToRemove) {
		super(prefix, description, error, thumbnail, title, footer, errorModerator, textChannel, color);
	this.member = member;
	this.roleToRemove = roleToRemove;
		// TODO Auto-generated constructor stub
	}
	
	
	//Role part
	public void setRole(Role ROLE) {
		this.roleToRemove = ROLE;
	}
	public Role getRole() {
		return roleToRemove;
	}
	
	//Member part
	public void setMember(Member MEMBER) {
		this.member = MEMBER;
	}
	public Member getMember() {
		return member;
	}
	
	public void ROLE_REMOVER(Message message) {
	        
	        message.getGuild().removeRoleFromMember(getMember(), getRole()).queue();
	        setTitle("Role Remover");
	        setDescription(message.getAuthor().getAsMention() + " has removed " + getRole().getAsMention() + " from " + getMember().getAsMention());
	        setColor(Color.cyan);
	        LOG_COMMAND(message);
	        
	        setDescription("Removed the role " + getRole().getAsMention() + "from " + getMember().getAsMention());
	        REPLY_IN_CHANNEL(message);
	        
	}

}
