package net.uniquepixels.discord.general.giveaway;

import com.google.gson.Gson;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.Member;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

public record Giveaway(long giveawayId, Member starter, String price, int maxWinners, long started, long duration,
                       boolean active, List<Member> enteredMembers) {

    public static Giveaway fromBody(Guild guild, Body body) {

        Member starter = guild.getMemberById(body.starterId);
        List<Member> enteredMembers = body.enteredMembers.stream().map(guild::getMemberById).collect(Collectors.toList());


        return new Giveaway(body.giveawayId,
                starter,
                body.price(),
                body.maxWinners,
                body.started,
                body.duration,
                body.active,
                enteredMembers);
    }

    public Body asBody() {
        return new Body(giveawayId, starter.getIdLong(), price, maxWinners, started, duration, active,
                enteredMembers.stream().map(ISnowflake::getIdLong).collect(Collectors.toList()));
    }

    public record Body(long giveawayId, long starterId, String price, int maxWinners, long started, long duration,
                       boolean active, List<Long> enteredMembers) {

        public static Body fromString(String json) {
            return new Gson().fromJson(json, Body.class);
        }

    }

    public record CreateBody(long starterId, String price, int maxWinners, boolean active, long duration,
                             List<String> enteredMembers) {

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }

        public RequestBody getRequestBody() {
            return RequestBody.create(
                    toString(),
                    MediaType.get("application/json")
            );
        }
    }
}
