package com.azhui.statuserver.approval.domain.model.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @author Yang Zhongwei
 * @date 2021/11/26
 */
@Embeddable
public class ApplyInfo {

    /**
     * 申请时间
     */
    private Date applyTime;
}
