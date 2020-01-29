package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleCallableWithExecutorService;

import java.util.concurrent.ExecutionException;

public class InvalidParameterException extends ExecutionException {

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
