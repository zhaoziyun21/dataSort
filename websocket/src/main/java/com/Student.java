package com;

/**
 * Created by zhaoziyun on 2019/8/1.
 */
public class Student implements Person {
    private  String name;
    public Student(String name){
        this.name = name;
    }
    public Student(){
    }
    @Override
    public void giveMoney() {
        System.out.print("mlgb又该交钱了");
    }
    @Override
    public void giveMoney1() {
        System.out.print("1111mlgb又该交钱了");
    }
}
