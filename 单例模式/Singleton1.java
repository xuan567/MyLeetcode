package 单例模式;

//饿汉式
//线程安全
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    private static Singleton1 getInstance(){
        return instance;
    }
}
