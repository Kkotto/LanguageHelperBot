package com.kkotto.kkottoshelper.command.impl;

import com.kkotto.kkottoshelper.command.BotCommand;
import com.kkotto.kkottoshelper.command.CommandList;
import com.kkotto.kkottoshelper.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final String NO_COMMAND_RESPONSE =
            String.format("Oh dear! I'm afraid I can't help this time, huh? Although, let's see what I can do for you with %s, alright?", CommandList.HELP.getCommandName());

    public UnknownCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_COMMAND_RESPONSE);
    }
}
