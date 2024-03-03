package net.uniquepixels.bot.discord.commands.builder;

import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.uniquepixels.bot.discord.Builder;
import net.uniquepixels.bot.discord.LocalizedDescription;

public class SubCommandGroupBuilder implements LocalizedDescription<SubCommandGroupBuilder>, Builder<SubcommandGroupData> {

        private final SubcommandGroupData data;

        public SubCommandGroupBuilder(String name, String description) {
            this.data = new SubcommandGroupData(name, description);
        }

        @Override
        public SubCommandGroupBuilder setDescriptionLocale(DiscordLocale locale, String description) {
            this.data.setDescriptionLocalization(locale, description);
            return this;
        }

        public SubCommandGroupBuilder addSubCommand(SubCommandBuilder builder) {
            this.data.addSubcommands(builder.buildData());
            return this;
        }

        @Override
        public SubcommandGroupData buildData() {
            return this.data;
        }
    }