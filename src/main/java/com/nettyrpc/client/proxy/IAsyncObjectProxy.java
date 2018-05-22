package com.nettyrpc.client.proxy;

import com.nettyrpc.client.RPCFuture;

/**
 * Created by lsl on 2016/6/16.
 */
public interface IAsyncObjectProxy {
    public RPCFuture call(String funcName, Object... args);
}