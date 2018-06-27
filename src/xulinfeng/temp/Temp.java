package xulinfeng.temp;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by xujiahong on 2017/10/11.
 * ======================功能列表======================
 */
public class Temp {

    public static void main(String[] args) throws IllegalAccessException {
        A a = new A();
        Class clazz = a.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String,Object> map = new LinkedHashMap<String, Object>();
        for(Field field:fields){
            field.setAccessible(true);
            System.out.println(field.getType()+"-"+field.getName());
            String typeName = field.getType().getName();
            if("java.lang.String".equals(typeName)){//字符串类型，设置默认值
                field.set(a,"stringValue");
            }else if("java.lang.Long".equals(typeName)){
                field.set(a,1L);
            }else if("java.util.Date".equals(typeName)){
                field.set(a,new Date());
            }

            map.put(field.getName(),"stringValue");
        }

        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(map));
    }
}


class A {
    private Long id; //域名申请表ID
    private Long applyId; //申请主表ID
    private String operateItem; //操作项（新增、变更、注销）
    private String businessName; //影响的业务名称
    private String domainName; //域名（多个配置以,分隔）
    private String ipAddress; //实际IP地址（多个配置以,分隔）
    private String ipProvince; //IP地址归属省份
    private String domainType; //类型（A记录、CNAME、AAAA、MX）
    private String domainTil; //TIL值
    private String belongSystem; //所属系统
    private String description; //用途描述
    private java.util.Date applyTime; //申请时间
    private java.util.Date hopeReadyTime; //希望配置完成的时间
    private String endTimeStr; //到期时间字符串（默认'长期'）
    private String uid; //申请人ID（从主表冗余）
    private String userName; //申请人姓名（从主表冗余）
    private String userPhone; //申请人电话
    private Long departmentId; //申请人部门ID
    private String departmentName; //申请人部门名称
    private String remark; //备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getOperateItem() {
        return operateItem;
    }

    public void setOperateItem(String operateItem) {
        this.operateItem = operateItem;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpProvince() {
        return ipProvince;
    }

    public void setIpProvince(String ipProvince) {
        this.ipProvince = ipProvince;
    }

    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    public String getDomainTil() {
        return domainTil;
    }

    public void setDomainTil(String domainTil) {
        this.domainTil = domainTil;
    }

    public String getBelongSystem() {
        return belongSystem;
    }

    public void setBelongSystem(String belongSystem) {
        this.belongSystem = belongSystem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getHopeReadyTime() {
        return hopeReadyTime;
    }

    public void setHopeReadyTime(Date hopeReadyTime) {
        this.hopeReadyTime = hopeReadyTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}