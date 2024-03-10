package net.uniquepixels.discord.general.giveaway;

import com.google.gson.Gson;
import net.dv8tion.jda.api.entities.Member;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GiveawayBackend {

    private static final String API_URL = System.getenv("API_URL");
    private static final String BEARER = "Bearer " + System.getenv("BEARER");
    private final OkHttpClient client;

    public GiveawayBackend() {
        this.client = new OkHttpClient();
    }

    public Optional<Giveaway> createGiveaway(Member creator, long duration, TimeUnit unit, String price, int maxWinners) throws IOException {

        Giveaway.CreateBody createBody = new Giveaway.CreateBody(creator.getIdLong(), price, maxWinners, false, unit.toMillis(duration), List.of());

        Request request = new Request.Builder()
                .post(createBody.getRequestBody())
                .url(API_URL + "/giveaway/create")
                .addHeader("Authorization", BEARER).build();

        Response execute = this.client.newCall(request).execute();

        if (execute.code() != 201 || execute.body() == null) {
            return Optional.empty();
        }

        return Optional.of(Giveaway.fromBody(creator.getGuild(), Giveaway.Body.fromString(execute.body().string())));
    }

    public Optional<Giveaway> publishGiveaway(long giveawayId) throws IOException {

        Request request = new Request.Builder()
                .put(RequestBody.create(String.valueOf(giveawayId), MediaType.get("application/json")))
                .url(API_URL + "/giveaway/publish")
                .addHeader("Authorization", BEARER).build();

        Response execute = this.client.newCall(request).execute();

        if (execute.code() != 202 || execute.body() == null) {
            return Optional.empty();
        }

        Giveaway giveaway = new Gson().fromJson(execute.body().string(), Giveaway.class);
        return Optional.of(giveaway);
    }

    public boolean deleteGiveaway(long giveawayId) throws IOException {

        Request request = new Request.Builder()
                .delete()
                .url(API_URL + "/giveaway/delete/" + giveawayId)
                .addHeader("Authorization", BEARER).build();

        Response execute = this.client.newCall(request).execute();

        if (execute.code() != 202) {
            return false;
        }

        return Boolean.parseBoolean(execute.body().toString());
    }

    public boolean enterGiveaway(long memberId, long giveawayId) throws IOException {

        Request request = new Request.Builder()
                .put(RequestBody.create(String.valueOf(giveawayId), MediaType.get("application/json")))
                .url(API_URL + "/giveaway/" + giveawayId + "/add/"+memberId)
                .addHeader("Authorization", BEARER).build();

        Response execute = this.client.newCall(request).execute();

        return execute.code() != 200;
    }
}
