package com.jimu.social.interfaces.controller.app;

import cn.hutool.json.JSONUtil;
import com.jimu.social.interfaces.domain.SysUser;
import com.jimu.social.interfaces.domain.UserActiveRecord;
import com.jimu.social.interfaces.domain.UserActiveRecord;
import com.jimu.social.interfaces.domain.UserGroup;
import com.jimu.social.interfaces.domain.vo.UserActiveRecordVO;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.IUserActiveRecordService;
import com.jimu.social.interfaces.utils.DateUtils;
import com.jimu.social.interfaces.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/userActiveRecord")
@Slf4j
public class UserActiveRecordController {

    @Autowired
    private IUserActiveRecordService userActiveRecordService;

    /**
    * @Description: 获取用户活动列表
    * @Param: [params]
    * @return: java.lang.String
    * @Author: liangqi
    * @Date: 2021/5/30 12:33
    */
    @PostMapping(value = "/getUserActiveRecordList", consumes = "application/json")
    public String getAllSocial(@RequestBody Map<String, Object> params){
        log.info("开始获取全部用户活动信息");
        Result result = new Result();
        try {
            List<UserActiveRecordVO> userActiveRecordList = userActiveRecordService.queryUserActiveRecordList(params);
            result.setResultCode("true");
            result.setResultData(JSONUtil.toJsonStr(userActiveRecordList).replace("\"", "\\\""));
            result.setResultMsg("全部用户活动查询成功");
            result.setHttpCode(200);
            log.info("获取全部用户活动信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("全部用户活动查询失败");
            result.setHttpCode(200);
            log.info("获取全部用户活动信息失败");
        }
        return result.toJSONString();
    }

    /**
    * @Description: 新增用户活动信息
    * @Param: [map, request]
    * @return: java.lang.String
    * @Author: liangqi
    * @Date: 2021/5/30 12:33
    */
    @PostMapping(value = "/addUserActiveRecord", consumes = "application/json")
    public String addUserActiveRecord(@RequestBody UserActiveRecord userActiveRecord){
        log.info("开始添加用户活动信息");
        Result result = new Result();
        try {
            userActiveRecord.setStatus("0");
            userActiveRecord.setCreateDate(DateUtils.getDateByString());
            userActiveRecord.setModifyDate(DateUtils.getDateByString());
            userActiveRecordService.save(userActiveRecord);
            result.setResultCode("true");
            result.setResultData(null);
            result.setResultMsg("添加用户活动成功");
            result.setHttpCode(200);
            log.info("添加用户活动成功");
            
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户添加活动失败");
            result.setHttpCode(200);
            log.error("获取用户添加活动失败",e);
        }
        return result.toJSONString();
    }
}
