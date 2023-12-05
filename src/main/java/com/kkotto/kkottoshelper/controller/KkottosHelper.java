package com.kkotto.kkottoshelper.controller;

import com.kkotto.kkottoshelper.util.constants.InitConstants;
import com.kkotto.kkottoshelper.command.CommandContainer;
import com.kkotto.kkottoshelper.command.CommandList;
import com.kkotto.kkottoshelper.service.impl.SendMessageServiceImpl;
import com.kkotto.kkottoshelper.util.MessageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class KkottosHelper extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String botToken;
    @Value("${bot.username}")
    private String botUsername;

    private final CommandContainer commandContainer;
    private final MessageUtil messageUtil;

    public KkottosHelper() {
        this.botToken = InitConstants.BOT_TOKEN;
        this.botUsername = InitConstants.BOT_USERNAME;
        this.commandContainer = new CommandContainer(new SendMessageServiceImpl(this));
        this.messageUtil = new MessageUtil();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (messageUtil.isMessage(message)) {
                commandContainer.getCommand(messageUtil.getIdentifier(message)).execute(update);
            } else {
                commandContainer.getCommand(CommandList.UNKNOWN.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }
}
