package com.kkotto.kkottoshelper.service;

import com.kkotto.kkottoshelper.controller.FreeDictionaryController;
import com.kkotto.kkottoshelper.util.exception.RequestException;
import com.kkotto.kkottoshelper.model.free_dictionary.Word;

import java.util.List;

public class FindInDictionaryService {
    private final FreeDictionaryController freeDictionaryController;

    public FindInDictionaryService() {
        this.freeDictionaryController = new FreeDictionaryController();
    }

    public List<Word> search(String request) throws RequestException {
        List<Word> wordList = freeDictionaryController.searchInDictionary(request);
        return wordList;
    }

    private void saveData(List<Word> wordList) {

    }
}
