package net.uniquepixels.bot.discord.menu;

public interface MenuDefault<T> {

    T setMinValues(int amount);
    T setMaxValues(int amount);
    T setPlaceholder(String placeholder);

}
