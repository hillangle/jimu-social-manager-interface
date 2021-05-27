package com.jimu.social.interfaces.controller.app;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.jimu.social.interfaces.domain.*;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.*;
import com.jimu.social.interfaces.utils.DateUtils;
import com.jimu.social.interfaces.utils.JwtUtils;
import com.jimu.social.interfaces.utils.SmsSendUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    @Autowired
    private INoticService noticService;

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

    @PostMapping("/getNoticList")
    public String getNoticList(@RequestParam Map<String, Object> params){
        log.info("开始获取公告列表");
        Result result = new Result();
        try {
            List<Notic> noticList = noticService.queryNoticList(params);
            result.setResultCode("true");
            result.setResultData(JSONUtil.parseObj(noticList).toString());
            result.setResultMsg("获取公告列表成功");
            result.setHttpCode(200);
            log.info("获取公告列表成功");
        }catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("获取公告列表失败");
            result.setHttpCode(200);
            log.error("获取公告列表失败",e);
        }
        return result.toJSONString();
    }

    @GetMapping("/getSmsCode")
    public String getSmsCode(String telphone){
        log.info("开始获取短信验证码");
        Result result = new Result();
        try{
            String code = RandomUtil.randomNumbers(6);
            //短信发送
            com.aliyun.dysmsapi20170525.Client client = SmsSendUtils.createClient("LTAI4FbxEibmGUmas2269PAs", "NcKKo9D4iFJrEn1MDa6G3hMtCbe90d");
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(telphone)
                    .setSignName("基沐教育")
//                    .setSignName("基沐科技")
                    .setTemplateCode("SMS_185755081")
                    .setTemplateParam("{\"code\":\""+code+"\"}");
            // 复制代码运行请自行打印 API 的返回值
            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
            SendSmsResponseBody body = sendSmsResponse.getBody();
            if (StrUtil.equals("OK", body.getCode())) {
                result.setResultCode("true");
                result.setResultData("{\\\"code\\\":\\\""+code+"\\\"}");
                result.setResultMsg("获取短信验证码成功");
                result.setHttpCode(200);
                log.info("获取公告列表成功");
            }else{
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("获取短信验证码失败");
                result.setHttpCode(200);
                log.error("获取短信验证码失败");
            }
        }catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("获取短信验证码失败");
            result.setHttpCode(200);
            log.error("获取短信验证码失败",e);
        }
        return result.toJSONString();
    }
}
