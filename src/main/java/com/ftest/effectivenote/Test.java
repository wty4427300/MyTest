package com.ftest.effectivenote;

public class Test {

    private String name;

    public static void main(String[] args) {
        Test son = Test.getSon("shabi");

        Test test=TestBuilder.aTest().withName("shabi").build();
    }

    /**
     * 1.静态工厂方法(非设计模式里的方法) 代替构造器
     *
     * 2.因为同签名的构造方法只能有一个,换一下参数顺序虽然可行,但是可读性差
     * 而静态构造工厂则没有这个限制.
     *
     * 3.而且所有的静态工厂都是属于同一个类的,一直返回都是同一个类,类似与享元模式,避免了类的重复创建.
     *
     * 4.静态工厂可以返回子类,而构造器只能返回本类的实例,其实建造者模式使用的就是这种方式,不过是使用了内部类罢了
     *
     * 5.不对外暴露类的实例化的方式,提高类的可控性
     *
     * 6.一些常见的静态工厂的命名(直接看书吧,这些定式的东西不适合作为思考写在这里)
     *
     */
    public static Boolean valueOf(boolean b){
        return b?Boolean.TRUE:Boolean.FALSE;
    }

    /**
     * 返回子类的方式
     *
     * 客户端永远不知道也不关心它们从工厂方法中得到的对象的类,它们只关
     * 心它是 Test 的某个子类 。
     *
     * 这个子类可以当时不存在,以后在写,增强的扩展性
     *
     * @param str
     * @return
     */
    public static Test getSon(String str){
        return new TestSon();
    }


    /**
     * 建造模式,成员变量和主类完全一直.
     * 好处是构建的过程中完全对于一个类进行操作.每一次aClass的时候都是另外一个类.
     * javaBeans的方式(get,set)就无法保证这类的唯一性.
     *
     * 类是地用build时统一初始化的,而且还获得了一个链式的api
     */
    public static final class TestBuilder {
        private String name;

        private TestBuilder() {
        }

        public static TestBuilder aTest() {
            return new TestBuilder();
        }

        public TestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Test build() {
            Test test = new Test();
            test.name = this.name;
            return test;
        }
    }
}
