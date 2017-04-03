package prototype.deepClone;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wjk on 16/3/15.
 */
@Data
public class StudentDeep implements Serializable, Cloneable {
    private static final long UID = 6948989635489677685L;
    private String studentName;
    private Teacher teacher;

    public StudentDeep(String studentName, Teacher teacher) {
        this.studentName = studentName;
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        StudentDeep student;
        student = (StudentDeep) super.clone();
        student.setTeacher((Teacher) this.teacher.clone());
        return student;
    }

    /**
     * 使用序列化实现深拷贝
     */
    /*public Object deepClone() {
        try {
            //将对象写到流里
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            //从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return (oi.readObject());
        } catch (Exception e) {
            return null;
        }
    }*/

}
