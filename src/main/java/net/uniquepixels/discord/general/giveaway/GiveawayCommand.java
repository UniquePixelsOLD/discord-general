package net.uniquepixels.discord.general.giveaway;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import net.uniquepixels.discord.general.api.commands.slashcommands.SlashCommand;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GiveawayCommand implements SlashCommand {

    // giveaway <create/delete/start>

    private final GiveawayManager giveawayManager;

    public GiveawayCommand(GiveawayManager giveawayManager) {
        this.giveawayManager = giveawayManager;
    }

    @Override
    public CommandDataImpl commandData() {

        OptionData unit = new OptionData(OptionType.STRING, "unit", "In welchem Format soll die Zeit gerechnet werden?");
        for (TimeUnit value : TimeUnit.values()) {
            unit.addChoice(value.name().toLowerCase(), value.name());
        }

        return new CommandDataImpl("giveaway", "Giveaways")
                .addSubcommands(
                        new SubcommandData("create", "Erstelle ein Giveaway")
                                .addOption(OptionType.STRING, "price", "Was kann man bei dem Giveaway gewinnen?", true)
                                .addOption(OptionType.INTEGER, "winners", "Wie viele Nutzer können gewinnen?", true)
                                .addOption(OptionType.INTEGER, "duration", "Wie lang geht das Giveaway?", true)
                                .addOptions(unit)
                                .addOption(OptionType.BOOLEAN, "start", "Soll das Giveaway direkt gestartet werden?"),
                        new SubcommandData("publish", "Starte ein Giveaway")
                                .addOption(OptionType.INTEGER, "id", "Die ID des Giveaways", true),
                        new SubcommandData("delete", "Lösche ein Giveaway")
                                .addOption(OptionType.INTEGER, "id", "Die ID des Giveaways", true)
                );
    }

    @Override
    public void onExecute(SlashCommandInteractionEvent event) {

        Member member = event.getMember();
        assert member != null;

        switch (event.getSubcommandName().toLowerCase()) {
            case "create" -> {

                event.deferReply(true).queue();

                String price = event.getOption("price", OptionMapping::getAsString);
                int winners = event.getOption("winners", OptionMapping::getAsInt).intValue();
                long duration = event.getOption("duration", OptionMapping::getAsLong).longValue();
                TimeUnit unit = TimeUnit.valueOf(event.getOption("unit", OptionMapping::getAsString));
                OptionMapping startOption = event.getOption("start");
                boolean start = startOption != null && startOption.getAsBoolean();

                this.giveawayManager.createGiveaway(member, duration, unit, price, winners, start, event.getHook());
            }
            case "publish" -> {

                event.deferReply(true).queue();
                long giveawayId = event.getOption("id", OptionMapping::getAsLong);
                this.giveawayManager.publishGiveaway(giveawayId, event.getHook());

            }

            case "delete" -> {

                event.deferReply(true).queue();
                long giveawayId = event.getOption("id", OptionMapping::getAsLong);
                this.giveawayManager.deleteGiveaway(giveawayId, event.getHook());

            }
        }

    }
}
