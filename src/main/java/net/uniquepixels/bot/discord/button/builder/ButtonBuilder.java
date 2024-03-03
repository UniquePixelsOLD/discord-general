package net.uniquepixels.bot.discord.button.builder;

import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import net.uniquepixels.bot.discord.button.Button;

public class ButtonBuilder {
    private String buttonId;
    private ButtonStyle style = ButtonStyle.PRIMARY;
    private String buttonName;

    public ButtonBuilder setButtonId(String buttonId) {
        this.buttonId = buttonId;
        return this;
    }

    public ButtonBuilder setStyle(ButtonStyle style) {
        this.style = style;
        return this;
    }

    public ButtonBuilder setButtonName(String buttonName) {
        this.buttonName = buttonName;
        return this;
    }

    public Button createButton() {
        return new Button(buttonId, style, buttonName);
    }
}