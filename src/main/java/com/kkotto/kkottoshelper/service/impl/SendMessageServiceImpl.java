package com.kkotto.kkottoshelper.service.impl;

import com.kkotto.kkottoshelper.controller.KkottosHelper;
import com.kkotto.kkottoshelper.service.SendMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    private final KkottosHelper kkottosHelper;

    public SendMessageServiceImpl(KkottosHelper kkottosHelper) {
        this.kkottosHelper = kkottosHelper;
    }

    @Override
    public void sendMessage(String chadId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chadId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            kkottosHelper.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
