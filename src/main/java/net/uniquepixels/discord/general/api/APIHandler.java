package net.uniquepixels.discord.general.api;


import net.dv8tion.jda.api.JDABuilder;
import net.uniquepixels.discord.general.api.buttons.Button;
import net.uniquepixels.discord.general.api.buttons.ButtonHandler;
import net.uniquepixels.discord.general.api.commands.CommandHandler;
import net.uniquepixels.discord.general.api.commands.messagecommands.MessageCommand;
import net.uniquepixels.discord.general.api.commands.slashcommands.SlashCommand;
import net.uniquepixels.discord.general.api.commands.usercommands.UserCommand;
import net.uniquepixels.discord.general.api.menu.SelectionMenuHandler;
import net.uniquepixels.discord.general.api.menu.entity.EntitySelectionMenu;
import net.uniquepixels.discord.general.api.menu.string.StringSelectionMenu;
import net.uniquepixels.discord.general.api.modal.Modal;
import net.uniquepixels.discord.general.api.modal.ModalHandler;

public class APIHandler {
    private final ButtonHandler buttonHandler;
    private final CommandHandler commandHandler;
    private final SelectionMenuHandler selectionMenuHandler;
    private final ModalHandler modalHandler;

    public APIHandler(JDABuilder builder) {
        this.buttonHandler = new ButtonHandler();
        this.commandHandler = new CommandHandler();
        this.selectionMenuHandler = new SelectionMenuHandler();
        this.modalHandler = new ModalHandler();

        builder.addEventListeners(this.buttonHandler);
        builder.addEventListeners(this.commandHandler);
        builder.addEventListeners(this.selectionMenuHandler);
        builder.addEventListeners(this.modalHandler);
    }

    public ButtonHandler getButtonHandler() {
        return this.buttonHandler;
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public SelectionMenuHandler getSelectionMenuHandler() {
        return this.selectionMenuHandler;
    }

    public ModalHandler getModalHandler() {
        return this.modalHandler;
    }

    public void addSlashCommand(SlashCommand slashCommand) {
        this.commandHandler.addSlashCommand(slashCommand);
    }

    public void addMessageCommand(MessageCommand messageCommand) {
        this.commandHandler.getMessageCommands().add(messageCommand);
    }

    public void addUSerCommand(UserCommand userCommand) {
        this.commandHandler.getUserCommands().add(userCommand);
    }

    public void addEntityMenu(EntitySelectionMenu selectionMenu) {
        this.selectionMenuHandler.getEntitySelectionMenus().add(selectionMenu);
    }

    public void addStringMenu(StringSelectionMenu selectionMenu) {
        this.selectionMenuHandler.getStringSelectionMenus().add(selectionMenu);
    }

    public void addButton(Button button) {
        this.buttonHandler.getButtons().add(button);
    }

    public void addModal(Modal modal) {
        this.modalHandler.getModals().add(modal);
    }

}
