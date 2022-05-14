package Main;

import java.awt.Color;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BLACKLISTED_WORDS extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    	Guild guild = event.getGuild();
        User user = event.getAuthor();
        Member userMember = guild.getMember(user);
    	String message = event.getMessage().toString().toLowerCase();
    	String[] BLACKLISTED = {
    		"nigga",
    		"nigger",
    		"faggot",
    		"fag",
    		"nigg",
    		"pokemaster561",
    		"nig",
    		"ratio",
    		"bitch",
    	    "abbo",
    	    "abo",
    	    "beeyotch",
    	    "biatch",
    	    "bitch",
    	    "chinaman",
    	    "chinamen",
    	    "chink",
    	    "coolie",
    	    "coon",
    	    "crip",
    	    "cuck",
    	    "cunt",
    	    "dago",
    	    "daygo",
    	    "dego",
    	    "dick",
    	    "douchebag",
    	    "dumb",
    	    "dyke",
    	    "eskimo",
    	    "fag",
    	    "faggot",
    	    "fatass",
    	    "fatso",
    	    "gash",
    	    "gimp",
    	    "golliwog",
    	    "gook",
    	    "goy",
    	    "goyim",
    	    "gyp",
    	    "gypsy",
    	    "half-breed",
    	    "halfbreed",
    	    "heeb",
    	    "homo",
    	    "hooker",
    	    "idiot",
    	    "insanitie",
    	    "jap",
    	    "kaffer",
    	    "kaffir",
    	    "kaffir",
    	    "kaffre",
    	    "kafir",
    	    "kike",
    	    "kraut",
    	    "lame",
    	    "lardass",
    	    "lesbo",
    	    "lunatic",
    	    "mick",
    	    "negress",
    	    "negro",
    	    "nig",
    	    "nig-nog",
    	    "nigga",
    	    "nigger",
    	    "nigguh",
    	    "nip",
    	    "pajeet",
    	    "paki",
    	    "pickaninnie",
    	    "pickaninny",
    	    "prostitute",
    	    "pussie",
    	    "pussy",
    	    "raghead",
    	    "retard",
    	    "sambo",
    	    "shemale",
    	    "skank",
    	    "slut",
    	    "soyboy",
    	    "spade",
    	    "sperg",
    	    "spic",
    	    "spook",
    	    "squaw",
    	    "street-shitter",
    	    "tard",
    	    "tits",
    	    "titt",
    	    "trannie",
    	    "tranny",
    	    "twat",
    	    "wetback",
    	    "whore",
    	    "wigger",
    	    "wop",
    	    "yid",
    	    "zog",
    	    "nihgggggers",
    	    "nihg",
    	    "kneegrow",
    	    "knegrow",
    	    "nîgger",
    	    "gger",
    	    "ñïger",
    	    "igga"
    	    
    		
    	};
    	try {
    		for (int i = 0; i != BLACKLISTED.length+1; i++) {
    			if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {
    				if (message.contains(BLACKLISTED[i])) {
                		event.getMessage().delete().queue();;
                		BASE_COMMAND base = new BASE_COMMAND(message, message, message, message, message, message, message, null, null);
                		
                		base.setTitle("Blacklisted word");
                		base.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
                		base.setDescription("Watch your tone. Do not use this language in this chat.");
                		base.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
                		base.setColor(Color.RED);
                		base.setTextChannel(event.getGuild().getTextChannelsByName("picnic-dump", true).get(0));
                		base.REPLY_IN_CHANNEL(event.getMessage());
                		base.setTitle("Blacklisted word");
                		base.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
                		base.setDescription("User "+ event.getMessage().getAuthor().getAsMention()+" used blacklisted word "+ BLACKLISTED[i]);
                		base.LOG_COMMAND(event.getMessage());
                		
                	 break;
            	 	}			
    			}
        	}
    	}catch(Exception e) {	
    	}

    	
    }

    	
}
