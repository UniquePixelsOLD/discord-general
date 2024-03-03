package net.uniquepixels.bot.discord.modal.handler;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModalListener extends ListenerAdapter {

    private final List<ModalExecutor> MODALS = new ArrayList<>();

    public List<ModalExecutor> getModals() {
        return MODALS;
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {

        Optional<ModalExecutor> first = MODALS.stream().filter(buttonExecutor -> event.getModalId().equals(buttonExecutor.modal().getId())).findFirst();

        if (first.isEmpty())
            return;

        ModalExecutor buttonExecutor = first.get();

        buttonExecutor.onModalExecute(event);

    }
}
