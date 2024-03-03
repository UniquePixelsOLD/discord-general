package net.uniquepixels.bot.discord.menu.string.handler;

import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.interactions.component.StringSelectInteractionImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringMenuListener extends ListenerAdapter {

    private static final List<StringSelectExecutor> MENUS = new ArrayList<>();

    public static List<StringSelectExecutor> getMenus() {
        return MENUS;
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        Optional<StringSelectExecutor> first = MENUS.stream().filter(menu -> menu.menu().getId().equals(event.getId())).findFirst();
        if (first.isEmpty())
            return;

        StringSelectExecutor commandExecutor = first.get();

        commandExecutor.onMenuExecute(event);
    }
}
