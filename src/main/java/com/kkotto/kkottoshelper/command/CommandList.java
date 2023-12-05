package com.kkotto.kkottoshelper.command;

import lombok.Getter;

@Getter
public enum CommandList {
    START("/start"),
    HELP("/help"),
    FIND("/find"),
    UNKNOWN("/unknown");
    private final String commandName;

    CommandList(String commandName) {
        this.commandName = commandName;
    }
}
