package demo;

class Demo {
    public static void main(String[] args) throws Exception {
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
