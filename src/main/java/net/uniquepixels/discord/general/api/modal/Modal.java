package net.uniquepixels.discord.general.api.modal;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;

public interface Modal {

    String id();

    void onExecute(ModalInteractionEvent event);

}
