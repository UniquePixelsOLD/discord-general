package net.uniquepixels.discord.general.giveaway;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.InteractionHook;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public record GiveawayManager(Guild guild, GiveawayBackend backend) {

    public void createGiveaway(Member creator, long duration, TimeUnit unit, String price, int maxWinners, boolean publish, InteractionHook hook) {
        try {
            Optional<Giveaway> optional = this.backend.createGiveaway(creator, duration, unit, price, maxWinners);

            if (optional.isEmpty()) {
                hook.editOriginal("Das Giveaway konnte nicht richtig erstellt werden! Versuche es später erneut.").queue();
                return;
            }

            Giveaway giveaway = optional.get();

            if (publish) {
                this.publishGiveaway(giveaway.giveawayId(), hook);
                return;
            }

            hook.editOriginal("Das Giveaway wurde erstellt und kann unter der ID **" + giveaway.giveawayId() + "** erreicht werden!").queue();

        } catch (IOException e) {
            hook.editOriginal("Ein Fehler ist aufgetreten! Versuche es später erneut (GIVEAWAY#BACKEND)").queue();
        }
    }

    public void publishGiveaway(long giveawayId, InteractionHook hook) {

        try {
            this.backend.publishGiveaway(giveawayId);
            hook.editOriginal("Das Giveaway (**" + giveawayId + "**) wurde erstellt und direkt gestartet!").queue();
        } catch (IOException e) {
            hook.editOriginal("Das Giveaway (**" + giveawayId + "**) konnte nicht gestartet werden!").queue();
        }

    }

    public void deleteGiveaway(long giveawayId, InteractionHook hook) {

        hook.editOriginal("Das Giveaway (**" + giveawayId + "**) wurde gelöscht!").queue();

        try {

            if (this.backend.deleteGiveaway(giveawayId)) {
                hook.editOriginal("Das Giveaway (**" + giveawayId + "**) wurde gelöscht!").queue();
            } else
                hook.editOriginal("Das Giveaway (**" + giveawayId + "**) konnte nicht gelöscht werden, da es nicht existiert!").queue();

        } catch (IOException e) {
            hook.editOriginal("Das Giveaway (**" + giveawayId + "**) konnte nicht gelöscht werden!").queue();
        }

    }

    public void enterGiveaway(Member memberToEnter, long giveawayId, InteractionHook hook) {

        try {
            if (this.backend.enterGiveaway(memberToEnter.getIdLong(), giveawayId)) {



            }
        } catch (IOException e) {
            hook.editOriginal("Du konntest nicht hinzugefügt werden! Bitte versuche es später erneut.").queue();
        }

    }


}
