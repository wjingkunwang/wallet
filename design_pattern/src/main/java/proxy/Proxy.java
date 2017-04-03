package proxy;

/**
 * Created by wjk on 16/6/16.
 */
public class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }
    public void print() {
        System.out.println("我是苦逼代理类,我来打印日志,开始打印日志");
        subject.print();
        System.out.println("打印日志完成,我好累!");
    }
}
