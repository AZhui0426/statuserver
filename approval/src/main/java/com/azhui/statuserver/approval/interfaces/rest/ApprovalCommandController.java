package com.azhui.statuserver.approval.interfaces.rest;

import com.azhui.statuserver.approval.interfaces.rest.dto.SubmitApprovalRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang Zhongwei
 * @date 2021/11/24
 */
@RestController
@Api(value = "ProjectController", tags = "审批")
@RequestMapping(value = "/approval")
public class ApprovalCommandController {

    @ApiOperation(value = "提交审批信息", notes = "提交审批信息")
    @PostMapping(value = "/submitApproval")
    public void submitApproval(SubmitApprovalRequest request) {

    }

    @ApiOperation(value = "审批审批信息", notes = "审批审批信息")
    @PostMapping(value = "/ApproveApproval")
    public void approveApproval() {

    }
}
