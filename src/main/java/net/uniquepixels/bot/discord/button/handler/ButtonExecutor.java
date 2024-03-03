package net.uniquepixels.bot.discord.button.handler;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.uniquepixels.bot.discord.button.Button;

public interface ButtonExecutor {

    Button button();

    void onButtonExecute(ButtonInteractionEvent event);

}
