package com.kkotto.kkottoshelper.service.impl;

import com.kkotto.kkottoshelper.controller.FreeDictionaryController;
import com.kkotto.kkottoshelper.exception.RequestException;
import com.kkotto.kkottoshelper.model.Word;
import com.kkotto.kkottoshelper.service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    private final FreeDictionaryController freeDictionaryController;

    public SearchServiceImpl() {
        this.freeDictionaryController = new FreeDictionaryController();
    }

    @Override
    public List<Word> search(String request) throws RequestException {
        return freeDictionaryController.searchInDictionary(request);
    }
}
