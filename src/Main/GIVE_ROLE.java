package Main;

import java.awt.Color;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class GIVE_ROLE extends BASE_COMMAND{

	private Member member;
	private Role roleToGive;
	
	public GIVE_ROLE(String prefix, String description, String error, String thumbnail, String title,
			String footer, String errorModerator, TextChannel textChannel, Color color,Role roleToGive) {
		super(prefix, description, error, thumbnail, title, footer, errorModerator, textChannel, color);
		// TODO Auto-generated constructor stub
		this.roleToGive = roleToGive;
	}
	//Role part
		public void setRole(Role ROLE) {
			this.roleToGive = ROLE;
		}
		public Role getRole() {
			return roleToGive;
		}
		
		//Member part
		public void setMember(Member MEMBER) {
			this.member = MEMBER;
		}
		public Member getMember() {
			return member;
		}
	
	public void GIVING_ROLE(Message message) {
        
        message.getGuild().addRoleToMember(getMember(), getRole()).queue();
        setTitle("Role Giver");
        setDescription(message.getAuthor().getAsMention() + " has given " + getRole().getAsMention() + " to " + getMember().getAsMention());
        setColor(Color.cyan);
        LOG_COMMAND(message);
        
        setDescription("Gave the role " + getRole().getAsMention() + "to " + getMember().getAsMention());
        REPLY_IN_CHANNEL(message);
	}  
	
}
