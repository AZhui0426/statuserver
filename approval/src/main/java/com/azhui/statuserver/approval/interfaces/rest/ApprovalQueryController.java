package com.azhui.statuserver.approval.interfaces.rest;

import com.azhui.statuserver.approval.interfaces.rest.dto.SubmitApprovalRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang Zhongwei
 * @date 2021/11/25
 */
@RestController
@Api(value = "ProjectController", tags = "审批")
@RequestMapping(value = "/approval")
public class ApprovalQueryController {

    @ApiOperation(value = "分页查询审批信息", notes = "分页查询审批信息")
    @PostMapping(value = "/queryApprovalPage")
    public void queryApprovalPage() {

    }
}
