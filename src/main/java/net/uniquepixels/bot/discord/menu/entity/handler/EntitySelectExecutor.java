package net.uniquepixels.bot.discord.menu.entity.handler;

import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;

public interface EntitySelectExecutor {

    EntitySelectMenu menu();

    void onMenuExecute(EntitySelectInteractionEvent event);

}
