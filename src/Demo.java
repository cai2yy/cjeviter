import java.lang.reflect.Method;

/**
 * @author Cai2yy
 * @date 2020/2/15 13:24
 */

class Grandpa extends AbstractEventEmitter {
    public void onCall(String callerName) {
        System.out.println("grandpa get a call from " + callerName);
    }
}

class Parent extends AbstractEventEmitter {
    Son son;

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

class Son extends AbstractEventEmitter {
    String name;

    Son(String name) {
        this.name = name;
    }

    public void onAddListener() {
        System.out.println("my onAddListener()");
    }

}

class demo {
    public static void main(String[] args) throws Exception {
        int x = 5;
        Parent p = new Parent();
        p.son = new Son("Bob");
        Son s2 = new Son("Lisa");

        System.out.println("--------test method constructor`s polymorphism--------");
        p.on(p.son, "home", "sayHi");
        p.on(s2, "home", "sayHi");
        p.son.on(p.son, "addListener", "onAddListener");
        p.son.emit("g");
        p.son.emit("home");
        p.son.emit("home", 10);
        p.son.emit("home", 'a');
        p.son.emit("home", 1L);
        p.son.emit("home", "it is too late!");
        p.son.emit("home", 10, "it is too late!");
        s2.emit("home", 12);

        System.out.println("--------test method once()--------");
        p.once(p.son, "gohomeOnce", "sayHiOnce");
        p.son.emit("gohomeOnce");
        p.son.emit("gohomeOnce");

        System.out.println("--------test chain trigger--------");
        Son son = new Son("Alis");
        Son petiteSon = new Son("Kevin");
        Parent parent = new Parent();
        parent.on(son, "call", "callGrandpa");
        parent.on(petiteSon, "call", "callGrandpa");
        Grandpa grandpa = new Grandpa();
        grandpa.on(parent, "call", "onCall");
        son.emit("call", son.name);
        petiteSon.emit("call", petiteSon.name);

    }
}
