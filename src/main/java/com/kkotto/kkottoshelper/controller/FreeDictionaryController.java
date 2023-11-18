package com.kkotto.kkottoshelper.controller;

import com.kkotto.kkottoshelper.model.Word;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class FreeDictionaryController {
    private static final String FREE_DICTIONARY_URI = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    @GetMapping
    public List<Word> searchInDictionary(String request) {
        RestTemplate restTemplate = new RestTemplate();
        Word[] words = restTemplate.getForObject(FREE_DICTIONARY_URI + request, Word[].class);
        return Arrays.asList(words);
    }
}
