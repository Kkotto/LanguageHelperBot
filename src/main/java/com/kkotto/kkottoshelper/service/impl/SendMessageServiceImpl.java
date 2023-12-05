package com.kkotto.kkottoshelper.service.impl;

import com.kkotto.kkottoshelper.controller.KkottosHelper;
import com.kkotto.kkottoshelper.service.SendMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    private final KkottosHelper kkottosHelper;

    public SendMessageServiceImpl(KkottosHelper kkottosHelper) {
        this.kkottosHelper = kkottosHelper;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = buildSendMessage(chatId, message);
        this.execute(sendMessage);
    }

    @Override
    public void sendMessage(String chatId, String message, InlineKeyboardMarkup keyboardMarkup) {
        SendMessage sendMessage = buildSendMessage(chatId, message);
        sendMessage.setReplyMarkup(keyboardMarkup);
        this.execute(sendMessage);
    }

    private SendMessage buildSendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        return sendMessage;
    }

    private void execute(SendMessage sendMessage) {
        try {
            kkottosHelper.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
