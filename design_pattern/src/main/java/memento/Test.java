package memento;

import lombok.Data;

/**
 * Created by wjk on 16/7/8.
 */
@Data
public class Test implements Cloneable {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Test test = new Test("wjk");
        try {
            for (int i = 0; i < 10; i++) {
                Test test1 = (Test) test.clone();
                System.out.println(test1.getName());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
