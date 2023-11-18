package com.kkotto.kkottoshelper.service.command.impl;

import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.command.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final String START_RESPONSE = "Hello! My name's Hypnos and I'm here to help you with your English!";

    public StartCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_RESPONSE);
    }
}
