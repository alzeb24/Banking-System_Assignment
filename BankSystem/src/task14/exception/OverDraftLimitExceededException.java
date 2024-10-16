package task14.exception;

public class OverDraftLimitExceededException extends Exception {
    public OverDraftLimitExceededException(String message) {
        super(message);
    }
}

