package com.nettyrpc.client;

/**
 * Created by lsl on 2016-06-17.
 */
public interface AsyncRPCCallback {

    void success(Object result);

    void fail(Exception e);

}
