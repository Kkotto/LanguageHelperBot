package com.kkotto.kkottoshelper.command.impl;

import com.kkotto.kkottoshelper.command.BotCommand;
import com.kkotto.kkottoshelper.command.CommandList;
import com.kkotto.kkottoshelper.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final String HELP_COMMAND = String.format(
            """
                    My Commands

                    <b>Start work with me</b>
                    %s - to run and get greetings
                    %s - to get command list

                    <b>Working with English vocabulary</b>
                    %s or %s - to find word in dictionary
                    """,
            CommandList.START.getCommandName(),
            CommandList.HELP.getCommandName(),
            CommandList.FIND.getCommandName(),
            CommandList.SEARCH.getCommandName()
    );

    public HelpCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_COMMAND);
    }
}
