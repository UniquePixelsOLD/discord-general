package net.uniquepixels.bot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.uniquepixels.bot.discord.button.handler.ButtonListener;
import net.uniquepixels.bot.discord.commands.handler.CommandListener;
import net.uniquepixels.bot.discord.menu.entity.handler.EntityMenuListener;
import net.uniquepixels.bot.discord.menu.string.handler.StringMenuListener;
import net.uniquepixels.bot.discord.modal.handler.ModalListener;
import net.uniquepixels.bot.mongo.MongoConnection;

public class DiscordBot extends ListenerAdapter {
    public DiscordBot() throws InterruptedException {

        MongoConnection mongoConnection = new MongoConnection();

        JDABuilder builder = JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"));

        builder.addEventListeners(new CommandListener(), new ButtonListener(), new ModalListener(), new StringMenuListener(), new EntityMenuListener());

        builder.setActivity(Activity.watching("Discord UP Template"));

        JDA bot = builder.build().awaitReady();


    }

    public static void main(String[] args) throws InterruptedException {
        new DiscordBot();
    }
}