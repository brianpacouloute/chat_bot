package Main;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OOP_COMMANDS extends ListenerAdapter{
    public String prefix = "!";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        Guild guild = event.getGuild();
        User user = event.getAuthor();
        Member userMember = guild.getMember(user);
        TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
       // BASE_COMMAND baseCMD = new BASE_COMMAND(prefix, prefix, prefix, prefix, prefix, prefix, prefix, prefix, textChannel, Color.CYAN);
                
        //Here the commands start
if (args[0].equalsIgnoreCase(prefix + "giverole")) {
        		GIVE_ROLE giveCMD = new GIVE_ROLE("!","Test","Give Role Handler","Text","Text","Text",prefix, textChannel,Color.CYAN, null);
        		giveCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
        		giveCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
        		giveCMD.setColor(Color.CYAN);
           
            int permchecker = giveCMD.PERMISSION_CHECKER(userMember);
       		if (permchecker == 1) {    			
       			giveCMD.setTitle("Permission Handler");
       			giveCMD.setDescription("Permission not high enough");
       			giveCMD.REPLY_IN_CHANNEL(event.getMessage());	
       		} else {
                if (event.getMessage().getMentionedRoles().toArray().length == 1) {
                    if (event.getMessage().getMentionedUsers().toArray().length == 1) {
                    	giveCMD.setRole(event.getMessage().getMentionedRoles().get(0));
                    	giveCMD.setMember(event.getMessage().getGuild().getMember(event.getMessage().getMentionedUsers().get(0)));
                        giveCMD.GIVING_ROLE(event.getMessage());
                    } else {
                           giveCMD.setTitle("Role Giver");
                           giveCMD.setDescription("Please mention only 1 person to give a role. Please use ths format !giverole [user][role]");
                           giveCMD.REPLY_IN_CHANNEL(event.getMessage());
                    }

                } else {
                    giveCMD.setTitle("Role Giver");
                    giveCMD.setDescription("Please mention only 1 role to give. Please use ths format !giverole [user][role]");
                    giveCMD.REPLY_IN_CHANNEL(event.getMessage());
                }

       		}
        
}else if (args[0].equalsIgnoreCase(prefix + "removerole")){
    		REMOVE_ROLE removeCMD = new REMOVE_ROLE("!","Test","Remove Role Handler","Text","Text","Text",prefix, textChannel,Color.CYAN, userMember, null);
    		removeCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
    		removeCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
    		removeCMD.setColor(Color.red);
       
        int permchecker = removeCMD.PERMISSION_CHECKER(userMember);
   		if (permchecker == 1) {    			
   			removeCMD.setTitle("Permission Handler");
   			removeCMD.setDescription("Permission not high enough");
   			removeCMD.REPLY_IN_CHANNEL(event.getMessage());	
   		} else {
            if (event.getMessage().getMentionedRoles().toArray().length == 1) {
                if (event.getMessage().getMentionedUsers().toArray().length == 1) {
                	removeCMD.setMember( event.getMessage().getGuild().getMember(event.getMessage().getMentionedUsers().get(0)));
                	removeCMD.setRole(event.getMessage().getMentionedRoles().get(0));
                	removeCMD.ROLE_REMOVER(event.getMessage());
                } else {
                	removeCMD.setTitle("Role Giver");
                	removeCMD.setDescription("Please mention only 1 person to give a role. Please use ths format !giverole [user][role]");
                	removeCMD.REPLY_IN_CHANNEL(event.getMessage());
                }

            } else {
            	removeCMD.setTitle("Role Giver");
                removeCMD.setDescription("Please mention only 1 role to give. Please use ths format !giverole [user][role]");
                removeCMD.REPLY_IN_CHANNEL(event.getMessage());
            }

   		}
    
    		
}else if (args[0].equalsIgnoreCase(prefix + "ban")){
        	BAN_CLASS_CMD banCMD = new BAN_CLASS_CMD("!","Test","Kick Handler","Text","Text","Text",prefix, textChannel,Color.CYAN, args, userMember);
        		banCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
        		banCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
        		banCMD.setColor(Color.cyan);
        		
        		int permchecker = banCMD.PERMISSION_CHECKER(userMember);
              	if (permchecker == 1) {	
              		banCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
              		banCMD.setTitle("Permission Handler");
              		banCMD.setDescription("Permission not high enough");
              		banCMD.REPLY_IN_CHANNEL(event.getMessage());	
              	} else {
              		banCMD.setArgs(args);
              		try {
                  		banCMD.setTarg(event.getMessage().getMentionedMembers().get(0));
              		}catch(Exception e) {
              			
              		}
              		banCMD.BANNING_HANDLER(event.getMessage());
              	}
}else if (args[0].equalsIgnoreCase(prefix + "kick")){
        	KICK_CLASS_CMD kickCMD = new KICK_CLASS_CMD("!","Test","Kick Handler","Text","Text","Text",prefix, textChannel,Color.CYAN, args, userMember);
        		kickCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
        		kickCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
        		kickCMD.setColor(Color.cyan);
              
          	int permchecker = kickCMD.PERMISSION_CHECKER(userMember);
          	if (permchecker == 1) {	
          		kickCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
          		kickCMD.setTitle("Permission Handler");
          		kickCMD.setDescription("Permission not high enough");
          		kickCMD.REPLY_IN_CHANNEL(event.getMessage());	
          	} else {
          		kickCMD.setArgs(args);
          		
          		try {
              		kickCMD.setTarg(event.getMessage().getMentionedMembers().get(0));
          		}catch(Exception e) {
          			
          		}

          		kickCMD.KICK_HANDLER(event.getMessage());
          	}
          	
}else if (args[0].equalsIgnoreCase(prefix + "mute")) {
           // System.out.println("mute command run");
            //Mute command settings 
        	MUTE_CLASS_CMD muteCMD = new MUTE_CLASS_CMD("!","Test","Test","Test","Mute Handler","Text","Text","Text",textChannel,Color.red, args, userMember, null);
            muteCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
            muteCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
            muteCMD.setColor(Color.red);
            
        	int permchecker = muteCMD.PERMISSION_CHECKER(userMember);
        	if (permchecker == 1) {	
        		muteCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
        		muteCMD.setTitle("Permission Handler");
        		muteCMD.setDescription("Permission not high enough");
        		muteCMD.REPLY_IN_CHANNEL(event.getMessage());	
        	} else {
        			try {
        				if (args.length <=2) {
        				muteCMD.setDescription("Please try again. Please use this format !mute [user][reason]");
        				muteCMD.REPLY_IN_CHANNEL(event.getMessage());
        				} else {
        		        	Member target = event.getMessage().getMentionedMembers().get(0);
                            if (target.hasPermission(Permission.MESSAGE_MANAGE)) {
                            	System.out.println(muteCMD.getTitle());
                        	muteCMD.setTitle("Permission Handler");
                            muteCMD.setDescription("Cannot mute " + target.getAsMention() + " his permissions are too high.");
                            muteCMD.REPLY_IN_CHANNEL(event.getMessage());
                            } else {
                            	if (args.length>=1) {
                                  	muteCMD.setArgs(args);
                                  	muteCMD.setTarg(event.getMessage().getMentionedMembers().get(0));
                                  	muteCMD.setMuted(event.getMessage().getGuild().getRolesByName("naughty ❀", true).get(0));
                                  	muteCMD.MUTE_MEMBER(event.getMessage());

                            	} else {
                            		muteCMD.setDescription("Please try again. Please use this format !mute [user][time][reason]");
                            		muteCMD.REPLY_IN_CHANNEL(event.getMessage());
                            	}
                            }
                            }
        				}catch(Exception e) {
        					muteCMD.setTitle("Mute Handler");
        					muteCMD.setDescription("Please try again. Please use this format !mute [user][time][reason]");
        					muteCMD.REPLY_IN_CHANNEL(event.getMessage());
        				} 
                    	
        			}
        	
}else if (args[0].equalsIgnoreCase(prefix+ "start")) {
    Runnable r = new Runnable() {
		 BASE_COMMAND baseCMD = new BASE_COMMAND(prefix, prefix, prefix, prefix, prefix, prefix, prefix, textChannel, null);

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 for (int i = 0; i < 3000000; i++) {
				 baseCMD.setTitle("Bot Handler");
				 baseCMD.setThumnbnail("\"https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png\"");
				 baseCMD.setDescription("Bot started this will run every 30 minutes");
				 baseCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
				 baseCMD.setColor(Color.RED);
				 baseCMD.setTextChannel(event.getGuild().getTextChannelsByName("picnic-dump", true).get(0));
				 baseCMD.LOG_COMMAND(event.getMessage());
				 
				 sleep();
				 
			 }

		}
    	
    };
    Thread t = new Thread(r);
	t.start();

}else if (args[0].equalsIgnoreCase(prefix + "purge")) {
        	
    		//super(prefix, description, error, thumbnail, title, footer, footer2, errorModerator, textChannel, color);
        	
            PURGE_CLASS_CMD purgeCMD = new PURGE_CLASS_CMD("!", "Text", "Text", "Text", "Text", "Text", "Text", textChannel, Color.RED, args, null);
            purgeCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
            purgeCMD.setfooter("Message by " + event.getMessage().getAuthor().getAsTag());
            purgeCMD.setColor(Color.red);
            
        	int permchecker = purgeCMD.PERMISSION_CHECKER(userMember);
        	if (permchecker == 1) {	
        		purgeCMD.setThumnbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
        		purgeCMD.setTitle("Permission Handler");
        		purgeCMD.setDescription("Permission not high enough");
        		purgeCMD.REPLY_IN_CHANNEL(event.getMessage());	
        	} else {
        			if (args.length<2) {
        				purgeCMD.setTitle("Purge Handler");
        				purgeCMD.setDescription("Specify the amount to delete");
        				purgeCMD.REPLY_IN_CHANNEL(event.getMessage());
        			}else {
        				purgeCMD.setArgs(args);
        				purgeCMD.setList(event.getMessage().getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete());
        				purgeCMD.PURGE_MESSAGES(event.getMessage());
        			}
        	}
        	
        }
    }

        	
    public static void sleep() { // doing this because i know i will be using sleep a lot in this code FALSE.
        try { // Wait for 1 second because why not it's cool esthetics
            TimeUnit.SECONDS.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
		
}
