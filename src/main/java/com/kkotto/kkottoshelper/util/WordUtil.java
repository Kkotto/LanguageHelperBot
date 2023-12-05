package com.kkotto.kkottoshelper.util;

import com.kkotto.kkottoshelper.model.free_dictionary.Definition;
import com.kkotto.kkottoshelper.model.free_dictionary.Meaning;
import com.kkotto.kkottoshelper.model.free_dictionary.Phonetic;
import com.kkotto.kkottoshelper.model.free_dictionary.Word;

import java.util.ArrayList;
import java.util.List;

public class WordUtil {
    public List<String> parseWords(List<Word> wordList) {
        List<String> resultList = new ArrayList<>();
        for (Word word : wordList) {
            StringBuilder result = new StringBuilder();
            // Title
            result.append("<b>Title: </b>")
                    .append(word.getWord())
                    .append("\n");
            // Phonetics
            if (!(word.getPhonetic() == null) && !word.getPhonetic().isEmpty()) {
                result.append("<b>Phonetics: </b>")
                        .append(word.getPhonetic());
            }
            // Other phonetics
            if (!(word.getPhonetics() == null) && !word.getPhonetics().isEmpty()) {
                for (Phonetic phonetic : word.getPhonetics()) {
                    if(!(phonetic.getText()==null) && !phonetic.getText().isEmpty()) {
                        result.append(", ")
                                .append(phonetic.getText());
                    }
                }
            }
            result.append("\n");
            // Meaning
            if (!(word.getMeanings() == null) && !word.getMeanings().isEmpty()) {
                result.append("<b>Meaning: </b>")
                        .append("\n");
                List<Meaning> meaningList = word.getMeanings();
                for (int i = 0; i < meaningList.size(); i++) {
                    result.append(i + 1)
                            .append(". ");
                    Meaning meaning = meaningList.get(i);
                    if (!(meaning.getPartOfSpeech() == null) && !meaning.getPartOfSpeech().isEmpty()) {
                        result.append("<i>")
                                .append(word.getMeanings().get(i).getPartOfSpeech())
                                .append("</i>")
                                .append("\n");
                    }
                    if (!(meaning.getDefinitions() == null) && !meaning.getDefinitions().isEmpty()) {
                        for (Definition definition : meaning.getDefinitions()) {
                            if (!(definition.getDefinition() == null) && !definition.getDefinition().isEmpty()) {
                                result.append(definition.getDefinition())
                                        .append("\n");
                            }
                            if (!(definition.getExample() == null) && !definition.getExample().isEmpty()) {
                                result.append("<b>Example: </b>")
                                        .append(definition.getExample())
                                        .append("\n");
                            }
                            if (!(definition.getSynonyms() == null) && !definition.getSynonyms().isEmpty()) {
                                result.append("<i>Synonyms: </i>");
                                for (String synonym : definition.getSynonyms()) {
                                    result.append(synonym).append(" ");
                                }
                                result.append("\n");
                            }
                            if (!(definition.getAntonyms() == null) && !definition.getAntonyms().isEmpty()) {
                                result.append("<i>Antonyms: </i>");
                                for (String antonym : definition.getAntonyms()) {
                                    result.append(antonym).append(" ");
                                }
                                result.append("\n");
                            }
                        }
                    }
                    result.append("\n");
                }
            }
            resultList.add(result.toString());
        }
        return resultList;
    }
}
