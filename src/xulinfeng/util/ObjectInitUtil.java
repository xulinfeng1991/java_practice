package xulinfeng.util;

import xulinfeng.temp.Template;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/7/30
 */
public class ObjectInitUtil {

    public static <T>T createObject(Class<T> clazz){
        T temp = null;
        try {
            temp = clazz.newInstance();
            return createObject(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T>T createObject(T object){

        try{
            Class clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                Class type = field.getType();
                Object value = field.get(object);
                if(value!=null){
                    continue;
                }
                if(type.equals(String.class)){
                    field.set(object,"stringValue");
                }else if(type.equals(Integer.class)){
                    field.set(object,0);
                }else if(type.equals(Long.class)){
                    field.set(object,0L);
                }else if(type.equals(Float.class)){
                    field.set(object,0F);
                }else if(type.equals(Double.class)){
                    field.set(object,0D);
                }else if(type.equals(Date.class)){
                    field.set(object,new Date());
                }else if(type.equals(LocalDateTime.class)){
                    field.set(object,LocalDateTime.now());
                }else if(type.equals(LocalDate.class)){
                    field.set(object,LocalDate.now());
                }else if(type.equals(LocalTime.class)){
                    field.set(object,LocalTime.now());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(object);
        return object;
    }

    public static void main(String[] args) {
        createObject(Template.class);
        Template t = new Template();
        t.setStringValue("xujiahong");
        createObject(t);
    }



}
