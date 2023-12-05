package com.kkotto.kkottoshelper.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommand {
    void execute(Update update);
}
