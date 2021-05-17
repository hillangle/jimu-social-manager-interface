package com.jimu.social.interfaces.controller.app;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jimu.social.interfaces.domain.Atta;
import com.jimu.social.interfaces.domain.SysUser;
import com.jimu.social.interfaces.domain.UserAtta;
import com.jimu.social.interfaces.domain.UserGroup;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.IAttaService;
import com.jimu.social.interfaces.service.IGroupService;
import com.jimu.social.interfaces.service.ISocialService;
import com.jimu.social.interfaces.service.ISysUserService;
import com.jimu.social.interfaces.utils.DateUtils;
import com.jimu.social.interfaces.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/index")
@Slf4j
public class UserController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISocialService socialService;

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IAttaService attaService;

    @PostMapping(value = "/getUserInfo", consumes = "application/json")
    public String getUserInfo(HttpServletRequest request){
        log.info("开始获取用户信息");
        Result result = new Result();
        try {
            String username = JwtUtils.getUsername(request.getHeader(JwtUtils.TOKEN_HEADER).replace(JwtUtils.TOKEN_PREFIX, ""));
            Map<String, Object> map = new HashMap<>();
            map.put("account", username);
            List users = sysUserService.queryUserInfo(map);
            if (users.size() == 1) {
                result.setResultCode("true");
                result.setResultData(JSONUtil.toJsonStr(users.get(0)).replace("\"", "\\\""));
                result.setResultMsg("用户查询成功");
                result.setHttpCode(200);
                log.info("获取用户信息成功");
            } else {
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("用户查询失败");
                result.setHttpCode(200);
                log.info("获取用户信息失败");
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户查询失败");
            result.setHttpCode(200);
            log.error("获取用户信息失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/getUserSocial", consumes = "application/json")
    public String getUserSocial(HttpServletRequest request){
        log.info("开始获取用户绑定平台信息");
        Result result = new Result();
        try {
            String username = JwtUtils.getUsername(request.getHeader(JwtUtils.TOKEN_HEADER).replace(JwtUtils.TOKEN_PREFIX, ""));
            Map<String, Object> map = new HashMap<>();
            map.put("account", username);
            List socials = socialService.queryUserSocial(map);
            if (socials.size() > 0) {
                result.setResultCode("true");
                result.setResultData(JSONUtil.toJsonStr(socials).replace("\"", "\\\""));
                result.setResultMsg("用户绑定平台查询成功");
                result.setHttpCode(200);
                log.info("获取用户绑定平台信息成功");
            } else {
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("用户绑定平台查询失败");
                result.setHttpCode(200);
                log.info("获取用户绑定平台信息失败");
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户绑定平台查询失败");
            result.setHttpCode(200);
            log.error("获取用户绑定平台信息失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/getUserGroup", consumes = "application/json")
    public String getUserGroup(HttpServletRequest request){
        log.info("开始获取用户加入兴趣小组信息");
        Result result = new Result();
        try {
            String username = JwtUtils.getUsername(request.getHeader(JwtUtils.TOKEN_HEADER).replace(JwtUtils.TOKEN_PREFIX, ""));
            Map<String, Object> map = new HashMap<>();
            map.put("account", username);
            List group = groupService.queryUserGroup(map);
            if (group.size() > 0) {
                result.setResultCode("true");
                result.setResultData(JSONUtil.toJsonStr(group).toString().replace("\"", "\\\""));
                result.setResultMsg("用户加入兴趣小组查询成功");
                result.setHttpCode(200);
                log.info("获取用户加入兴趣小组信息成功");
            } else {
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("用户加入兴趣小组查询失败");
                result.setHttpCode(200);
                log.info("获取加入兴趣小组平台信息失败");
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户加入兴趣小组查询失败");
            result.setHttpCode(200);
            log.error("获取用户加入兴趣小组信息失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/addUserGroup", consumes = "application/json")
    public String addUserGroup(Map<String,Object> map, HttpServletRequest request){
        log.info("开始添加用户与兴趣小组关联信息");
        Result result = new Result();
        try {
            String username = JwtUtils.getUsername(request.getHeader(JwtUtils.TOKEN_HEADER).replace(JwtUtils.TOKEN_PREFIX, ""));
            SysUser sysUser = sysUserService.queryUserByAccount(username);
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(sysUser.getUnid().toString());
            userGroup.setGroupId(map.get("groupId").toString());
            userGroup.setStatus("0");
            userGroup.setCreateDate(DateUtils.getDateByString());
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户加入兴趣小组失败");
            result.setHttpCode(200);
            log.error("获取用户加入兴趣小组失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/editUserInfo", consumes = "application/json")
    public String editUserInfo(@RequestBody Map<String,Object> map, HttpServletRequest request){
        log.info("开始编辑用户资料");
        Result result = new Result();
        try {
            boolean flag = sysUserService.updateSysUser(map);
            if(flag){
                JSONArray imagesJson = JSONUtil.parseArray(map.get("images"));
                JSONObject img;
                UserAtta userAtta = new UserAtta();
                Atta atta = new Atta();
                for(Object image : imagesJson){
                    img = JSONUtil.parseObj(image);
                    atta.setAttaType(img.get("attaType").toString());
                    atta.setAttaName(img.get("attaName").toString());
                    atta.setAttaPath(img.get("attaPath").toString());
                    atta.setStatus("0");
                    atta.setCreateDate(DateUtils.getDateByString());
                    attaService.save(atta);
                    userAtta.setAttaUnid(atta.getAttaUnid());
                    userAtta.setUserUnid(map.get("unid").toString());
                    userAtta.setAttaType(img.get("fileType").toString());
                    userAtta.setStatus("0");
                    userAtta.setCreateDate(DateUtils.getDateByString());
                    attaService.saveUserAtta(userAtta);
                }
                result.setResultCode("true");
                result.setResultData(JSONUtil.parseObj(userAtta).toString());
                result.setResultMsg("用户编辑成功");
                result.setHttpCode(200);
                log.info("用户编辑成功");
            }else{
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("用户编辑成功失败");
                result.setHttpCode(200);
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户编辑成功失败");
            result.setHttpCode(200);
            log.error("用户编辑成功失败",e);
        }
        return result.toJSONString();
    }
}
