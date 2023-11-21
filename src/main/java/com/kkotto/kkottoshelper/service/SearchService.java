package com.kkotto.kkottoshelper.service;

import com.kkotto.kkottoshelper.exception.RequestException;
import com.kkotto.kkottoshelper.model.Word;

import java.util.List;

public interface SearchService {
    List<Word> search(String request) throws RequestException;
}
