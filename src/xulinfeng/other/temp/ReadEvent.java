package xulinfeng.other.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by xujiahong on 2017/7/19.
 * ======================功能列表======================
 */
public class ReadEvent {
    public static void main(String[] args) {
        List<Integer> eventIds = getEventIds("公司");
        System.out.println(eventIds);
    }

    /**
     * 得到匹配的ID列表
     * @param str
     * @return
     */
    public static List<Integer> getEventIds(String str){
        List<Integer> eventIds = new ArrayList<Integer>();
        Map<String,String> eventMap = getEventMap();
        if(eventMap!=null && !eventMap.isEmpty()){//map不为空就遍历对比
            Set<String> keySet = eventMap.keySet();
            for(String key : keySet){
                if(eventMap.get(key).contains(str)){
                    Integer eventId = EventEnum.getValueByName(key);
                    eventIds.add(eventId);
                }
            }
        }
        return eventIds;
    }

    /**
     * 将 event_zh_CN.properties 文件转换为 map 对象
     * @return
     */
    public static Map<String,String> getEventMap(){
        Map<String,String> map = new HashMap<String, String>();
        File eventProperties = new File("src/com/other/temp/event_zh_CN.properties");
//        System.out.println(eventProperties.getAbsolutePath());
//        System.out.println(eventProperties.exists());
//        System.out.println(eventProperties.length());

        try{
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(eventProperties),"GBK");//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);

            String lineTxt = "";
            while((lineTxt = bufferedReader.readLine()) != null){
                if(!"".equals(lineTxt)){
                    String[] strs = ascii2native(lineTxt).split("=");
                    map.put(strs[0],strs[1]);
                }
            }
            read.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("【事件关键字查询】读取文件event_zh_CN.properties失败");
        }
        return map;
    }

    //unicode 转中文
    private static String ascii2native ( String asciicode )
    {
        String[] asciis = asciicode.split ("\\\\u");
        String nativeValue = asciis[0];
        try
        {
            for ( int i = 1; i < asciis.length; i++ )
            {
                String code = asciis[i];
                nativeValue += (char) Integer.parseInt (code.substring (0, 4), 16);
                if (code.length () > 4)
                {
                    nativeValue += code.substring (4, code.length ());
                }
            }
        }
        catch (NumberFormatException e)
        {
            return asciicode;
        }
        return nativeValue;
    }
}
