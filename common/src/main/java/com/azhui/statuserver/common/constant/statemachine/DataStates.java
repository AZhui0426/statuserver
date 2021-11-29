package com.azhui.statuserver.common.constant.statemachine;

/**
 * @author Yang Zhongwei
 * @date 2021/11/26
 */
public enum DataStates {

    SAVED(1, "保存"),
    APPROVAL_ING(2, "审批中"),
    APPROVAL_NO_PASS(3, "不通过"),
    USING(4, "启用中"),
    ;

    public final int code;
    public final String desc;

    DataStates(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
