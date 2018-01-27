package spi.services.exhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spi.services.exhandler.Impl.ExceptionHandlingAsync;
import spi.services.exhandler.Interface.HandleAble;

/**
 * Created by m.asiaban on 6/4/17.
 */
public abstract class AbstractException extends Exception {

    private static final long serialVersionUID = 19930304L;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private ExceptionLevel level = ExceptionLevel.SLIGHT;

    private String errorMessage = "";

    private String businessModule = "unknown";

    private String errorCode = "";

    private boolean handled = false;

    private boolean handleAsync = false;

    public AbstractException(ExceptionLevel level,
                             String errorMessage,
                             String errorCode,
                             String businessModule,
                             Throwable cause,
                             HandleAble handleAble,
                             Boolean handleAsync) {
        super(cause);
        this.level = level;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.businessModule = businessModule;
        this.handleAsync = handleAsync;
        handleException(cause, handleAble);
    }

    private void handleException(Throwable cause, HandleAble handleAble) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(" + this.errorCode + "):").append(this.errorMessage).append(":" + this.businessModule);
        switch (this.level) {
            case SERIOUS:
                LOG.error(stringBuilder.toString(), cause);
                break;
            case COMMON:
                LOG.warn(stringBuilder.toString(), cause);
                break;
            case SLIGHT:
                LOG.info(stringBuilder.toString(), cause);
                break;
        }

        if (null != handleAble) {
            if (isHandleAsync()) {
                Thread thread = new Thread(new ExceptionHandlingAsync(handleAble));
                new Thread(thread).start();
            } else {
                this.setHandled(handleAble.doHandle());
            }
        }
    }

    public ExceptionLevel getLevel() {
        return level;
    }

    public void setLevel(ExceptionLevel level) {
        this.level = level;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getBusinessModule() {
        return businessModule;
    }

    public void setBusinessModule(String businessModule) {
        this.businessModule = businessModule;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

    public boolean isHandleAsync() {
        return handleAsync;
    }

    public void setHandleAsync(boolean handleAsync) {
        this.handleAsync = handleAsync;
    }
}
