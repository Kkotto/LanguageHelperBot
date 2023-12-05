package com.kkotto.kkottoshelper.model.free_dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Definition {
    private String definition;
    private String example;
    private List<String> synonyms;
    private List<String> antonyms;

    @Override
    public String toString() {
        return String.format(
                """
                        <b>Definition:</b> %s,
                                                
                        <b>Example:</b> "%s",
                                                
                        <b>Synonyms:</b> %s,
                                                
                        <b>Antonyms:</b> %s.
                        """,
                this.definition,
                this.example,
                String.join(", ", this.synonyms),
                String.join(", ", this.antonyms)
        );
    }
}
