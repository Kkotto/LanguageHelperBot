package com.kkotto.kkottoshelper.service.command.impl;

import com.kkotto.kkottoshelper.model.Word;
import com.kkotto.kkottoshelper.service.SearchService;
import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.command.BotCommand;
import com.kkotto.kkottoshelper.service.command.CommandList;
import com.kkotto.kkottoshelper.service.impl.SearchServiceImpl;
import com.kkotto.kkottoshelper.service.util.MessageUtil;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class SearchCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final SearchService searchService;
    private final MessageUtil messageUtil;
    private final String FIND_RESPONSE =
            String.format("You've chosen %s command, have you not? I regret to say, but it's not implemented yet~",
                    CommandList.SEARCH.getCommandName());

    public SearchCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
        this.searchService = new SearchServiceImpl();
        this.messageUtil = new MessageUtil();
    }

    @Override
    public void execute(Update update) {
        String userWordRequest = parseRequest(update);
        List<Word> response = searchService.search(userWordRequest);
        List<String> messages = messageUtil.generateAnswer(response);
        for (String message : messages) {
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), message);
        }
    }

    private String parseRequest(Update update) {
        return update.getMessage().getText().substring(CommandList.SEARCH.getCommandName().length()).trim();
    }
}
