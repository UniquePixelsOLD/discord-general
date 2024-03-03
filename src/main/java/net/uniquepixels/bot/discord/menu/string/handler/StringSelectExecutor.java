package net.uniquepixels.bot.discord.menu.string.handler;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public interface StringSelectExecutor {

    StringSelectMenu menu();

    void onMenuExecute(StringSelectInteractionEvent event);

}
