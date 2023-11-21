package com.kkotto.kkottoshelper.exception;

public class RequestException extends Exception {
    public static final String NOT_FOUND_EXCEPTION = "Sorry, no data is found, huh? Please, check spelling and try again.";

    public RequestException(String message) {
        super(message);
    }
}
