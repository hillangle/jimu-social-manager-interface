package com.jimu.social.interfaces.controller.app;

import cn.hutool.json.JSONUtil;
import com.jimu.social.interfaces.domain.Group;
import com.jimu.social.interfaces.domain.UserGroup;
import com.jimu.social.interfaces.dto.GroupDto;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.IGroupService;
import com.jimu.social.interfaces.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/group")
@Slf4j
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @PostMapping(value = "/getAllGroup", consumes = "application/json")
    public String getUserGroup(@RequestBody Map<String, Object> params){
        log.info("开始获取全部兴趣小组信息");
        Result result = new Result();
        try {
            List<GroupDto> groupList = groupService.queryGroupListWithUserCount(params);
            result.setResultCode("true");
            result.setResultData(JSONUtil.toJsonStr(groupList).replace("\"", "\\\""));
            result.setResultMsg("全部兴趣小组查询成功");
            result.setHttpCode(200);
            log.info("获取全部兴趣小组信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("全部兴趣小组查询失败");
            result.setHttpCode(200);
            log.error("获取全部兴趣小组信息失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/addGroup", consumes = "application/json")
    public String addGroup(@RequestBody UserGroup userGroup){
        log.info("开始关联用户与兴趣小组");
        Result result = new Result();
        try {
            boolean flag = groupService.joinOrOutGroup(userGroup);
            if (flag) {
                result.setResultCode("true");
                result.setResultData(null);
                result.setResultMsg("关联用户与兴趣小组成功");
                result.setHttpCode(200);
            } else {
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("关联用户与兴趣小组失败");
                result.setHttpCode(200);
            }
        }catch (Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("关联用户与兴趣小组失败");
            result.setHttpCode(200);
            log.error("获取全部兴趣小组信息失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/outGroup", consumes = "application/json")
    public String outGroup(@RequestBody UserGroup userGroup){
        log.info("开始取消关联用户与兴趣小组");
        Result result = new Result();
        try {
            boolean flag = groupService.joinOrOutGroup(userGroup);
            if (flag) {
                result.setResultCode("true");
                result.setResultData(null);
                result.setResultMsg("关联用户与兴趣小组成功");
                result.setHttpCode(200);
            } else {
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("关联用户与兴趣小组失败");
                result.setHttpCode(200);
            }
        }catch (Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("关联用户与兴趣小组失败");
            result.setHttpCode(200);
            log.error("获取全部兴趣小组信息失败",e);
        }
        return result.toJSONString();
    }
}
