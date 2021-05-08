package com.jimu.social.interfaces.controller.sys;

import com.jimu.social.interfaces.domain.Tendency;
import com.jimu.social.interfaces.service.ITendencyService;
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
@RequestMapping("/sys/tendency")
@Slf4j
public class SysTendencyController {

    @Autowired
    private ITendencyService tendencyService;

    @GetMapping("/getTendencyList")
    @ResponseBody
    public PageUtils getTendencyList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Tendency> TendencyList = tendencyService.queryTendencyList(query);
        int total = tendencyService.count(query);
        PageUtils pageUtils = new PageUtils(TendencyList,total);
        return pageUtils;
    }

    @PostMapping("/updateTendencyForStatus")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateTendencyForStatus(Tendency tendency){
        try{
            tendencyService.updateTendency(tendency);
            return ResultUtils.ok("动态状态修改成功");
        } catch (Exception e){
            log.error("动态状态修改失败,失败原因:{}",e);
            return ResultUtils.error("动态状态修改失败");
        }
    }
}
