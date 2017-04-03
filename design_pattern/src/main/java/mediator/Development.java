package mediator;

public class Development extends Department {

    public Development(Mediator m) {
        super(m);
   }

    public void outAction() {
        System.out.println("汇报工作！没钱了，需要资金支持！");
    }

    public void selfAction() {
        System.out.println("专心科研，开发项目！");
    }
}
