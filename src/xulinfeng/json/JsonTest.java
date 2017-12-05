package xulinfeng.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * Created by xujiahong on 2017/11/17.
 * ======================功能列表======================
 */
public class JsonTest {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(5);
        user.setName("阿百川");
//        SerializeConfig config = new SerializeConfig();
//        config.setTypeKey("age");
        String jsonStr = JSONObject.toJSONString(user);
//        JSONObject.toJSONString()
        System.out.println(jsonStr);
        JSONObject obj = JSONObject.parseObject(jsonStr);
        //json字符串转业务对象
        Object user1 = JSONObject.parseObject(jsonStr,Object.class);
        System.out.println(JSONObject.toJSONString(user1));

    }
}
