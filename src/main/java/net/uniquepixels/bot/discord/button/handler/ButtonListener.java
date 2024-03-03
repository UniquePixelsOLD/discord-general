package net.uniquepixels.bot.discord.button.handler;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ButtonListener extends ListenerAdapter {

    private final static List<ButtonExecutor> BUTTONS = new ArrayList<>();

    public static List<ButtonExecutor> getButtons() {
        return BUTTONS;
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {

        Optional<ButtonExecutor> first = BUTTONS.stream().filter(buttonExecutor -> event.getButton().getId().equals(buttonExecutor.button().getButtonId())).findFirst();

        if (first.isEmpty())
            return;

        ButtonExecutor buttonExecutor = first.get();

        buttonExecutor.onButtonExecute(event);

    }
}
