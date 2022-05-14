package Main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class BotStartup {
	public static void main(String[] args) throws LoginException {
	JDABuilder jda = JDABuilder.createDefault("OTcxNjA4NDQwMTE4MDU0OTcy.Gst_Hq.lBuGDauVObioUh-G_35q8YQ-5eIGI8EZZnxRJk");
		jda.setActivity(Activity.playing("Serving Goddess Of LOSS"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new OOP_COMMANDS());
		jda.addEventListeners(new GuildMemberJoin());
		jda.addEventListeners(new BLACKLISTED_WORDS());
		jda.setChunkingFilter(ChunkingFilter.ALL);
		jda.setMemberCachePolicy(MemberCachePolicy.ALL);
		jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
		jda.build();
		//jda.addEventListeners(new EXP_SYSTEM());
		
		//EXP_SYSTEM system = new EXP_SYSTEM();
		//system.startTimer();
	}
}




