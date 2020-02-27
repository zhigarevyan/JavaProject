package exceptions;

import java.io.IOException;

public class IncorrectDataException extends IOException {
    public IncorrectDataException(String message) {
        super(message);
    }
}
