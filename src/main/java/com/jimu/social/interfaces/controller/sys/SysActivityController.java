package com.jimu.social.interfaces.controller.sys;

import com.jimu.social.interfaces.domain.Activity;
import com.jimu.social.interfaces.service.IActivityService;
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
@RequestMapping("/sys/activity")
@Slf4j
public class SysActivityController {

    @Autowired
    private IActivityService activityService;

    @GetMapping("/getActivityList")
    @ResponseBody
    public PageUtils getActivityList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Activity> activityList = activityService.queryActivityList(query);
        int total = activityService.count(query);
        PageUtils pageUtils = new PageUtils(activityList,total);
        return pageUtils;
    }

    @PostMapping("/addActivity")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils addActivity(Activity activity){
        try{
            activityService.save(activity);
            return ResultUtils.ok("活动添加成功");
        } catch (Exception e){
            log.error("活动添加失败,失败原因:{}",e);
            return ResultUtils.error("活动添加失败");
        }
    }

    @PostMapping("/updateActivityForStatus")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateActivityForStatus(Activity activity){
        try{
            activityService.updateActivity(activity);
            return ResultUtils.ok("活动状态修改成功");
        } catch (Exception e){
            log.error("活动状态修改失败,失败原因:{}",e);
            return ResultUtils.error("活动状态修改失败");
        }
    }
}
