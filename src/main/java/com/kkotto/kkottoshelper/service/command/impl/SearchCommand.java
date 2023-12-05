package com.kkotto.kkottoshelper.service.command.impl;

import com.kkotto.kkottoshelper.exception.RequestException;
import com.kkotto.kkottoshelper.model.free_dictionary.Word;
import com.kkotto.kkottoshelper.service.SearchService;
import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.command.BotCommand;
import com.kkotto.kkottoshelper.service.command.CommandList;
import com.kkotto.kkottoshelper.service.impl.SearchServiceImpl;
import com.kkotto.kkottoshelper.service.util.WordUtil;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class SearchCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final SearchService searchService;
    private final WordUtil wordUtil;
    private final String EMPTY_REQUEST = String.format(
            """
                    Oh dear! I see your enthusiasm, but <b><i>to find a word</i></b> you need to <b><i>specify the word</i></b>, huh?
                                        
                    For example: <code>%s hello</code> or <code>%s hello</code>!
                                        
                    Let's give it a shot, shall we?
                    """,
            CommandList.SEARCH.getCommandName(),
            CommandList.FIND.getCommandName()
    );

    public SearchCommand(SendMessageService sendMessageService) {
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
        String text = update.getMessage().getText();
        return text.startsWith(CommandList.FIND.getCommandName()) ?
                text.substring(CommandList.FIND.getCommandName().length()).trim() :
                text.substring(CommandList.SEARCH.getCommandName().length()).trim();
    }
}
