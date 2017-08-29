package xulinfeng.other.annotation;

/**
 * Created by xujiahong on 2017/8/21.
 * ======================功能列表======================
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Pickaxe pickaxe = new Pickaxe();
        Sword sword = new Sword();
        Axe axe = new Axe();
        getInfo(pickaxe);
        getInfo(sword);
        getInfo(axe);
        getInfo(new IronSword());
    }

    /**
     * 注解处理器，运行时读取注解信息，添加新的逻辑
     * @param obj
     */
    public static void getInfo(Object obj){

        Class clazz = obj.getClass();

        String nameInfo = "名称：";
        String durabilityInfo="耐久：";
        String damageInfo="伤害：";

        System.out.println("****************");
        if(clazz.isAnnotationPresent(Obj.class)){
            Obj o = (Obj)clazz.getAnnotation(Obj.class);
            nameInfo += o.name();
            System.out.println(nameInfo);
        }
        if(clazz.isAnnotationPresent(Tool.class)){
            Tool tool = (Tool)clazz.getAnnotation(Tool.class);
            durabilityInfo += tool.durability();
            System.out.println(durabilityInfo);
        }
        if(clazz.isAnnotationPresent(Weapon.class)){
            Weapon weapon = (Weapon) clazz.getAnnotation(Weapon.class);
            damageInfo += weapon.damage();
            System.out.println(damageInfo);
        }

    }
}

@Obj(name = "镐")
@Tool
class Pickaxe {}

@Obj(name = "剑")
@Weapon
class Sword{}

@Obj(name = "斧头")
@Tool(durability = 500)
@Weapon(damage = 9)
class Axe{}

@Obj(name = "铁剑")
class IronSword extends Sword{}