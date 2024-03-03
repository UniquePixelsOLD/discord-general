package net.uniquepixels.bot.discord.commands.handler;

import net.dv8tion.jda.internal.interactions.CommandDataImpl;

public interface CommandExecutor<E> {

    CommandDataImpl data();

    Class<E> type();

    void onEvent(E event);

}
