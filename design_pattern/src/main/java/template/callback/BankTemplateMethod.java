package template.callback;

/**
 * 基本实现： 回调的实现，匿名类部类
 * 缺点：复杂,接口中的方法在具体类中没用也得实现
 * 优点：灵活，避免类的单一继承
 */
public class BankTemplateMethod {

    public void takeNumber() {
        System.out.println("取号");
    }


    public void evaluate() {
        System.out.println("反馈评价");
    }

    public final void process(BackBizCallBack callBack) {
        takeNumber();
        callBack.transact();//具体业务实现抽取到接口中
        evaluate();
    }
}
