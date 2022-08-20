package 单例模式;

//懒汉式
//线程不安全,在用户第一次调用时初始化。在多线程时不能正常工作
//这个例子是一个线程安全的懒汉式，加了synchronized
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
