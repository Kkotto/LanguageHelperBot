package com.kkotto.kkottoshelper.service;

import com.kkotto.kkottoshelper.util.exception.RequestException;
import com.kkotto.kkottoshelper.model.free_dictionary.Word;

import java.util.List;

public interface SearchService {
    List<Word> search(String request) throws RequestException;
}
