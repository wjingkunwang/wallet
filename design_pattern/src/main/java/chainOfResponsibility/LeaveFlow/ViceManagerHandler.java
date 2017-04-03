package chainOfResponsibility.LeaveFlow;

/**
 * Created by wjk on 16/7/5.
 */
public class ViceManagerHandler implements Handler {
    private Handler nextHandler;

    public void handLeave(LeaveNote leaveNote) {
        if (leaveNote.getLeaverDayNum() <= 5) {
            System.out.println("副总经理同意" + leaveNote.getName() + "申请请假" + leaveNote.getLeaverDayNum() + "天,原因:" + leaveNote.getLeaveReason());
        } else {
            nextHandler.handLeave(leaveNote);
        }
    }

    public void setNextHandler(Handler h) {
        nextHandler = h;
    }
}
