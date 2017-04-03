package chainOfResponsibility.LeaveFlow;

/**
 * 模拟请假审批流程:
 * 提出请假申请
 * 3内天假期主任审批
 * 超过3天总经理审批
 * 如果:其中需要一个副总经理审批4~5天的假期,添加职责对象就行
 */
public class Client {

    public static void main(String[] args) {
        LeaveNote leaveNote = new LeaveNote("小米","肚子疼",8);
        DirectorHandler directorHandler = new DirectorHandler();
        ViceManagerHandler viceManagerHandler = new ViceManagerHandler();
        ManagerHandler managerHandler = new ManagerHandler();

        directorHandler.setNextHandler(viceManagerHandler);
        viceManagerHandler.setNextHandler(managerHandler);
        directorHandler.handLeave(leaveNote);
    }
}
