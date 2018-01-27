package assets;

import org.junit.Test;
import spi.services.exhandler.ExceptionLevel;

/**
 * Created by masiaban on 6/4/17.
 */
public class InitializationFailedTest {

    @Test
    public void testException() {
        try {
            throw new InitializationFailed(ExceptionLevel.SERIOUS,
                    "Message",
                    "codeEx",
                    "apiModule",
                    null, new ExceptionHandleAble(), true);
        } catch (InitializationFailed initializationFailed) {
            initializationFailed.printStackTrace();
        }
    }
}