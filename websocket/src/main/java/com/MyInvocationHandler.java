package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhaoziyun on 2019/8/1.
 */
public class MyInvocationHandler<T> implements InvocationHandler{
    T target;
    public MyInvocationHandler(T stu){
        this.target = stu;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
