package java8;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("张三", 20));
        users.add(new User("李四", 21));
        users.add(new User("王五", 25));

        users.forEach((User user) -> System.out.println(user.getAge()));

        Stream<User> stream = users.stream();
        stream.filter(p -> p.getAge() > 20); //过滤年龄大于20的
        System.out.println(stream);

//        //所有的年龄大于20岁的User对象，转换为字符串50对象。现在流中只有字符串对象了。
//        stream.filter((User user) ->  user.getAge() > 20).map((User user) -> {return "50";});
//
//        long count = stream.filter((User user) ->  user.getAge() >= 20).map((User user) -> {return "50";})
//                .count(); //返回流中元素的个数。
//        System.out.println(count);
    }



}
