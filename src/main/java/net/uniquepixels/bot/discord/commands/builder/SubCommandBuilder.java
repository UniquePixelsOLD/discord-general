package net.uniquepixels.bot.discord.commands.builder;

import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.uniquepixels.bot.discord.Builder;
import net.uniquepixels.bot.discord.LocalizedDescription;

import java.util.Arrays;

public class SubCommandBuilder implements LocalizedDescription<SubCommandBuilder>, Builder<SubcommandData> {

    private final SubcommandData data;

    private SubCommandBuilder(String name, String description) {
        this.data = new SubcommandData(name, description);
    }

    public static SubCommandBuilder subCommand(String name, String description) {
        return new SubCommandBuilder(name, description);
    }

    public SubCommandBuilder addOption(OptionType type, String name, String description) {
        this.data.addOption(type, name, description);
        return this;
    }

    public SubCommandBuilder addOption(OptionType type, String name, String description, boolean required) {
        this.data.addOption(type, name, description, required);
        return this;
    }

    public SubCommandBuilder addOption(OptionType type, String name, String description, boolean required, boolean autoComplete) {
        this.data.addOption(type, name, description, required, autoComplete);
        return this;
    }

    public SubCommandBuilder removeOptionByName(String option) {
        this.data.removeOptionByName(option);
        return this;
    }

    public SubCommandBuilder addOptions(OptionBuilder... builders) {
        this.data.addOptions(Arrays.stream(builders).map(OptionBuilder::buildData).toList());
        return this;
    }

    @Override
    public SubcommandData buildData() {
        return this.data;
    }

    @Override
    public SubCommandBuilder setDescriptionLocale(DiscordLocale locale, String description) {
        this.data.setDescriptionLocalization(locale, description);
        return this;
    }
}