package com.kkotto.kkottoshelper.util;

public class MessageUtil {
    private final String COMMAND_PREFIX = "/";

    public boolean isMessage(String message) {
        return message.startsWith(COMMAND_PREFIX);
    }

    public String getIdentifier(String message) {
        return message.split(" ")[0].toLowerCase();
    }
}
