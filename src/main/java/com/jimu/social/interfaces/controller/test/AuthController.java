package com.jimu.social.interfaces.controller.test;

import com.jimu.social.interfaces.domain.SysUser;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.ISysUserService;
import com.jimu.social.interfaces.utils.DateUtils;
import com.jimu.social.interfaces.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        log.info("开始用户登录/注册");
        Result result = new Result();
        SysUser user = new SysUser();
        List<SysUser> users = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("account",registerUser.get("account"));
        map.put("userRole",registerUser.get("user_role"));
        try {
            users = sysUserService.queryUserList(map);//根据用户名、密码、权限查询用户
            if (users.size() > 1) {//根据用户名查询得到多个结果说明账号异常，返回提示
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("用户名重复，请联系管理员");
                result.setHttpCode(200);
            }else if(users.size() == 1 ){//已有用户且未被封号则返回token
                user = users.get(0);
                if(user.status.equals("0") && bCryptPasswordEncoder.matches(registerUser.get("password"),user.getPassword())){
                    result.setResultCode("true");
                    result.setResultData(JwtUtils.createToken(registerUser.get("account"), registerUser.get("userRole")));
                    result.setResultMsg("用户查询成功");
                    result.setHttpCode(200);
                }else if(user.status.equals("1") && bCryptPasswordEncoder.matches(registerUser.get("password"),user.getPassword())){
                    result.setResultCode("false");
                    result.setResultData(null);
                    result.setResultMsg("用户已被封号，请联系管理员");
                    result.setHttpCode(200);
                }else if(user.status.equals("0") && !bCryptPasswordEncoder.matches(registerUser.get("password"),user.getPassword())){
                    result.setResultCode("false");
                    result.setResultData(null);
                    result.setResultMsg("密码/激活码错误");
                    result.setHttpCode(200);
                }
            }else {//没有用户则新建用户并返回token
                user.setUserName(registerUser.get("username"));
                user.setAccount(registerUser.get("account"));
                user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
                user.setUserRole(registerUser.get("userRole"));
                user.setSex(registerUser.get("sex"));
                user.setTelphone(registerUser.get("telphone"));
                user.setBirthday(registerUser.get("birthday"));
                user.setRemark(registerUser.get("remark"));
                user.setStatus(registerUser.get("status"));
                user.setCreateDate(DateUtils.getDateByString());
                sysUserService.save(user);
                log.info("用户注册成功");
                result.setResultCode("true");
                result.setResultData(JwtUtils.createToken(registerUser.get("account"), registerUser.get("userRole")));
                result.setResultMsg("用户查询成功");
                result.setHttpCode(200);
            }
        }catch(Exception e){
            log.error("用户注册失败，{}",e);
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("用户注册失败");
            result.setHttpCode(200);
        }
        return result.toJSONString();
 }
}