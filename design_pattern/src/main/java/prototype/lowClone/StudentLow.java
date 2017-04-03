package prototype.lowClone;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wjk on 16/3/15.
 */
@Data
public class StudentLow implements Serializable, Cloneable {
    private static final long UID = 6948989635489677685L;
    private String studentName;
    private Teacher teacher;

    public StudentLow(String studentName, Teacher teacher) {
        this.studentName = studentName;
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        StudentLow student;
        student = (StudentLow) super.clone();
        return student;
    }

}
