package be.cbsaintlaurent.appdubleu.backend.user.exception;

public class UserDisabledException extends RuntimeException {
    public UserDisabledException(String message) {
        super(message);
    }
}
