package template.callback;

/**
 * Created by wjk on 2017/3/3.
 */
public class Client {
    //取钱
    public static  void draw() {
        new BankTemplateMethod().process(new BackBizCallBack() {
            public void transact() {
                System.out.println("取钱");
            }
        });
    }

    //挂失
    public static void loseCard() {
        new BankTemplateMethod().process(new BackBizCallBack() {
            public void transact() {
                System.out.println("挂失卡");
            }
        });
    }

    public static void main(String[] args) {
        draw();
        System.out.println("----------------------");
        loseCard();
    }
}
