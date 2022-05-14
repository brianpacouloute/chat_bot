package Archive;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

//https://www.youtube.com/watch?v=BPvg9bndP1U -RUNNING IT 24/7
//https://www.youtube.com/watch?v=mg0Y2LFPI5U -JOIN AND LEAVE EVENTS

public class Commands extends ListenerAdapter {
	
	
    public String prefix = "!";
    public static void sleep(String args) { // doing this because i know i will be using sleep a lot in this code FALSE.
        try { // Wait for 1 second because why not it's cool esthetics
            TimeUnit.SECONDS.sleep(Integer.parseInt(args));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void SLEEP_1SECOND() { // doing this because i know i will be using sleep a lot in this code FALSE.
        try { // Wait for 1 second because why not it's cool esthetics
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        //These following commands can only be run by admins 
        Guild guild = event.getGuild();
        User user = event.getAuthor();
        Member userMember = guild.getMember(user);






        //This command will give roles to users if they have administrator perms or higher
        //Important things i can save for the future 
        //event.getMessage().reply("Please mention only 1 role to give").queue();
        //--------------------------------------------------------------//
        if (args[0].equalsIgnoreCase(prefix + "giverole")) {
            if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {

                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                String Title = "Permission Handler";
                String Description = "Permission not high enough";
                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());



            } else {
                if (event.getMessage().getMentionedRoles().toArray().length == 1) {
                    if (event.getMessage().getMentionedUsers().toArray().length == 1) {
                        Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
                        Role roleToGive = event.getMessage().getMentionedRoles().get(0);

                        event.getGuild().addRoleToMember(member, roleToGive).queue();



                        TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                        EmbedBuilder embed1 = new EmbedBuilder();
                        embed1.setTitle("Role Giver: " + event.getMessage().getMember().getUser().getName());
                        embed1.setDescription(event.getMessage().getAuthor().getAsMention() + " has given " + roleToGive.getAsMention() + " to " + member.getAsMention());
                        embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                        embed1.setColor(Color.CYAN);
                        embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
                        textChannel.sendMessage(embed1.build()).queue();
                        embed1.clear();


                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                        String Title = "Role Giver";
                        String Description = "Gave the role " + roleToGive.getAsMention() + "to " + member.getAsMention();
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                        

                    } else {

                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                        String Title = "Role Giver";
                        String Description = "Please mention only 1 person to give a role. Please use ths format !giverole [user][role]";
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                    }
                } else {

                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                    String Title = "Role Giver";
                    String Description = "Please mention 1 role to give. Please use ths format !giverole [user][role]";
                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                    SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                }
            } //End of perm check

        }

        //This command will remove roles to users if they have administrator perms or higher
        //Important things i can save for the future 
        //event.getMessage().reply("Please mention only 1 role to give").queue();
        //--------------------------------------------------------------//
        if (args[0].equalsIgnoreCase(prefix + "removerole")) {
            if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {


                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                String Title = "Permission Handler";
                String Description = "Permission not high enough";
                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


            } else {
                if (event.getMessage().getMentionedRoles().toArray().length == 1) {
                    if (event.getMessage().getMentionedUsers().toArray().length == 1) {
                        Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
                        Role roleToRemove = event.getMessage().getMentionedRoles().get(0);
                        event.getGuild().removeRoleFromMember(member, roleToRemove).queue();

                        if (member.hasPermission(Permission.MESSAGE_MANAGE)) {
                        	 String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                             String Title = "Role Remover";
                             String Description = "Cannot remove roles "+ member.getAsMention() + "'s permissions are too high.";
                             String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                             String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                             SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                        }else {
                            
                        	
                            TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                            EmbedBuilder embed1 = new EmbedBuilder();
                            embed1.setTitle("Role Remover: " + event.getMessage().getMember().getUser().getName());
                            embed1.setDescription(event.getMessage().getAuthor().getAsMention() + " has removed " + roleToRemove.getAsMention() + " from " + member.getAsMention());
                            embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                            embed1.setColor(Color.CYAN);
                            embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
                            textChannel.sendMessage(embed1.build()).queue();
                            embed1.clear();


                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                            String Title = "Role Remover";
                            String Description = "Removed the role " + roleToRemove.getAsMention() + "to " + member.getAsMention();
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                        	  
                        	  
                        }

                    
                    } else {

                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                        String Title = "Role Remover";
                        String Description = "Please mention only 1 person to remove a role";
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                    }
                } else {
                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                    String Title = "Role Remover";
                    String Description = "Please mention 1 role to remove. Please use this format !removerole [user][role]";
                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                    SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                }
            } //End of perm check

        }


        if (args[0].equalsIgnoreCase(prefix + "ban")) {
        	if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {
                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                String Title = "Permission Handler";
                String Description = "Permission not high enough";
                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

            } else {
                try {


                    if (args.length < 2) {

                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                        String Title = "Ban Handler";
                        String Description = "Specify the person to Ban. Please use this formate !Ban [user][reason]";
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                    } else {
                        Member target = event.getMessage().getMentionedMembers().get(0);

                        if (target.hasPermission(Permission.MESSAGE_MANAGE)) {

                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                            String Title = "Ban Handler";
                            String Description = "Cannot ban " + target.getAsMention() + " his permissions are too high.";
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                        } else {
                            if (args.length >= 4) {
                                String reason = " ";
                                for (int i = 3; i < args.length; i++) {
                                    reason += args[i] + " ";
                                }


                                event.getGuild().ban(target, 0).queue();


                                TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                                EmbedBuilder embed1 = new EmbedBuilder();
                                embed1.setTitle("Ban Handler: " + event.getMessage().getMember().getUser().getName());
                                embed1.setDescription("Member " + args[1] + " was banned by " + event.getMessage().getAuthor().getAsMention() + " because of the reason " + reason);
                                embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                                embed1.setColor(Color.CYAN);
                                embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
                                textChannel.sendMessage(embed1.build()).queue();
                                embed1.clear();

                                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                                String Title = "Ban Handler";
                                String Description = "Member " + args[1] + " was banned by " + event.getMessage().getAuthor().getAsMention() + " because of the reason " + reason + ". ";
                                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                                SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                            } else {
                                event.getGuild().ban(target, 0).queue();

                                TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                                EmbedBuilder embed1 = new EmbedBuilder();
                                embed1.setTitle("Ban Handler: " + event.getMessage().getMember().getUser().getName());
                                embed1.setDescription("Member " + args[1] + " was banned by " + event.getMessage().getAuthor().getAsMention());
                                embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                                embed1.setColor(Color.cyan);
                                embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png");
                                textChannel.sendMessage(embed1.build()).queue();
                                embed1.clear();



                                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                                String Title = "Ban Handler";
                                String Description = "Member " + args[1] + " was banned by " + event.getMessage().getAuthor().getAsMention() + ". ";
                                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                                SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                            }

                        }


                    }

                } catch (Exception e) {
                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                    String Title = "Kick Handler";
                    String Description = "Specify the person to kick. Please use this formate !kick [user][reason]";
                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                    SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                }
            }
	
        }
 



        if (args[0].equalsIgnoreCase(prefix + "kick")) {
            if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {
                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                String Title = "Permission Handler";
                String Description = "Permission not high enough";
                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

            } else {
                try {


                    if (args.length < 2) {

                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                        String Title = "Kick Handler";
                        String Description = "Specify the person to kick. Please use this formate !kick [user][reason]";
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                    } else {
                        Member target = event.getMessage().getMentionedMembers().get(0);

                        if (target.hasPermission(Permission.MESSAGE_MANAGE)) {

                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                            String Title = "Kick Handler";
                            String Description = "Cannot kick " + target.getAsMention() + " his permissions are too high.";
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                        } else {
                            if (args.length >= 4) {
                                String reason = " ";
                                for (int i = 3; i < args.length; i++) {
                                    reason += args[i] + " ";
                                }

                                event.getGuild().kick(target, reason).queue();


                                TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                                EmbedBuilder embed1 = new EmbedBuilder();
                                embed1.setTitle("Kick Handler: " + event.getMessage().getMember().getUser().getName());
                                embed1.setDescription("Member " + args[1] + " was kicked by " + event.getMessage().getAuthor().getAsMention() + " because of the reason " + reason);
                                embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                                embed1.setColor(Color.red);
                                embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
                                textChannel.sendMessage(embed1.build()).queue();
                                embed1.clear();

                                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                                String Title = "Kick Handler";
                                String Description = "Member " + args[1] + " was kick by " + event.getMessage().getAuthor().getAsMention() + " because of the reason " + reason + ". ";
                                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                                SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                            } else {
                                event.getGuild().kick(target).queue();


                                TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                                EmbedBuilder embed1 = new EmbedBuilder();
                                embed1.setTitle("Kick Handler: " + event.getMessage().getMember().getUser().getName());
                                embed1.setDescription("Member " + args[1] + " was kicked by " + event.getMessage().getAuthor().getAsMention());
                                embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                                embed1.setColor(Color.red);
                                embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
                                textChannel.sendMessage(embed1.build()).queue();
                                embed1.clear();



                                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                                String Title = "Kick Handler";
                                String Description = "Member " + args[1] + " was kick by " + event.getMessage().getAuthor().getAsMention() + ". ";
                                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                                SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                            }

                        }


                    }

                } catch (Exception e) {
                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                    String Title = "Kick Handler";
                    String Description = "Specify the person to kick. Please use this formate !kick [user][reason]";
                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                    SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                }
            }

        }






        if (args[0].equalsIgnoreCase(prefix + "mute")) {
            if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {

                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                String Title = "Permission Handler";
                String Description = "Permission not high enough";
                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


            } else {
                try {
                    if (args.length <= 1) {
                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                        String Title = "Mute Handler";
                        String Description = "Please try again. Please use this format !mute [user][reason]";
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                    } else {
                        Member target = event.getMessage().getMentionedMembers().get(0);
                        Role muted = event.getGuild().getRolesByName("naughty ❀", true).get(0);




                        if (target.hasPermission(Permission.MESSAGE_MANAGE)) {

                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                            String Title = "Mute Handler";
                            String Description = "Cannot mute " + target.getAsMention() + " his permissions are too high.";
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                            	

                        } else {
                        if (args.length >= 2) {
                            String reason = " ";
                            for (int i = 4; i < args.length; i++) {
                                reason += args[i] + " ";
                            }
                            EmbedBuilder embed1 = new EmbedBuilder();
                            TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);


                            for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                                if (i == 0) {
                                    event.getGuild().addRoleToMember(target, muted).queue();

                                    embed1.setTitle("Mute Handler: " + event.getMessage().getMember().getUser().getName());
                                    embed1.setDescription("Member " + args[1] + " was muted by " + event.getMessage().getAuthor().getAsMention() + " because of the reason " + reason + " for " + args[3]);
                                    embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                                    embed1.setColor(Color.red);
                                    embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
                                    textChannel.sendMessage(embed1.build()).queue();
                                    embed1.clear();

                                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                                    String Title = "Mute Handler";
                                    String Description = "Member " + args[1] + " was muted by " + event.getMessage().getAuthor().getAsMention() + " because of the reason " + reason + " for " + args[3] + " seconds. ";
                                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                                    SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                                }
                                SLEEP_1SECOND();
                            }

                            event.getGuild().removeRoleFromMember(target, muted).queue();

                            embed1.setTitle("Mute Handler: " + event.getMessage().getMember().getUser().getName());
                            embed1.setDescription("Member " + args[1] + " was unmuted automatically.");
                            embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                            embed1.setColor(Color.red);
                            embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
                            textChannel.sendMessage(embed1.build()).queue();
                            embed1.clear();
                        } else {

                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                            String Title = "Mute Handler";
                            String Description = "Please try again. Please use this format !mute [user][time][reason]";
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                        }

                    }
                    }
                } catch (Exception e) {

                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                    String Title = "Mute Handler";
                    String Description = "Please try again. Please use this format !mute [user][time][reason]";
                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                    SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                }
                

            }
                
        }
        if (args[0].equalsIgnoreCase(prefix+"say")) {
        	  if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {

                  String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                  String Title = "Permission Handler";
                  String Description = "Permission not high enough";
                  String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                  String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                  SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

              } else {
                  if (args.length < 2) {
                	  String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                      String Title = "Purge Handler";
                      String Description = "Error please try again. Please use the format !say [channel] [title] [message] ";
                      String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                      String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                      SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                  } else {
                	  try {
                		  TextChannel textChannel = event.getGuild().getTextChannelsByName(args[1], true).get(0);
                		  
                		  //ERROR IS HERE GUYS CHECK HERE
                		
                          EmbedBuilder embed1 = new EmbedBuilder();
                          embed1.setTitle(args[2] + event.getMessage().getMember().getUser().getName());
                          embed1.setDescription(args[3]);
                          embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                          embed1.setColor(Color.CYAN);
                          embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
                          textChannel.sendMessage(embed1.build()).queue();
                          embed1.clear();

                	  }catch (Exception e) {
                    	  String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                          String Title = "Purge Handler";
                          String Description = "Error please try again. Please use the format !say [channel] [title] [message]";
                          String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                          String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                          SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());
                	  }
                  }
              }
        }


        //This command will clear messages in the chat
        //Important things i can save for the future  
        //--------------------------------------------------------------//
        if (args[0].equalsIgnoreCase(prefix + "purge")) {
            if (!userMember.hasPermission(Permission.ADMINISTRATOR)) {

                String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                String Title = "Permission Handler";
                String Description = "Permission not high enough";
                String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

            } else {
                if (args.length < 2) {

                    String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                    String Title = "Purge Handler";
                    String Description = "Specify the amount to delete";
                    String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                    String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                    SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                } else {
                    try {
                        List < Message > messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                        event.getChannel().deleteMessages(messages).queue();

                        TextChannel textChannel = event.getGuild().getTextChannelsByName("picnic-dump", true).get(0);
                        EmbedBuilder embed1 = new EmbedBuilder();
                        embed1.setTitle("Purge Handler: " + event.getMessage().getMember().getUser().getName());
                        embed1.setDescription(args[1] + " Messages purged from " + event.getChannel().getAsMention() + " by " + event.getMessage().getAuthor().getAsMention());
                        embed1.setFooter("Message by " + event.getMessage().getAuthor().getAsTag(), event.getMessage().getAuthor().getAvatarUrl());
                        embed1.setColor(Color.RED);
                        embed1.setThumbnail("https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png");
                        textChannel.sendMessage(embed1.build()).queue();
                        embed1.clear();

                        String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                        String Title = "Purge Handler";
                        String Description = args[1] + " Messages purged from " + event.getChannel().getAsMention();
                        String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                        String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                        SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());


                    } catch (IllegalArgumentException e) {
                        if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/972217741434048562/3183-amehappy.png";
                            String Title = "Purge Handler";
                            String Description = "Error please try again too many messages selected. Between 1-100 messages can be deleted.";
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_RED(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                        } else {

                            String Thumbnail = "https://cdn.discordapp.com/attachments/953505303893262348/971967036215422986/9675-kangelrawr.png";
                            String Title = "Purge Handler";
                            String Description = "Error please try again";
                            String Footer = "Message by " + event.getMessage().getAuthor().getAsTag();
                            String Footer2 = event.getMessage().getAuthor().getAvatarUrl();
                            SEND_RESPONSE_MESSAGE_CYAN(Thumbnail, Title, Description, Footer, Footer2, event.getMessage());

                           
                        }

                    }
                }





            } //End of perm check
        }



    }


    private void SEND_RESPONSE_MESSAGE_RED(String thumbnail, String title, String description, String footer, String footer2, Message message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setThumbnail(thumbnail);
        embed.setTitle(title); 
        embed.setDescription(description);
        embed.setFooter(footer, footer2);
        embed.setColor(Color.RED);
        message.reply(embed.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
        embed.clear();
    }

   

    private void SEND_RESPONSE_MESSAGE_CYAN(String thumbnail, String title, String description, String footer, String footer2, Message message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setThumbnail(thumbnail);
        embed.setTitle(title);
        embed.setDescription(description);
        embed.setFooter(footer, footer2);
        embed.setColor(Color.cyan);
        message.reply(embed.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
        embed.clear();
    }

}
