package com.kkotto.kkottoshelper.util;

import com.kkotto.kkottoshelper.model.free_dictionary.dto.DefinitionDto;
import com.kkotto.kkottoshelper.model.free_dictionary.dto.MeaningDto;
import com.kkotto.kkottoshelper.model.free_dictionary.dto.PhoneticDto;
import com.kkotto.kkottoshelper.model.free_dictionary.dto.WordDto;

import java.util.ArrayList;
import java.util.List;

public class WordUtil {
    public List<String> parseFreeDictionaryResponse(List<WordDto> wordDtoList) {
        List<String> resultList = new ArrayList<>();
        for (WordDto wordDto : wordDtoList) {
            StringBuilder result = new StringBuilder();
            // Title
            result.append("<b>Title: </b>")
                    .append(wordDto.getWordDto())
                    .append("\n");
            // Phonetics
            if (!(wordDto.getPhoneticDto() == null) && !wordDto.getPhoneticDto().isEmpty()) {
                result.append("<b>Phonetics: </b>")
                        .append(wordDto.getPhoneticDto());
            }
            // Other phonetics
            if (!(wordDto.getPhoneticDtoList() == null) && !wordDto.getPhoneticDtoList().isEmpty()) {
                for (PhoneticDto phoneticDto : wordDto.getPhoneticDtoList()) {
                    if(!(phoneticDto.getText()==null) && !phoneticDto.getText().isEmpty()) {
                        result.append(", ")
                                .append(phoneticDto.getText());
                    }
                }
            }
            result.append("\n");
            // Meaning
            if (!(wordDto.getMeaningDtoList() == null) && !wordDto.getMeaningDtoList().isEmpty()) {
                result.append("<b>Meaning: </b>")
                        .append("\n");
                List<MeaningDto> meaningDtoList = wordDto.getMeaningDtoList();
                for (int i = 0; i < meaningDtoList.size(); i++) {
                    result.append(i + 1)
                            .append(". ");
                    MeaningDto meaningDto = meaningDtoList.get(i);
                    if (!(meaningDto.getPartOfSpeech() == null) && !meaningDto.getPartOfSpeech().isEmpty()) {
                        result.append("<i>")
                                .append(wordDto.getMeaningDtoList().get(i).getPartOfSpeech())
                                .append("</i>")
                                .append("\n");
                    }
                    if (!(meaningDto.getDefinitionDtoList() == null) && !meaningDto.getDefinitionDtoList().isEmpty()) {
                        for (DefinitionDto definitionDto : meaningDto.getDefinitionDtoList()) {
                            if (!(definitionDto.getDefinitionDto() == null) && !definitionDto.getDefinitionDto().isEmpty()) {
                                result.append(definitionDto.getDefinitionDto())
                                        .append("\n");
                            }
                            if (!(definitionDto.getExample() == null) && !definitionDto.getExample().isEmpty()) {
                                result.append("<b>Example: </b>")
                                        .append(definitionDto.getExample())
                                        .append("\n");
                            }
                            if (!(definitionDto.getSynonyms() == null) && !definitionDto.getSynonyms().isEmpty()) {
                                result.append("<i>Synonyms: </i>");
                                for (String synonym : definitionDto.getSynonyms()) {
                                    result.append(synonym).append(" ");
                                }
                                result.append("\n");
                            }
                            if (!(definitionDto.getAntonyms() == null) && !definitionDto.getAntonyms().isEmpty()) {
                                result.append("<i>Antonyms: </i>");
                                for (String antonym : definitionDto.getAntonyms()) {
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
