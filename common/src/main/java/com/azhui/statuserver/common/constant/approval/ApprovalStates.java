package com.azhui.statuserver.common.constant.approval;

/**
 * @author Yang Zhongwei
 * @date 2021/11/26
 */
public enum ApprovalStates {

    PENDING_APPROVAL(1, "待审批"),

    APPROVAL_NOT_PASS(2, "审批未通过"),

    APPROVAL_PASS(3, "审批通过");

    public final int code;
    public final String desc;

    ApprovalStates(int code, String desc) {
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
