package com.kkotto.kkottoshelper.model.free_dictionary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneticDto {
    private String text;
    private String audio;

    @Override
    public String toString() {
        return "<b>Phonetic:</b> " + this.text + "\n";
    }
}
