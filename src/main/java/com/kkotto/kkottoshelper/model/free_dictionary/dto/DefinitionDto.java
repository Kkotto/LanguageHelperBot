package com.kkotto.kkottoshelper.model.free_dictionary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefinitionDto {
    private String definitionDto;
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
                this.definitionDto,
                this.example,
                String.join(", ", this.synonyms),
                String.join(", ", this.antonyms)
        );
    }
}
