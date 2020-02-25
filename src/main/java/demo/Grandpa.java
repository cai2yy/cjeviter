package demo;

import eventemit.AbstractEventEmitter;

/**
 * @author Cai2yy
 * @date 2020/2/15 13:24
 */

public class Grandpa extends AbstractEventEmitter {

    public void onCall(String callerName) {
        System.out.println("grandpa get a call from " + callerName);
    }

}
