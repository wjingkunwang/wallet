package template;

/**
 * 好莱坞法则
 * don not call me, we well call you back
 */
public class Client {
    public static void main(String[] args) {
        Drawback drawback = new Drawback();
        drawback.process();

        System.out.println("-----------");
        BankTemplateMethod saveBack = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("存钱");
            }
        };
        saveBack.process();
    }
}
