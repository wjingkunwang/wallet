package template;

/**
 * 基本实现： 抽象类的实现
 *
 * 缺点：是类会爆炸
 * 优点：简单
 */
public abstract class BankTemplateMethod {

    public void takeNumber() {
        System.out.println("取号");
    }

    public abstract void transact();//具体业务

    public void evaluate() {
        System.out.println("反馈评价");
    }

    public final void process() {
        takeNumber();
        transact();
        evaluate();
    }
}
