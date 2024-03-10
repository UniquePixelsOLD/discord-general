package net.uniquepixels.discord.general.giveaway.buttons;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.uniquepixels.discord.general.api.buttons.Button;
import net.uniquepixels.discord.general.giveaway.GiveawayManager;

public class EnterGiveaway implements Button {

    public final GiveawayManager giveawayManager;

    public EnterGiveaway(GiveawayManager giveawayManager) {
        this.giveawayManager = giveawayManager;
    }

    @Override
    public String id() {
        return "enter-giveaway";
    }

    @Override
    public void onExecute(ButtonInteractionEvent event) {

        event.deferReply(true).queue();

        long giveawayId = -1L;
        for (MessageEmbed.Field field : event.getMessage().getEmbeds().get(0).getFields()) {

            if (field.getName().equals("Giveaway Id")) {
                giveawayId = Long.parseLong(field.getValue());
                break;
            }

        }

        this.giveawayManager.enterGiveaway(event.getMember(), giveawayId, event.getHook());

    }
}
