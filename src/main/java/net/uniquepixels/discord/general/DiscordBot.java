package net.uniquepixels.discord.general;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.uniquepixels.discord.general.api.buttons.ButtonHandler;
import net.uniquepixels.discord.general.api.commands.CommandHandler;
import net.uniquepixels.discord.general.api.menu.SelectionMenuHandler;
import net.uniquepixels.discord.general.api.modal.ModalHandler;

public class DiscordBot extends ListenerAdapter {
    public DiscordBot() throws InterruptedException {

        JDABuilder builder = JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"));

        CommandHandler commandHandler = new CommandHandler();
        ButtonHandler buttonHandler = new ButtonHandler();
        ModalHandler modalHandler = new ModalHandler();
        SelectionMenuHandler selectionMenuHandler = new SelectionMenuHandler();
        builder.addEventListeners(commandHandler, buttonHandler, modalHandler, selectionMenuHandler);

        builder.setActivity(Activity.watching("Discord UP Template"));

        JDA bot = builder.build().awaitReady();

        Guild guild = bot.getGuilds().get(0);

        commandHandler.updateCommands(guild);

    }

    public static void main(String[] args) throws InterruptedException {
        new DiscordBot();
    }
}