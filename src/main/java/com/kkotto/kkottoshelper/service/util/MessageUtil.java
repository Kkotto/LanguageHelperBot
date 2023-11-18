package com.kkotto.kkottoshelper.service.util;

import com.kkotto.kkottoshelper.model.Word;

import java.util.List;

public class MessageUtil {
    public final String COMMAND_PREFIX = "/";

    public boolean isMessage(String message) {
        return message.startsWith(COMMAND_PREFIX);
    }

    public String getIdentifier(String message) {
        return message.split(" ")[0].toLowerCase();
    }

    public List<String> generateAnswer(List<Word> words) {
        return words.stream().map(Word::toString).toList();
    }
}
