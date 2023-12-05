package com.kkotto.kkottoshelper.model.free_dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Meaning {
    private String partOfSpeech;
    private List<Definition> definitions;

    @Override
    public String toString() {
        return String.format("""
                        <b>Part of speech:</b> %s,
                                                
                        <b>Definitions:</b> %s.
                                        
                                        
                        """,
                this.partOfSpeech,
                this.definitions);
    }
}
