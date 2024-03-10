package net.uniquepixels.discord.general.api;

import com.google.gson.Gson;

public interface ToGson {

    default String toGson() {
        return new Gson().toJson(this);
    }

}
