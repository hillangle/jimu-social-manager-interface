package com.jimu.social.interfaces.controller.sys;

import com.jimu.social.interfaces.domain.Group;
import com.jimu.social.interfaces.domain.Social;
import com.jimu.social.interfaces.service.IGroupService;
import com.jimu.social.interfaces.utils.DateUtils;
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
@RequestMapping("/sys/group")
@Slf4j
public class SysGroupController {

    @Autowired
    private IGroupService groupService;

    @GetMapping("/getGroupList")
    @ResponseBody
    public PageUtils getGroupList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Group> groupList = groupService.queryGroupList(query);
        int total = groupService.count(query);
        PageUtils pageUtils = new PageUtils(groupList,total);
        return pageUtils;
    }

    @PostMapping("/addGroup")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils addGroup(Group group){
        try{
            group.setCreateDate(DateUtils.getDateByString());
            groupService.save(group);
            return ResultUtils.ok("兴趣小组添加成功");
        } catch (Exception e){
            log.error("兴趣小组添加失败,失败原因:{}",e);
            return ResultUtils.error("兴趣小组添加失败");
        }
    }

    @PostMapping("/updateGroup")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateGroupForStatus(Group group){
        try{
            groupService.updateGroup(group);
            return ResultUtils.ok("兴趣小组状态修改成功");
        } catch (Exception e){
            log.error("兴趣小组状态修改失败,失败原因:{}",e);
            return ResultUtils.error("兴趣小组状态修改失败");
        }
    }
}
