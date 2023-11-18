package com.kkotto.kkottoshelper.service.util;

public class MessageUtil {
    public final String COMMAND_PREFIX = "/";

    public boolean isMessage(String message) {
        return message.startsWith(COMMAND_PREFIX);
    }

    public String getIdentifier(String message) {
        return message.split(" ")[0].toLowerCase();
    }
}
