package com.kkotto.kkottoshelper.model.free_dictionary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WordDto {
    private String wordDto;
    private String phoneticDto;
    private List<PhoneticDto> phoneticDtoList;
    private String origin;
    private List<MeaningDto> meaningDtoList;

    @Override
    public String toString() {
        return String.format("""
                                        <b>Word:</b> %s,
                                        
                                        <b>Phonetic:</b> %s,
                                        
                                        %s,
                                        
                                        <b>Origin:</b> %s,
                                        
                                        <b>Meaning:</b> %s
                        """,
                this.wordDto,
                this.phoneticDto,
                this.phoneticDtoList,
                this.origin,
                this.meaningDtoList);
    }
}
