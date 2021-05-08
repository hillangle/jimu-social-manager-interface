package com.jimu.social.interfaces.controller.sys;

import com.jimu.social.interfaces.domain.Social;
import com.jimu.social.interfaces.service.ISocialService;
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
@RequestMapping("/sys/social")
@Slf4j
public class SysSocialController {

    @Autowired
    private ISocialService socialService;

    @GetMapping("/getSocialList")
    @ResponseBody
    public PageUtils getSocialList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Social> socialList = socialService.querySocialList(query);
        int total = socialService.count(query);
        PageUtils pageUtils = new PageUtils(socialList,total);
        return pageUtils;
    }

    @PostMapping("/addSocial")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils addSocial(Social social){
        try{
            socialService.save(social);
            return ResultUtils.ok("社交平台添加成功");
        } catch (Exception e){
            log.error("社交平台添加失败,失败原因:{}",e);
            return ResultUtils.error("社交平台添加失败");
        }
    }

    @PostMapping("/updateSocial")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateSocialForStatus(Social social){
        try{
            socialService.updateSocial(social);
            return ResultUtils.ok("社交平台状态修改成功");
        } catch (Exception e){
            log.error("社交平台状态修改失败,失败原因:{}",e);
            return ResultUtils.error("社交平台状态修改失败");
        }
    }
}
