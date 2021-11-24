package com.azhui.statuserver.approval.controller;

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
public class ApprovalController {

    @ApiOperation(value = "提交审批", notes = "提交审批")
    @PostMapping(value = "/submitApprovalOpinion")
    public void submitApprovalOpinion() {
    }
}
