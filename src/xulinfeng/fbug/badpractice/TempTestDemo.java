package xulinfeng.fbug.badpractice;

/**
 * Created by xujiahong on 2017/7/24.
 * ======================功能列表======================
 */
public class TempTestDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        Teacher t1 = new Teacher();
        System.out.println(s1.equals(t1));
    }
}

class Student {
    private String name = "";
}

class Teacher {
    private String name = "";
}
