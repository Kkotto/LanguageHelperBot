package com.kkotto.kkottoshelper.command.impl;

import com.kkotto.kkottoshelper.command.BotCommand;
import com.kkotto.kkottoshelper.command.CommandList;
import com.kkotto.kkottoshelper.util.exception.RequestException;
import com.kkotto.kkottoshelper.model.free_dictionary.Word;
import com.kkotto.kkottoshelper.service.SearchService;
import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.impl.SearchServiceImpl;
import com.kkotto.kkottoshelper.util.WordUtil;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class FindCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final SearchService searchService;
    private final WordUtil wordUtil;
    private final String EMPTY_REQUEST = String.format(
            """
                    Oh dear! I see your enthusiasm, but <b><i>to find a word</i></b> you need to <b><i>specify the word</i></b>, huh?
                                        
                    For example: <code>%s hello</code>!
                                        
                    Let's give it a shot, shall we?
                    """,
            CommandList.FIND.getCommandName()
    );

    public FindCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
        this.searchService = new SearchServiceImpl();
        this.wordUtil = new WordUtil();
    }

    @Override
    public void execute(Update update) {
        String userWordRequest = parseRequest(update);
        try {
            if (!userWordRequest.isEmpty()) {
                List<Word> response = searchService.search(userWordRequest);
                List<String> messages = wordUtil.parseWords(response);
                for (String message : messages) {
                    sendMessageService.sendMessage(update.getMessage().getChatId().toString(), message);
                }
            } else {
                sendMessageService.sendMessage(update.getMessage().getChatId().toString(), EMPTY_REQUEST);
            }
        } catch (RequestException exception) {
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), exception.getMessage());
        }
    }

    private String parseRequest(Update update) {
        return update.getMessage().getText().substring(CommandList.FIND.getCommandName().length()).trim();
    }
}
