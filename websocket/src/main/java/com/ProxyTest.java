package com;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhaoziyun on 2019/8/1.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
        InvocationHandler stuHandler  =  new MyInvocationHandler<Person>(zhangsan);
        Person stuProxy = (Person)Proxy.newProxyInstance(Student.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);
        System.out.println(stuProxy.getClass());
        stuProxy.giveMoney();
        stuProxy.giveMoney1();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("start");
                methodProxy.invokeSuper(o,args);
                System.out.println("end");
                return null;
            }
        });
        Student o = (Student) enhancer.create();
        System.out.println(o.getClass());
        o.giveMoney();
    }
}
