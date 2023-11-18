package com.kkotto.kkottoshelper;

import com.kkotto.kkottoshelper.controller.KkottosHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class KkottosHelperApplication {
    public static void main(String[] args) {
        SpringApplication.run(KkottosHelperApplication.class, args);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new KkottosHelper());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
