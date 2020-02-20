package demo;

import eventemit.AbstractEventEmitter;

/**
 * @author Cai2yy
 * @date 2020/2/20 11:40
 */
public class Parent extends AbstractEventEmitter {
    Son son;

    public Parent() {

    }

    public void callGrandpa(String callerName) throws Exception {
        emit("call", callerName);
    }

    public void sayHi() {
        System.out.println("hi " + son.name);
    }

    public void sayHi(int time) {
        System.out.println("hi " + son.name + ", it is " + time);
    }

    public void sayHi(char c) {
        System.out.println("hi " + son.name + ", it is " + c);
    }

    public void sayHi(long l) {
        System.out.println("hi " + son.name + ", it is " + l);
    }

    public void sayHi(String words) {
        System.out.println("hi " + son.name + ", and " + words);
    }

    public void sayHi(Integer time, String words) {
        System.out.println("hi " + son.name + ", it is " + time + ", and " + words);
    }

    public void sayHiOnce() {
        System.out.println("I only say once, hi " + son.name);
    }

}
