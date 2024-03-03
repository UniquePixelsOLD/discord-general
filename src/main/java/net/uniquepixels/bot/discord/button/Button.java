package net.uniquepixels.bot.discord.button;

import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;

public class Button {

    private final String buttonId;
    private final ButtonStyle style;
    private final String buttonName;

    public Button(String buttonId, ButtonStyle style, String buttonName) {
        this.buttonId = buttonId;
        this.style = style;
        this.buttonName = buttonName;
    }

    public String getButtonId() {
        return buttonId;
    }

    public ButtonStyle getStyle() {
        return style;
    }

    public String getButtonName() {
        return buttonName;
    }
}
