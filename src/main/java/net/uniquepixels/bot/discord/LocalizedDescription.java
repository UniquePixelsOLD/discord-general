package net.uniquepixels.bot.discord;

import net.dv8tion.jda.api.interactions.DiscordLocale;

public interface LocalizedDescription<T> {

    T setDescriptionLocale(DiscordLocale locale, String description);
}
