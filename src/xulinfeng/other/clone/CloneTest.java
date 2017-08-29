package xulinfeng.other.clone;

/**
 * Created by xujiahong on 2017/7/24.
 * ======================功能列表======================
 * CloneNotSupportedException
 * 深拷贝与浅拷贝
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        People p1 = new People("吕布",34);
//        People p2 = p1;//引用赋值，hashCode一致
        People p2 = (People) p1.clone();
        //=================
        System.out.println(p1);
        System.out.println(p2);
    }
}

class People implements Cloneable {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "["+this.hashCode()+"]"+"name["+this.name.hashCode()+"]"+
                "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
