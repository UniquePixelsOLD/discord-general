package net.uniquepixels.bot.discord.menu.entity;

import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;
import net.uniquepixels.bot.discord.Builder;
import net.uniquepixels.bot.discord.menu.MenuDefault;

import java.util.Arrays;

public class EntitySelectMenuBuilder implements MenuDefault<EntitySelectMenuBuilder>, Builder<EntitySelectMenu> {

    private final EntitySelectMenu.Builder builder;

    public EntitySelectMenuBuilder(String id, EntitySelectMenu.SelectTarget... selectTarget) {
        this.builder = EntitySelectMenu.create(id, Arrays.stream(selectTarget).toList());
    }

    @Override
    public EntitySelectMenu buildData() {
        return builder.build();
    }

    @Override
    public EntitySelectMenuBuilder setMinValues(int amount) {
        this.builder.setMinValues(amount);
        return this;
    }

    @Override
    public EntitySelectMenuBuilder setMaxValues(int amount) {
        this.builder.setMaxValues(amount);
        return this;
    }

    @Override
    public EntitySelectMenuBuilder setPlaceholder(String placeholder) {
        this.builder.setPlaceholder(placeholder);
        return this;
    }
}
