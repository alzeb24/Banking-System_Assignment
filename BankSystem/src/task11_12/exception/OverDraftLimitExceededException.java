package task11_12.exception;

public class OverDraftLimitExceededException extends Exception {
    public OverDraftLimitExceededException(String message) {
        super(message);
    }
}

