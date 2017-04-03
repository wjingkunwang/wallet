package prototype.lowClone;

/**
 * Created by wjk on 16/3/15.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("snail");

        StudentLow student1 = new StudentLow("wjk", teacher);
        StudentLow student2 = (StudentLow) student1.clone();
        student2.getTeacher().setName("snail改变");

        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());
    }
}
