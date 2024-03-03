package net.uniquepixels.bot.discord.modal;

import net.dv8tion.jda.api.interactions.modals.Modal;
import net.uniquepixels.bot.discord.Builder;

public class ModalBuilder implements Builder<Modal> {

    private final Modal.Builder modal;

    private ModalBuilder(String id, String name) {
        this.modal = Modal.create(id, name);
    }

    public static ModalBuilder createModal(String id, String name) {
        return new ModalBuilder(id, name);
    }

    public ModalBuilder addTextLine(TextInputBuilder builder) {
        this.modal.addActionRow(builder.buildData());
        return this;
    }

    @Override
    public Modal buildData() {
        return this.modal.build();
    }
}
