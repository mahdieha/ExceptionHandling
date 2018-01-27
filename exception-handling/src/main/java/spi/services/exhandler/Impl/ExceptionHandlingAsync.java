package spi.services.exhandler.Impl;

import spi.services.exhandler.Interface.HandleAble;

/**
 * Created by masiaban on 6/4/17.
 */
public class ExceptionHandlingAsync implements Runnable {

    private HandleAble handleAble;

    public ExceptionHandlingAsync(HandleAble handleAble) {
        this.handleAble = handleAble;
    }

    public void run() {
        handleAble.doHandle();
    }
}
