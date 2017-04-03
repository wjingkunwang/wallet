package mediator;

public  class Financial extends Department {

    public Financial(Mediator m) {
        super(m);
    }

    public void outAction() {
        System.out.println("汇报工作！没钱了，钱太多了！怎么花?");
    }

    public void selfAction() {
        System.out.println("数钱！");
    }
}
