# README

模仿node.js中eventEmitter机制做的java事件-触发机制类

使用时只需继承AbstractEventEmitter类，即可调用相关方法实现事件-触发机制


### 特点
- 基于"对象-对象"的监听-触发机制而非事件总线式的事件-触发机制
- 封装完整，继承即用
- 脚手架式设计预留后续开发空间
- 支持链式触发


### 知识点
- 反射调用类和方法
    - 处理反射获得多态事件的传参匹配
- 面向抽象编程，接口、抽象类和（供开发）新实现类的完整框架设计
- 规范的名称、注释和接口设计


### 方法接口

- on(): 通过事件关键字将调用者的一个方法作为监听者绑定到特定对象上

    例：`parent.on(son, "home", "sayHi");`
- once(): 同on()，但绑定的监听者只能触发一次

    例：`parent.once(son, "home", "sayHiOnce");`
- removeListener(): 移除特定的监听者

    例：`son.off("home", "sayHi");`
- off(): 移除某个事件关键字下所有监听者

    例：`son.off("home");`
- emit(): 通过事件关键字触发监听者（方法），支持传参

    例：`son.emit("home", 10);`
    
    
### 内置事件

开发者可重写以下方法实现定制功能，使用者可重新绑定相关关键字来实现定制功能
- onAddListener：当新增监听器时默认调用

    例：`son.on(son, "addListener", "onAddListener");` -> 由son自己的onAddListener()方法覆盖默认方法
- onRemoveListener：当移除监听器时默认调用

    例：`son.on(son, "removeListener", "onRemoveListener");` -> 由son自己的onRemoveListener()方法覆盖默认方法
