package com.kkotto.kkottoshelper.service.impl;

import com.kkotto.kkottoshelper.controller.FreeDictionaryController;
import com.kkotto.kkottoshelper.model.free_dictionary.dto.WordDto;
import com.kkotto.kkottoshelper.util.exception.RequestException;
import com.kkotto.kkottoshelper.service.FindInDictionaryService;

import java.util.List;

public class FindInDictionaryServiceImpl implements FindInDictionaryService {
    private final FreeDictionaryController freeDictionaryController;

    public FindInDictionaryServiceImpl() {
        this.freeDictionaryController = new FreeDictionaryController();
    }

    @Override
    public List<WordDto> search(String request) throws RequestException {
        return freeDictionaryController.searchInDictionary(request);
    }

    @Override
    public void saveResponse(List<WordDto> response) {
        for (WordDto word : response) {

        }
    }
}
