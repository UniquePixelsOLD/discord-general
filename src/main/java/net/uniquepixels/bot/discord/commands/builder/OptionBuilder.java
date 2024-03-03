package net.uniquepixels.bot.discord.commands.builder;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.uniquepixels.bot.discord.Builder;

public class OptionBuilder implements Builder<OptionData> {

        private final OptionData data;

        private OptionBuilder(OptionType type, String name, String description) {
            this.data = new OptionData(type, name, description);
        }

        private OptionBuilder(OptionType type, String name, String description, boolean isRequired) {
            this.data = new OptionData(type, name, description, isRequired);
        }

        private OptionBuilder(OptionType type, String name, String description, boolean isRequired, boolean autoComplete) {
            this.data = new OptionData(type, name, description, isRequired, autoComplete);
        }

        public static OptionBuilder createOptionBuilder(OptionType type, String name, String description, boolean isRequired, boolean autoComplete) {
            return new OptionBuilder(type, name, description, isRequired, autoComplete);
        }

        public static OptionBuilder newOptionBuilder(OptionType type, String name, String description, boolean isRequired) {
            return new OptionBuilder(type, name, description, isRequired);
        }

        public static OptionBuilder getOptionBuilder(OptionType type, String name, String description) {
            return new OptionBuilder(type, name, description);
        }

        public OptionBuilder addChoice(String name, String data) {
            this.data.addChoice(name, data);
            return this;
        }

        public OptionBuilder addChoice(String name, double data) {
            this.data.addChoice(name, data);
            return this;
        }

        public OptionBuilder addChoice(String name, long data) {
            this.data.addChoice(name, data);
            return this;
        }

        @Override
        public OptionData buildData() {
            return this.data;
        }
    }