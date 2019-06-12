package deshraj.chatapplication.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);

    public String messageCode;

    public ApplicationException(String messageCode){
        this.messageCode = messageCode;
    }
}
