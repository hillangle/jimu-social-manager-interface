package com.jimu.social.interfaces.controller.sys;

import cn.hutool.core.util.PageUtil;
import com.jimu.social.interfaces.domain.SysUser;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.dto.SysUserQueryDto;
import com.jimu.social.interfaces.service.ISysUserService;
import com.jimu.social.interfaces.utils.PageUtils;
import com.jimu.social.interfaces.utils.Query;
import com.jimu.social.interfaces.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/getUserList")
    @ResponseBody
    public PageUtils getUserList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<SysUser> sysUserList = sysUserService.queryUserPage(query);
        int total = sysUserService.count(query);
        PageUtils pageUtils = new PageUtils(sysUserList,total);
        return pageUtils;
    }

    @PostMapping("/updateUserForStatus")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateUserForStatus(@RequestParam Map<String, Object> params){
        try{
            sysUserService.updateSysUser(params);
            return ResultUtils.ok("用户状态修改成功");
        } catch (Exception e){
            log.error("用户状态修改失败,失败原因:{}",e);
            return ResultUtils.error("用户状态修改失败");
        }
    }
}
