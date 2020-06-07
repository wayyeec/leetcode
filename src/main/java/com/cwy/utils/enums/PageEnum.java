package com.cwy.utils.enums;


/**
 * @author siawase
 * @date 2020-05-30 19:14
 */
public enum PageEnum {
    LOGIN("2","login"),
    FRAME("1","frame");

    private String code;
    private String desc;

    PageEnum(String code, String desc){
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
}
