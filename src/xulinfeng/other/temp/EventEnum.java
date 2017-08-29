package xulinfeng.other.temp;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件信息的定义
 * @author zhangpanfu
 * @date 2016-6-15
 */
public enum EventEnum{

    //module:模块定义：1 登录　2用户　3角色　4 权限　5.系统配置　6公司　7 流程　8: SDK 9:App  10 抽测  11邮件　12其它
    //level:1 提示　2警告　3严重　4致命
    //type:1 用户操作　2 内部运行
    EVENT_LOGIN_SUCCESS(1,"EVENT_LOGIN_SUCCESS",1,1,1),//各字段含义参考构建函数
    EVENT_LOGIN_FAILED(2,"EVENT_LOGIN_FAILED",1,2,1),
    EVENT_USER_AUTO_LOCKED(3,"EVENT_USER_AUTO_LOCKED",1,2,1),
    EVENT_USER_LOGOUT_SUCCESS(4,"EVENT_USER_LOGOUT_SUCCESS",1,1,1),
    EVENT_USER_LOGOUT_FAILED(5,"EVENT_USER_LOGOUT_FAILED",1,2,1),

    EVENT_USER_ADD_SUCCESS(24,"EVENT_USER_ADD_SUCCESS",2,1,1),
    EVENT_USER_ADD_FAILED(25,"EVENT_USER_ADD_FAILED",2,2,1),
    EVENT_USER_EDIT_SUCCESS(26,"EVENT_USER_EDIT_SUCCESS",2,1,1),
    EVENT_USER_EDIT_FAILED(27,"EVENT_USER_EDIT_FAILED",2,2,1),
    EVENT_USER_DELETE_SUCCESS(28,"EVENT_USER_DELETE_SUCCESS",2,1,1),
    EVENT_USER_DELETE_FAILED(29,"EVENT_USER_DELETE_FAILED",2,2,1),
    EVENT_USER_REGISTER_SUCCESS(30,"EVENT_USER_REGISTER_SUCCESS",2,1,1),
    EVENT_USER_REGISTER_FAILED(31,"EVENT_USER_REGISTER_FAILED",2,2,1),
    EVENT_USER_RELEASE_SUCCESS(32,"EVENT_USER_RELEASE_SUCCESS",2,1,1),
    EVENT_USER_RELEASE_FAILED(33,"EVENT_USER_RELEASE_FAILED",2,2,1),
    EVENT_USER_LOCK_SUCCESS(34,"EVENT_USER_LOCK_SUCCESS",2,1,1),
    EVENT_USER_LOCK_FAILED(35,"EVENT_USER_LOCK_FAILED",2,2,1),
    EVENT_USER_RESET_SUCCESS(36,"EVENT_USER_RESET_SUCCESS",2,1,1),
    EVENT_USER_RESET_FAILED(37,"EVENT_USER_RESET_FAILED",2,2,1),
    EVENT_USER_SET_ROLE_SUCCESS(38,"EVENT_USER_SET_ROLE_SUCCESS",2,1,1),
    EVENT_USER_SET_ROLE_FAILED(39,"EVENT_USER_SET_ROLE_FAILED",2,2,1),
    EVENT_USER_MODIFY_PW_SUCCESS(42,"EVENT_USER_MODIFY_PW_SUCCESS",2,1,1),
    EVENT_USER_MODIFY_PW_FAILED(43,"EVENT_USER_MODIFY_PW_FAILED",2,2,1),

    EVENT_ROLE_ADD_SUCCESS(58,"EVENT_ROLE_ADD_SUCCESS",3,1,1),
    EVENT_ROLE_ADD_FAILED(59,"EVENT_ROLE_ADD_FAILED",3,2,1),
    EVENT_ROLE_EDIT_SUCCESS(60,"EVENT_ROLE_EDIT_SUCCESS",3,1,1),
    EVENT_ROLE_EDIT_FAILED(61,"EVENT_ROLE_EDIT_FAILED",3,2,1),
    EVENT_ROLE_DELETE_SUCCESS(62,"EVENT_ROLE_DELETE_SUCCESS",3,1,1),
    EVENT_ROLE_DELETE_FAILED(63,"EVENT_ROLE_DELETE_FAILED",3,2,1),
    EVENT_ROLE_SET_SUCCESS(64,"EVENT_ROLE_SET_SUCCESS",3,1,1),
    EVENT_ROLE_SET_FAILED(65,"EVENT_ROLE_SET_FAILED",3,2,1),
    EVENT_ROLE_SET_USER_SUCCESS(66,"EVENT_ROLE_SET_USER_SUCCESS",3,1,1),
    EVENT_ROLE_SET_USER_FAILED(67,"EVENT_ROLE_SET_USER_FAILED",3,2,1),

    EVENT_AUTH_ADD_SUCCESS(88,"EVENT_AUTH_ADD_SUCCESS",4,1,1),
    EVENT_AUTH_ADD_FAILED(89,"EVENT_AUTH_ADD_FAILED",4,2,1),
    EVENT_AUTH_EDIT_SUCCESS(90,"EVENT_AUTH_EDIT_SUCCESS",4,1,1),
    EVENT_AUTH_EDIT_FAILED(91,"EVENT_AUTH_EDIT_FAILED",4,2,1),
    EVENT_AUTH_DELETE_SUCCESS(92,"EVENT_AUTH_DELETE_SUCCESS",4,1,1),
    EVENT_AUTH_DELETE_FAILED(93,"EVENT_AUTH_DELETE_FAILED",4,2,1),

    EVENT_SYS_CONFIG_SUCCESS(104,"EVENT_SYS_CONFIG_SUCCESS",5,1,1),
    EVENT_SYS_CONFIG_FAILED(105,"EVENT_SYS_CONFIG_FAILED",5,2,1),

    EVENT_COMPANY_ADD_SUCCESS(125,"EVENT_COMPANY_ADD_SUCCESS",6,1,1),
    EVENT_COMPANY_ADD_FAILED(126,"EVENT_COMPANY_ADD_FAILED",6,2,1),
    EVENT_COMPANY_EDIT_SUCCESS(127,"EVENT_COMPANY_EDIT_SUCCESS",6,1,1),
    EVENT_COMPANY_EDIT_FAILED(128,"EVENT_COMPANY_EDIT_FAILED",6,2,1),
    EVENT_COMPANY_DELETE_SUCCESS(129,"EVENT_COMPANY_DELETE_SUCCESS",6,1,1),
    EVENT_COMPANY_DELETE_FAILED(130,"EVENT_COMPANY_DELETE_FAILED",6,2,1),

    EVENT_WORKFLOW_ADD_SUCCESS(151,"EVENT_WORKFLOW_ADD_SUCCESS",7,1,1),
    EVENT_WORKFLOW_ADD_FAILED(152,"EVENT_WORKFLOW_ADD_FAILED",7,2,1),
    EVENT_WORKFLOW_UPDATE_SUCCESS(153,"EVENT_WORKFLOW_UPDATE_SUCCESS",7,1,1),
    EVENT_WORKFLOW_UPDATE_FAILED(154,"EVENT_WORKFLOW_UPDATE_FAILED",7,2,1),
    EVENT_WORKFLOW_DELETE_SUCCESS(155,"EVENT_WORKFLOW_DELETE_SUCCESS",7,1,1),
    EVENT_WORKFLOW_DELETE_FAILED(156,"EVENT_WORKFLOW_DELETE_FAILED",7,2,1),

    EVENT_WFSTEP_ADD_SUCCESS(157,"EVENT_WFSTEP_ADD_SUCCESS",7,1,1),
    EVENT_WFSTEP_ADD_FAILED(158,"EVENT_WFSTEP_ADD_FAILED",7,2,1),
    EVENT_WFSTEP_UPDATE_SUCCESS(159,"EVENT_WFSTEP_UPDATE_SUCCESS",7,1,1),
    EVENT_WFSTEP_UPDATE_FAILED(160,"EVENT_WFSTEP_UPDATE_FAILED",7,2,1),
    EVENT_WFSTEP_DELETE_SUCCESS(161,"EVENT_WFSTEP_DELETE_SUCCESS",7,1,1),
    EVENT_WFSTEP_DELETE_FAILED(162,"EVENT_WFSTEP_DELETE_FAILED",7,2,1),

    EVENT_PUBLIST_SDK_ADD_SUCCESS(183,"EVENT_PUBLIST_SDK_ADD_SUCCESS",8,1,1),
    EVENT_PUBLIST_SDK_ADD_FAILED(184,"EVENT_PUBLIST_SDK_ADD_FAILED",8,2,1),
    EVENT_UPDATE_SDK_UPDATE_SUCCESS(185,"EVENT_UPDATE_SDK_UPDATE_SUCCESS",8,1,1),
    EVENT_UPDATE_SDK_UPDATE_FAILED(186,"EVENT_UPDATE_SDK_UPDATE_FAILED",8,2,1),
    EVENT_DEL_SDK_DELETE_SUCCESS(187,"EVENT_DEL_SDK_DELETE_SUCCESS",8,1,1),
    EVENT_DEL_SDK_DELETE_FAILED(188,"EVENT_DEL_SDK_DELETE_FAILED",8,2,1),
    EVENT_SDK_CMNT_ADD_SUCCESS(189,"EVENT_SDK_CMNT_ADD_SUCCESS",8,1,1),
    EVENT_SDK_CMNT_ADD_FAILED(190,"EVENT_SDK_CMNT_ADD_FAILED",8,2,1),
    EVENT_DEL_CMNT_DELETE_SUCCESS(191,"EVENT_DEL_CMNT_DELETE_SUCCESS",8,1,1),
    EVENT_DEL_CMNT_DELETE_FAILED(192,"EVENT_DEL_CMNT_DELETE_FAILED",8,2,1),
    EVENT_UP_GRADE_SUCCESS(193,"EVENT_UP_GRADE_SUCCESS",8,1,1),
    EVENT_UP_GRADE_FAILED(194,"EVENT_UP_GRADE_FAILED",8,2,1),
    EVENT_SDK_SUBSCRIBE_DELETE_SUCCESS(195,"EVENT_SDK_SUBSCRIBE_DELETE_SUCCESS",8,1,1),
    EVENT_SDK_SUBSCRIBE_DELETE_FAILED(196,"EVENT_SDK_SUBSCRIBE_DELETE_FAILED",8,2,1),
    EVENT_PATCH_PUBLISH(197,"EVENT_PATCH_PUBLISH",8,1,1),
    EVENT_PATCH_TURNON(198,"EVENT_PATCH_TURNON",8,1,1),
    EVENT_PATCH_TURNOFF(199,"EVENT_PATCH_TURNOFF",8,1,1),
    EVENT_PATCH_DOWNLOAD(200,"EVENT_PATCH_DOWNLOAD",8,1,2),
    EVENT_PATCH_UPDATE_FAIL(201,"EVENT_PATCH_UPDATE_FAIL",8,4,2),
    EVENT_PATCH_UPDATE_KEY_SUCCESS(202,"EVENT_PATCH_UPDATE_KEY_SUCCESS",8,1,2),
    EVENT_PATCH_UPDATE_KEY_FAIL(203,"EVENT_PATCH_UPDATE_KEY_FAIL",8,3,2),
    EVENT_PATCH_DUMPED_SUCCESS(204,"EVENT_PATCH_DUMPED_SUCCESS",8,1,2),
    EVENT_PATCH_DUMPED_FAIL(205,"EVENT_PATCH_DUMPED_FAIL",8,3,2),
    EVENT_PATCH_DEL_SUCCESS(206,"EVENT_PATCH_DUMPED_SUCCESS",8,1,1),
    EVENT_PATCH_DEL_FAIL(207,"EVENT_PATCH_DUMPED_FAIL",8,2,1),
    EVENT_SUBSCRIBE_ADD_SUCCESS(208,"EVENT_SUBSCRIBE_ADD_SUCCESS",8,1,1),
    EVENT_SUBSCRIBE_ADD_FAIL(209,"EVENT_SUBSCRIBE_ADD_FAIL",8,1,1),
    EVENT_SDK_DOWNLOAD_SUCCESS(210,"EVENT_SDK_DOWNLOAD_SUCCESS",8,1,1),
    EVENT_SDK_DOWNLOAD_FAILED(211,"EVENT_SDK_DOWNLOAD_FAILED",8,1,1),
    EVENT_PUBLIST_SDK_DELETE_SUCCESS(212,"EVENT_PUBLIST_SDK_DELETE_SUCCESS",8,1,1),
    EVENT_PUBLIST_SDK_DELETE_FAILED(428,"EVENT_PUBLIST_SDK_DELETE_FAILED",8,1,1),

    EVENT_CREATE_APP_SUCCESS(213,"EVENT_CREATE_APP_SUCCESS",9,1,1),
    EVENT_CREATE_APP_FAILED(214,"EVENT_CREATE_APP_FAILED",9,2,1),
    EVENT_UPDATE_APP_SUCCESS(215,"EVENT_UPDATE_APP_SUCCESS",9,1,1),
    EVENT_UPDATE_APP_FAILED(216,"EVENT_UPDATE_APP_FAILED",9,2,1),
    EVENT_DELETE_APP_SUCCESS(217,"EVENT_DELETE_APP_SUCCESS",9,1,1),
    EVENT_DELETE_APP_FAILED(218,"EVENT_DELETE_APP_FAILED",9,2,1),
    EVENT_DELETE_APP_SDK_SUCCESS(219,"EVENT_DELETE_APP_SDK_SUCCESS",9,1,1),
    EVENT_DELETE_APP_SDK_FAILED(220,"EVENT_DELETE_APP_SDK_FAILED",9,2,1),
    EVENT_INSERT_APP_SDK_SUCCESS(221,"EVENT_INSERT_APP_SDK_SUCCESS",9,1,1),
    EVENT_INSERT_APP_SDK_FAILED(222,"EVENT_INSERT_APP_SDK_FAILED",9,2,1),

    EVENT_RANDOM_RESULT_SUCCESS(243,"EVENT_RANDOM_RESULT_SUCCESS",10,1,1),
    EVENT_RANDOM_RESULT_FAILED(244,"EVENT_RANDOM_RESULT_FAILED",10,2,1),
    EVENT_RANDOM_REPORT_SUCCESS(245,"EVENT_RANDOM_REPORT_SUCCESS",10,1,1),
    EVENT_RANDOM_REPORT_FAILED(246,"EVENT_RANDOM_REPORT_FAILED",10,2,1),

    EVENT_CATEGORY_ADD_SUCCESS(267,"EVENT_CATEGORY_ADD_SUCCESS",11,1,1),
    EVENT_CATEGORY_ADD_FAILED(268,"EVENT_CATEGORY_ADD_FAILED",11,2,1),
    EVENT_CATEGORY_UPDATE_SUCCESS(269,"EVENT_CATEGORY_UPDATE_SUCCESS",11,1,1),
    EVENT_CATEGORY_UPDATE_FAILED(270,"EVENT_CATEGORY_UPDATE_FAILED",11,2,1),
    EVENT_BAT_CATEGORY_DEL_SUCCESS(271,"EVENT_BAT_CATEGORY_DEL_SUCCESS",11,1,1),
    EVENT_BAT_CATEGORY_DEL_FAILED(272,"EVENT_BAT_CATEGORY_DEL_FAILED",11,2,1),

    EVENT_EMAIL_RESET_PW_SUCCESS(293,"EVENT_EMAIL_RESET_PW_SUCCESS",12,1,1),
    EVENT_EMAIL_RESET_PW_FAILED(294,"EVENT_EMAIL_RESET_PW_FAILED",12,2,1),
    EVENT_AUDIT_SDK_PUB_SUCCESS(295,"EVENT_AUDIT_SDK_PUB_SUCCESS",12,1,1),
    EVENT_AUDIT_SDK_PUB_FAILED(296,"EVENT_AUDIT_SDK_PUB_FAILED",12,2,1),
    EVENT_AUDIT_APP_SDK_SUCCESS(297,"EVENT_AUDIT_APP_SDK_SUCCESS",12,1,1),
    EVENT_AUDIT_APP_SDK_FAILED(298,"EVENT_AUDIT_APP_SDK_FAILED",12,2,1),
    EVENT_AUDIT_APP_SUCCESS(299,"EVENT_AUDIT_APP_SUCCESS",12,1,1),
    EVENT_AUDIT_APP_FAILED(300,"EVENT_AUDIT_APP_FAILED",12,2,1),
    EVENT_SDK_TAMPER_FAILED(301,"EVENT_SDK_TAMPER_FAILED",12,4,1),
    EVENT_AUDIT_DOWNLOAD_SDK_SUCCESS(302,"EVENT_AUDIT_DOWNLOAD_SDK_SUCCESS",12,1,1),
    EVENT_AUDIT_DOWNLOAD_SDK_FAILED(303,"EVENT_AUDIT_DOWNLOAD_SDK_FAILED",12,2,1),
    EVENT_AUDIT_SDK_NOT_PASS(304,"EVENT_AUDIT_SDK_NOT_PASS",12,1,1),
    EVENT_AUDIT_DOWNLOAD_SDK_NOT_PASS(305,"EVENT_AUDIT_DOWNLOAD_SDK_NOT_PASS",12,1,1),

    EVENT_EMAIL_GETBACK_PW_SUCCESS(342,"EVENT_EMAIL_GETBACK_PW_SUCCESS",13,1,2),
    EVENT_EMAIL_GETBACK_PW_FAILED(343,"EVENT_EMAIL_GETBACK_PW_FAILED",13,3,2),

    EVENT_EM_ASSIGNED_TASK_SUCCESS(344,"EVENT_EM_ASSIGNED_TASK_SUCCESS",13,1,2),
    EVENT_EM_ASSIGNED_TASK_FAILED(345,"EVENT_EM_ASSIGNED_TASK_FAILED",13,2,2),
    EVENT_EM_EXECUTOR_TASK_SUCCESS(346,"EVENT_EM_EXECUTOR_TASK_SUCCESS",13,1,2),
    EVENT_EM_EXECUTOR_TASK_FAILED(347,"EVENT_EM_EXECUTOR_TASK_FAILED",13,2,2),
    EVENT_EM_AUDIT_SDK_PUB_SUCCESS(348,"EVENT_EM_AUDIT_SDK_PUB_SUCCESS",13,1,2),
    EVENT_EM_AUDIT_SDK_PUB_FAILED(349,"EVENT_EM_AUDIT_SDK_PUB_FAILED",13,2,2),
    EVENT_EM_AUDIT_APP_SDK_SUCCESS(350,"EVENT_EM_AUDIT_APP_SDK_SUCCESS",13,1,2),
    EVENT_EM_AUDIT_APP_SDK_FAILED(351,"EVENT_EM_AUDIT_APP_SDK_FAILED",13,2,2),
    EVENT_EM_AUDIT_APP_SUCCESS(352,"EVENT_EM_AUDIT_APP_SUCCESS",13,1,2),
    EVENT_EM_AUDIT_APP_FAILED(353,"EVENT_EM_AUDIT_APP_FAILED",13,2,2),

    EVENT_DUMPED_EVENT_SUCCESS(373,"EVENT_DUMPED_EVENT_SUCCESS",14,1,2),
    EVENT_DUMPED_EVENT_FAILED(374,"EVENT_DUMPED_EVENT_FAILED",14,2,2),
    EVENT_JAVA_METHOD_SUCCESS(375,"EVENT_JAVA_METHOD_SUCCESS",14,1,2),
    EVENT_JAVA_METHOD_FAILED(376,"EVENT_JAVA_METHOD_FAILED",14,2,2),
    EVENT_SYSTEM_PERFORMS_SUCCESS(377,"EVENT_SYSTEM_PERFORMS_SUCCESS",14,1,2),
    EVENT_SYSTEM_PERFORMS_FAILED(378,"EVENT_SYSTEM_PERFORMS_FAILED",14,2,2),
    EVENT_EXPIRE_SESSION_SUCCESS(379,"EVENT_EXPIRE_SESSION_SUCCESS",14,1,2),
    EVENT_EXPIRE_SESSION_FAILED(380,"EVENT_EXPIRE_SESSION_FAILED",14,2,2),
    EVENT_UNLOCK_USER_SUCCESS(381,"EVENT_UNLOCK_USER_SUCCESS",14,1,2),
    EVENT_UNLOCK_USER_FAILED(382,"EVENT_UNLOCK_USER_FAILED",14,2,2),
    EVENT_SYS_PERFORM_DELETE_SUCCESS(383,"EVENT_SYS_PERFORM_DELETE_SUCCESS",14,1,2),
    EVENT_SYS_PERFORM_DELETE_FAILED(384,"EVENT_SYS_PERFORM_DELETE_FAILED",14,2,2),
    EVENT_SYS_INIT_SUCCESS(385,"EVENT_SYS_INIT_SUCCESS",14,1,2),
    EVENT_SYS_INIT_FAILED(386,"EVENT_SYS_INIT_FAILED",14,2,2),

    EVENT_SERVICE_PERFORM_DELETE_SUCCESS(387,"EVENT_SERVICE_PERFORM_DELETE_SUCCESS",14,1,2),
    EVENT_SERVICE_PERFORM_DELETE_FAILED(388,"EVENT_SERVICE_PERFORM_DELETE_FAILED",14,2,2),
    EVENT_DUMPED_AUDIT_SUCCESS(389,"EVENT_DUMPED_AUDIT_SUCCESS",14,1,2),
    EVENT_DUMPED_AUDIT_FAILED(390,"EVENT_DUMPED_AUDIT_FAILED",14,2,2),
    EVENT_DUMPED_COMMENT_SUCCESS(391,"EVENT_DUMPED_COMMENT_SUCCESS",14,1,2),
    EVENT_DUMPED_COMMENT_FAILED(392,"EVENT_DUMPED_COMMENT_FAILED",14,2,2),
    ;

    private static Map<Integer,String> map=new HashMap<Integer,String>();
    private static Map<String,Integer> valueMap=new HashMap<String,Integer>();

    EventEnum(int v, String s,int module,int level,int type)
    {
        this.value=v;
        this.name=s;
        this.module=module;
        this.level=level;
        this.type=type;
    }
    int value;//事件id
    String name;//事件宏
    int module;//事件模块:1 登录　2用户　3角色　4 权限　5.系统配置　6公司　7 流程　8: SDK 9:App  10 抽测  11类目　12其他 13邮件 14内部操作
    int level;//事件级别 :1 提示　2警告　3严重　4致命
    int type;//事件类型 :1 用户操作　2 内部运行

    public static String getName(Integer value){
        if(map.size()==0){
            for(EventEnum e:EnumSet.allOf(EventEnum.class)){
                map.put(e.getValue(), e.getName());
            }
        }
        return map.get(value);
    }

    public static Integer getValueByName(String name){
        if(valueMap.size()==0){
            for(EventEnum e:EnumSet.allOf(EventEnum.class)){
                valueMap.put(e.getName(),e.getValue());
            }
        }
        return valueMap.get(name);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}