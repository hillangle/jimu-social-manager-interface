package com.jimu.social.interfaces.controller.app;

import cn.hutool.json.JSONUtil;
import com.jimu.social.interfaces.domain.Activity;
import com.jimu.social.interfaces.domain.Social;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/activity")
@Slf4j
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @PostMapping(value = "/getActivityList", consumes = "application/json")
    public String getAllSocial(@RequestBody Map<String, Object> params){
        log.info("开始获取全部平台信息");
        Result result = new Result();
        try {
            List<Activity> activityList = activityService.queryActivityList(params);
            result.setResultCode("true");
            result.setResultData(JSONUtil.toJsonStr(activityList).replace("\"", "\\\""));
            result.setResultMsg("全部活动查询成功");
            result.setHttpCode(200);
            log.info("获取全部活动信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("全部活动查询失败");
            result.setHttpCode(200);
            log.info("获取全部活动信息失败");
        }
        return result.toJSONString();
    }
}
