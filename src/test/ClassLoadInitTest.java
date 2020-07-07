package test;

public class ClassLoadInitTest {
    public static void main(String[] args) {
//        new Son();
//        System.out.println("-----------end----------");
            new B();
    }
}
class Son extends Father{
    private int i=1;
    private long l= 2L;
    static int ssi =3;
    static {
        System.out.println("Son.static initializer");
    }
    Son(){
        l = 3L;
        System.out.println("Son.Son");
    }
    {
        System.out.println("Son.instance initializer");
    }
}

class Father{
    int ii;
    static int fsi=4;
    static Son son = new Son();
    Father() {
        ii=1;
        System.out.println("Father.Father");
    }
    {
        System.out.println("Father.instance initializer");
    }
    static {
        System.out.println("Father.static initializer");
    }
}


class A{

    static String str1 = "父类A的静态变量";
    String str2 = "父类A的非静态变量";
//    static B b = new B();
    public A(){
        System.out.println("4执行了父类A的构造方法");
    }

    {
        System.out.println("3执行了父类A的非静态代码块");
    }

    static {
        System.out.println("1执行了父类A的静态代码块");
    }
}

class B extends A{

    static String str1 = "子类B的静态变量";
    String str2 = "子类B的非静态变量";

    static {
        System.out.println("2执行了子类B的静态代码块");
    }

    {
        System.out.println("5执行了子类B的非静态代码块");
    }

    public B(){
        System.out.println("6执行了子类B的构造方法");
    }
}