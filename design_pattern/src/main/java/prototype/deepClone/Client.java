package prototype.deepClone;

/**
 * Created by wjk on 16/3/15.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("snail");
        StudentDeep student1 = new StudentDeep("wjk", teacher);
        StudentDeep student2 = (StudentDeep) student1.clone();
        student2.getTeacher().setName("snail改变");


        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());
    }
}
