package proxy;

/**
 * Created by wjk on 16/6/16.
 */
public class RealSubject implements Subject {
    public void print() {
        System.out.println("我不想打印日志,让我的代理类来打印吧");
    }
}
