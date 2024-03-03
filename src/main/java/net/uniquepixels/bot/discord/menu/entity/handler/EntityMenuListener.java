package net.uniquepixels.bot.discord.menu.entity.handler;

import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntityMenuListener extends ListenerAdapter {

    private static final List<EntitySelectExecutor> MENUS = new ArrayList<>();

    public static List<EntitySelectExecutor> getMenus() {
        return MENUS;
    }

    @Override
    public void onEntitySelectInteraction(EntitySelectInteractionEvent event) {
        Optional<EntitySelectExecutor> first = MENUS.stream().filter(menu -> menu.menu().getId().equals(event.getId())).findFirst();
        if (first.isEmpty())
            return;

        EntitySelectExecutor commandExecutor = first.get();

        commandExecutor.onMenuExecute(event);
    }
}
