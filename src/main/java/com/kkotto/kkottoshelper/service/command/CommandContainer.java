package com.kkotto.kkottoshelper.service.command;

import com.kkotto.kkottoshelper.service.SendMessageService;
import com.kkotto.kkottoshelper.service.command.impl.FindCommand;
import com.kkotto.kkottoshelper.service.command.impl.HelpCommand;
import com.kkotto.kkottoshelper.service.command.impl.UnknownCommand;
import com.kkotto.kkottoshelper.service.command.impl.StartCommand;

import java.util.Map;

import static java.util.Map.entry;

public class CommandContainer {
    private final Map<String, BotCommand> commandMap;
    private final UnknownCommand unknownCommand;

    public CommandContainer(SendMessageService sendMessageService) {
        this.commandMap = Map.ofEntries(
                entry(CommandList.START.getCommandName(), new StartCommand(sendMessageService)),
                entry(CommandList.HELP.getCommandName(), new HelpCommand(sendMessageService)),
                entry(CommandList.FIND.getCommandName(), new FindCommand(sendMessageService))
                );
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public BotCommand getCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
