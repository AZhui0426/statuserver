package com.azhui.statuserver.approval.domain.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yang Zhongwei
 * @date 2021/11/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ApplyForApproval {

    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(length = 100)
    private String approvalTitle;

    /**
     * 审批数据
     */
    @Column(columnDefinition="TEXT")
    private String approvalData;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 审批状态
     *
     * @see com.azhui.statuserver.common.constant.approval.ApprovalStates
     */
    @Column(length = 1)
    private Integer approvalStatus;

    /**
     * 审批意见
     */
    @Column(length = 100)
    private String approvalOpinion;

    /**
     * 审批时间
     */
    private Date approvalTime;

    /**
     * 乐观锁，防止数据被同时审批
     */
    @Version
    private Long version;
}
