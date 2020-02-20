package demo;

import eventemit.AbstractEventEmitter;

/**
 * @author Cai2yy
 * @date 2020/2/20 11:41
 */
class Son extends AbstractEventEmitter {
    String name;

    Son(String name) {
        this.name = name;
    }

    public void onAddListener() {
        System.out.println("my onAddListener()");
    }

}
