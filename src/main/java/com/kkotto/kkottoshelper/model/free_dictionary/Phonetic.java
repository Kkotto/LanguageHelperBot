package com.kkotto.kkottoshelper.model.free_dictionary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phonetic {
    private String text;
    private String audio;

    @Override
    public String toString() {
        return "<b>Phonetic:</b> " + this.text + "\n";
    }
}
