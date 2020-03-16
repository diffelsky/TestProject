package shtait.core;

public class GeneratorException extends RuntimeException {

    public GeneratorException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
