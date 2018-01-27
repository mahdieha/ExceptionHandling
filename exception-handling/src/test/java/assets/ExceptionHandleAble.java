package assets;

import spi.services.exhandler.Interface.HandleAble;

/**
 * Created by m.asiaban on 6/4/17.
 */
public class ExceptionHandleAble implements HandleAble {

    @Override
    public boolean doHandle() {
        System.out.println("Handled");
        return false;
    }
}
