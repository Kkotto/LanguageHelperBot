package com.kkotto.kkottoshelper.controller;

import com.kkotto.kkottoshelper.util.exception.RequestException;
import com.kkotto.kkottoshelper.model.free_dictionary.dto.WordDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class FreeDictionaryController {
    private static final String FREE_DICTIONARY_URI = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    @GetMapping
    public List<WordDto> searchInDictionary(String request) throws RequestException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            WordDto[] wordDto = restTemplate.getForObject(FREE_DICTIONARY_URI + request, WordDto[].class);
            return Arrays.asList(wordDto);
        } catch (HttpClientErrorException.NotFound exception) {
            throw new RequestException(RequestException.NOT_FOUND_EXCEPTION);
        }
    }
}
