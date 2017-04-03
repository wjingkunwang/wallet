package chainOfResponsibility.LeaveFlow;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by wjk on 16/7/5.
 */
@Data
@AllArgsConstructor
public class LeaveNote {
    private String name;
    private String leaveReason;
    private int leaverDayNum;
}
