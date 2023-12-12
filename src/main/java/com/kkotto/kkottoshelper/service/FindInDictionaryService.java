package com.kkotto.kkottoshelper.service;

import com.kkotto.kkottoshelper.model.free_dictionary.dto.WordDto;
import com.kkotto.kkottoshelper.util.exception.RequestException;

import java.util.List;

public interface FindInDictionaryService {
    List<WordDto> search(String request) throws RequestException;

    void saveResponse(List<WordDto> response);
}
