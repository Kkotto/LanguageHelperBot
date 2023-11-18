package com.kkotto.kkottoshelper.service.command;

import lombok.Getter;

@Getter
public enum CommandList {
    START("/start"),
    HELP("/help"),
    SEARCH("/search"),
    UNKNOWN("/unknown");
    private final String commandName;

    CommandList(String commandName) {
        this.commandName = commandName;
    }
}
