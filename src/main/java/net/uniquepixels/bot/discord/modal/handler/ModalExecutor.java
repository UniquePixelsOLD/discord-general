package net.uniquepixels.bot.discord.modal.handler;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.modals.Modal;

public interface ModalExecutor {

    Modal modal();

    void onModalExecute(ModalInteractionEvent event);

}
