package com.kkotto.kkottoshelper.service.command.impl;

import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.command.BotCommand;
import com.kkotto.kkottoshelper.service.command.CommandList;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FindCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final String FIND_RESPONSE =
            String.format("You've chosen %s command, have you not? I regret to say, but it's not implemented yet~",
                    CommandList.FIND.getCommandName());

    public FindCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), FIND_RESPONSE);
    }
}
