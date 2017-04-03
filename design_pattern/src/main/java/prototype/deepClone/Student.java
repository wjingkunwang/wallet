package prototype.deepClone;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Cloneable {
    private String studentName;
    private Teacher teacher;

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

}
