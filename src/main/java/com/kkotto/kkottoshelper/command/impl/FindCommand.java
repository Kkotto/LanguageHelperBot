package com.kkotto.kkottoshelper.command.impl;

import com.kkotto.kkottoshelper.command.BotCommand;
import com.kkotto.kkottoshelper.command.CommandList;
import com.kkotto.kkottoshelper.util.exception.RequestException;
import com.kkotto.kkottoshelper.model.free_dictionary.Word;
import com.kkotto.kkottoshelper.service.FindInDictionaryService;
import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.impl.FindInDictionaryServiceImpl;
import com.kkotto.kkottoshelper.util.WordUtil;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class FindCommand implements BotCommand {
    private final SendMessageService sendMessageService;
    private final FindInDictionaryService findInDictionaryService;
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
        this.findInDictionaryService = new FindInDictionaryServiceImpl();
        this.wordUtil = new WordUtil();
    }

    @Override
    public void execute(Update update) {
        String userInputRequest = getFindRequest(update);
        String chatId = update.getMessage().getChatId().toString();
        try {
            if (!userInputRequest.isEmpty()) {
                List<Word> response = findInDictionaryService.search(userInputRequest);
                List<String> messages = wordUtil.parseFreeDictionaryResponse(response);
                for (String message : messages) {
                    sendMessageService.sendMessage(chatId, message);
                }
            } else {
                sendMessageService.sendMessage(chatId, EMPTY_REQUEST);
            }
        } catch (RequestException exception) {
            sendMessageService.sendMessage(chatId, exception.getMessage());
        }
    }

    private String getFindRequest(Update update) {
        return update.getMessage().getText().substring(CommandList.FIND.getCommandName().length()).trim();
    }
}
