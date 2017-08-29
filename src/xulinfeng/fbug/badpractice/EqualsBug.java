package xulinfeng.fbug.badpractice;

/**
 * Created by xujiahong on 2017/7/24.
 * ======================功能列表======================
 */
public class EqualsBug {
    /*
    Unwritten field
    Read of unwritten field
     */
    private String name = "";
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualsBug equalsBug = (EqualsBug) o;

        if (age != equalsBug.age) return false;
        return name.equals(equalsBug.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
