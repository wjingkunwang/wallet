package mediator;

//同事类的接口
public abstract class Department {
    //持有中介者(总经理)的引用
    private Mediator mediator;

    public Department(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    //做本部门的事情
    void selfAction(){

    }
    //向总经理发出申请
    void outAction(){

    }
}
