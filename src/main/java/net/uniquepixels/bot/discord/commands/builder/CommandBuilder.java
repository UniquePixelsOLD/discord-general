package net.uniquepixels.bot.discord.commands.builder;

import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import net.uniquepixels.bot.discord.Builder;

import java.util.Arrays;

public class CommandBuilder implements Builder<CommandDataImpl> {

    private final CommandDataImpl data;

    private CommandBuilder(Command.Type type, String name) {
        this.data = new CommandDataImpl(type, name);
    }

    public static CommandBuilder createCommand(Command.Type type, String name) {
        return new CommandBuilder(type, name);
    }

    public CommandBuilder addDescription(DiscordLocale locale, String description) {
        this.data.setDescriptionLocalization(locale, description);
        return this;
    }

    public CommandBuilder setDescription(String description) {
        this.data.setDescription(description);
        return this;
    }

    public CommandBuilder addPermission(DefaultMemberPermissions permissions) {
        this.data.setDefaultPermissions(permissions);
        return this;
    }

    public CommandBuilder addSubCommand(SubCommandBuilder builder) {
        this.data.addSubcommands(builder.buildData());
        return this;
    }

    public CommandBuilder addSubCommandGroup(SubCommandBuilder builder) {
        this.data.addSubcommands(builder.buildData());
        return this;
    }

    public CommandBuilder addOption(OptionType type, String name, String description) {
        this.data.addOption(type, name, description);
        return this;
    }

    public CommandBuilder addOption(OptionType type, String name, String description, boolean required) {
        this.data.addOption(type, name, description, required);
        return this;
    }

    public CommandBuilder addOption(OptionType type, String name, String description, boolean required, boolean autoComplete) {
        this.data.addOption(type, name, description, required, autoComplete);
        return this;
    }

    public CommandBuilder removeOptionByName(String option) {
        this.data.removeOptionByName(option);
        return this;
    }

    public CommandBuilder addOptions(OptionBuilder... builders) {
        this.data.addOptions(Arrays.stream(builders).map(OptionBuilder::buildData).toList());
        return this;
    }

    @Override
    public CommandDataImpl buildData() {
        return this.data;
    }
}
