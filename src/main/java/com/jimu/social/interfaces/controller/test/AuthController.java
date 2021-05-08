package com.jimu.social.interfaces.controller.test;

import com.jimu.social.interfaces.domain.SysUser;
import com.jimu.social.interfaces.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
    public class AuthController {
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        SysUser user = new SysUser();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUserName(registerUser.get("username"));
        user.setAccount(registerUser.get("account"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setUserRole(registerUser.get("user_role"));
        user.setSex(registerUser.get("sex"));
        user.setTelphone(registerUser.get("telphone"));
        user.setBirthday(registerUser.get("birthday"));
        user.setRemark(registerUser.get("remark"));
        user.setStatus(registerUser.get("status"));
        user.setCreateDate(sdf.format(new Date()));
        sysUserService.save(user);
        return "success";
 }
}