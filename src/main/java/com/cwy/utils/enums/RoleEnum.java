package com.cwy.utils.enums;


/**
 * @author siawase
 * @date 2020-05-30 19:14
 */
public enum RoleEnum {
    USER("1","USER"),
    ADMIN("2","ADMIN"),
    SUPERADMIN("3","SUPERASMIN");

    private String code;
    private String desc;

    RoleEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDescByCode(String code){
        for (RoleEnum e:RoleEnum.values()) {
            if(e.code==code){
                return e.desc;
            }
        }
        return "未知";
    }
}
