package assets;

import spi.services.exhandler.AbstractException;
import spi.services.exhandler.ExceptionLevel;
import spi.services.exhandler.Interface.HandleAble;

/**
 * Created by masiaban on 6/4/17.
 */
public class InitializationFailed extends AbstractException {
    public InitializationFailed(ExceptionLevel level, String errorMessage, String errorCode, String businessModule, Throwable cause, HandleAble handleAble, Boolean handleAsync) {
        super(level, errorMessage, errorCode, businessModule, cause, handleAble, handleAsync);
    }
}
