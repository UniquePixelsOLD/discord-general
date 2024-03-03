package net.uniquepixels.bot.discord.modal;

import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.uniquepixels.bot.discord.Builder;

public class TextInputBuilder implements Builder<TextInput> {

    private final TextInput.Builder textInput;

    public TextInputBuilder(String id, String label, boolean useParagraph) {
        this.textInput = TextInput.create(id, label, useParagraph ? TextInputStyle.PARAGRAPH : TextInputStyle.SHORT);
    }

    public TextInputBuilder setPlaceholder(String placeholder) {
        this.textInput.setPlaceholder(placeholder);
        return this;
    }

    public TextInputBuilder setMaxLength(int length) {
        this.textInput.setMaxLength(length);
        return this;
    }

    public TextInputBuilder setMinLength(int length) {
        this.textInput.setMinLength(length);
        return this;
    }

    public TextInputBuilder setRequired(boolean required) {
        this.textInput.setRequired(required);
        return this;
    }

    public TextInputBuilder setValue(String value) {
        this.textInput.setValue(value);
        return this;
    }

    @Override
    public TextInput buildData() {
        return this.textInput.build();
    }
}

