# Language Helper Bot

Language Helper Bot is a Telegram-bot. 

Do you use Telegram a lot? Do you eager to learn new English words? Do you always write down words into the (already huge) list "To review later"? This bot is for you.

## Motivation

- **Save for Later:** Help you save words for later reviewing.
- **Quick Vocabulary Check:** Provide definitions, pronunciation, synonyms, and other essential vocabulary features all in one place, right within Telegram.
- **Words Learning:** Assist you in learning new words through a flashcard-like approach.

## How to use

### Bot commands

1. ``/start`` - to start bot. Greeting message is sent.
2. ``/help`` - to get all commands list.
3. ``/find word`` - to find word in dictionary.

### ``/find`` response

The Telegram bot provides the user with the following information about the word:

- word spelling;
- word pronunciation;
- word phonetics (if available);
- word origin (if available);
- word meanings (one or many):
  - part of speech;
  - definition (one or many). Definition can include examples of usage, synonyms and antonyms if they're provided by dictionary.

Example data can be found [here](https://dictionaryapi.dev/).

## Development

> This bot is a pet project created for educational purposes and personal use.

### Stack

- Java 17, Spring Boot 5.
- Gradle 8.4.

### Api

- Telegram API: [learn more](https://core.telegram.org)
- Free Dictionari API: [learn more](https://dictionaryapi.dev)

### Libraries (maven/gradle)

- Telegram Bots: [find here](https://mvnrepository.com/artifact/org.telegram/telegrambots)
- Telegram Bots Spring Boot Starter: [find here](https://mvnrepository.com/artifact/org.telegram/telegrambots-spring-boot-starter)

### Development approach

- Command pattern: [learn more](https://refactoring.guru/design-patterns/command)
- MVC model: [learn more](https://www.baeldung.com/spring-mvc-tutorial)

### Future plans

- Add learning system & database.
- Add ``/translate`` command.

## Other

### Useful resources collection

#### Learning

- [Command Pattern](https://javarush.com/groups/posts/3219-java-proekt-ot-a-do-ja-realizuem-command-pattern-dlja-rabotih-s-botom-chastjh-1)
- [Factory Pattern](https://refactoring.guru/design-patterns/factory-method/java/example)

#### Developing

- [Telegram Bot API Documentation](https://core.telegram.org/bots/api)
- [Java Telegram Bot API by Pengrad](https://github.com/pengrad/java-telegram-bot-api)
- [TelegramBots Library by Rubenlagus - Getting Started](https://github.com/rubenlagus/TelegramBots/blob/master/TelegramBots.wiki/Getting-Started.md)
- [TelegramBotsExample by Rubenlagus](https://github.com/rubenlagus/TelegramBotsExample/tree/master/src/main/java/org/telegram)
