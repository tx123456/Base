package com.tanxin.base.common.base;

/**
 * @author TANXIN
 * @date 2018/6/20/020
 */
public class BaseEvent<T> {
    private int eventCode = -1;

    private T data;


    public BaseEvent(int eventCode) {
        this.eventCode = eventCode;
    }

    public BaseEvent(int eventCode, T data) {
        this.eventCode = eventCode;
        this.data = data;
    }

    public int getEventCode() {
        return eventCode;
    }

    public T getData() {
        return data;
    }
}
