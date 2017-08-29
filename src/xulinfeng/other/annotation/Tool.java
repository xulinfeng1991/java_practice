package xulinfeng.other.annotation;

import java.lang.annotation.*;

/**
 * Created by xujiahong on 2017/8/21.
 * ======================功能列表======================
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tool {
    int durability() default 100;
}
