package com.kkotto.kkottoshelper.model.free_dictionary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MeaningDto {
    private String partOfSpeech;
    private List<DefinitionDto> definitionDtoList;

    @Override
    public String toString() {
        return String.format("""
                        <b>Part of speech:</b> %s,
                                                
                        <b>Definitions:</b> %s.
                                        
                                        
                        """,
                this.partOfSpeech,
                this.definitionDtoList);
    }
}
