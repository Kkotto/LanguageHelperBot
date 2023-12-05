package com.kkotto.kkottoshelper.model.free_dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Word {
    private String word;
    private String phonetic;
    private List<Phonetic> phonetics;
    private String origin;
    private List<Meaning> meanings;

    @Override
    public String toString() {
        return String.format("""
                                        <b>Word:</b> %s,
                                        
                                        <b>Phonetic:</b> %s,
                                        
                                        %s,
                                        
                                        <b>Origin:</b> %s,
                                        
                                        <b>Meaning:</b> %s
                        """,
                this.word,
                this.phonetic,
                this.phonetics,
                this.origin,
                this.meanings);
    }
}
