package net.uniquepixels.bot.discord.menu.string;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.uniquepixels.bot.discord.Builder;
import net.uniquepixels.bot.discord.menu.MenuDefault;

public class StringSelectMenuBuilder implements MenuDefault<StringSelectMenuBuilder>, Builder<StringSelectMenu> {

    private final StringSelectMenu.Builder builder;

    public StringSelectMenuBuilder(String id) {
        this.builder = StringSelectMenu.create(id);
    }

    public StringSelectMenuBuilder addOption(String label, String value) {
        this.builder.addOption(label, value);
        return this;
    }

    public StringSelectMenuBuilder addOption(String label, String value, String description) {
        this.builder.addOption(label, value, description);
        return this;
    }

    public StringSelectMenuBuilder addOption(String label, String value, String description, Emoji emoji) {
        this.builder.addOption(label, value, description, emoji);
        return this;
    }

    public StringSelectMenuBuilder addOption(String label, String value, Emoji emoji) {
        this.builder.addOption(label, value, emoji);
        return this;
    }

    @Override
    public StringSelectMenu buildData() {
        return builder.build();
    }

    @Override
    public StringSelectMenuBuilder setMinValues(int amount) {
        this.builder.setMinValues(amount);
        return this;
    }

    @Override
    public StringSelectMenuBuilder setMaxValues(int amount) {
        this.builder.setMaxValues(amount);
        return this;
    }

    @Override
    public StringSelectMenuBuilder setPlaceholder(String placeholder) {
        this.builder.setPlaceholder(placeholder);
        return this;
    }
}
