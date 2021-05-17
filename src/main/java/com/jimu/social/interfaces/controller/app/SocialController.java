package com.jimu.social.interfaces.controller.app;

import cn.hutool.json.JSONUtil;
import com.jimu.social.interfaces.domain.Social;
import com.jimu.social.interfaces.domain.UserSocial;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.ISocialService;
import com.jimu.social.interfaces.utils.DateUtils;
import com.jimu.social.interfaces.utils.PageUtils;
import com.jimu.social.interfaces.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/index")
@Slf4j
public class SocialController {

    @Autowired
    private ISocialService socialService;

    @PostMapping(value = "/getAllSocial", consumes = "application/json")
    public String getAllSocial(@RequestBody Map<String, Object> params){
        log.info("开始获取全部平台信息");
        Result result = new Result();
        try {
            List<Social> socialList = socialService.querySocialList(params);
            result.setResultCode("true");
            result.setResultData(JSONUtil.toJsonStr(socialList).replace("\"", "\\\""));
            result.setResultMsg("全部平台查询成功");
            result.setHttpCode(200);
            log.info("获取全部平台信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("全部平台查询失败");
            result.setHttpCode(200);
            log.info("获取全部平台信息失败");
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/addUserSocial", consumes = "application/json")
    public String addUserSocial(@RequestBody UserSocial params){
        log.info("开始关联用户与平台信息");
        Result result = new Result();
        try {
            params.setCreateDate(DateUtils.getDateByString());
            socialService.saveUserSocial(params);
            result.setResultCode("true");
            result.setResultData(null);
            result.setResultMsg("全部平台查询成功");
            result.setHttpCode(200);
            log.info("获取全部平台信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("全部平台查询失败");
            result.setHttpCode(200);
            log.info("获取全部平台信息失败");
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/editUserSocial", consumes = "application/json")
    public String editUserSocial(@RequestBody UserSocial params){
        log.info("开始关联用户与平台信息");
        Result result = new Result();
        try {
            params.setCreateDate(DateUtils.getDateByString());
            socialService.updateUserSocial(params);
            result.setResultCode("true");
            result.setResultData(null);
            result.setResultMsg("全部平台查询成功");
            result.setHttpCode(200);
            log.info("获取全部平台信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("全部平台查询失败");
            result.setHttpCode(200);
            log.info("获取全部平台信息失败");
        }
        return result.toJSONString();
    }
}
