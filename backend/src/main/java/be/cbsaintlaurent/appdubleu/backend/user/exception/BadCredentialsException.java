package be.cbsaintlaurent.appdubleu.backend.user.exception;

public class BadCredentialsException extends RuntimeException {
    public BadCredentialsException(String message) {
        super(message);
    }
}
