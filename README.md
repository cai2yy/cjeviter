CJEviter
---
模仿node.js中eventEmitter机制做的java事件-触发机制类

使用时只需继承AbstractEventEmitter类，即可调用相关方法实现事件-触发机制

留下可开发的一些默认事件函数接口，也可通过重写自由设计你的EventEmitter类

特点
---
- 基于"对象-对象"的监听-触发机制而非事件总线式的事件-触发机制
- 封装完整，继承即用
- 脚手架式设计预留后续开发空间
- 支持链式触发

知识点
---
- 反射调用类和方法
    - 处理反射获得多态事件的传参匹配
    - 禁用安全性检查绕过监听器所属类或方法的权限限制
- 面向抽象编程，接口、抽象类和（供开发）新实现类的完整框架设计
- 规范的名称、注释和接口设计

缺点
---
- 封装不够严密，处理类和类之间的调用关系时耦合和暴露内部信息较多

方法接口
---
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
    
    
内置事件
---
开发者可重写以下内置函数：
- onAddListener：当新增监听器时默认调用

    例：`son.on(son, "addListener", "onAddListener");` -> 由son自己的onAddListener()方法覆盖默认方法
- onRemoveListener：当移除监听器时默认调用

    例：`son.on(son, "removeListener", "onRemoveListener");` -> 由son自己的onRemoveListener()方法覆盖默认方法

Cai2yy
---
Java, Python, Node.js, Love 

https://github.com/cai2yy

- ArmOT: 边缘计算IOT软件+数据上云web端管理平台
> https://github.com/cai2yy/armot
- CJHttp: 基于netty实现的轻便web框架（http）
> https://github.com/cai2yy/cjhttp
- CJIoc：多功能的轻量级IOC框架
> https://github.com/cai2yy/cjioc
- CJEviter: 模仿node.js中eventEmitter类的JAVA实现
> https://github.com/cai2yy/cjeviter
