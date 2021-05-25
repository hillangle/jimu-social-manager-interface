package com.jimu.social.interfaces.controller.sys;

import com.jimu.social.interfaces.domain.Notic;
import com.jimu.social.interfaces.service.INoticService;
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

/**
* @Description: 公告接口
* @Param: 
* @return: 
* @Author: liangqi
* @Date: 2021/5/26 0:39
*/
@RestController
@RequestMapping("/sys/notic")
@Slf4j
public class SysNoticController {

    @Autowired
    private INoticService noticService;

    /**公告列表
    * @Description: 
    * @Param: [params]
    * @return: com.jimu.social.interfaces.utils.PageUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:39
    */
    @GetMapping("/getNoticList")
    @ResponseBody
    public PageUtils getNoticList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Notic> noticList = noticService.queryNoticList(query);
        int total = noticService.count(query);
        PageUtils pageUtils = new PageUtils(noticList,total);
        return pageUtils;
    }

    /**
    * @Description: 添加公告
    * @Param: [notic]
    * @return: com.jimu.social.interfaces.utils.ResultUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:39
    */
    @PostMapping("/addNotic")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils addNotic(Notic notic){
        try{
            notic.setCreateDate(DateUtils.getDateByString());
            notic.setModifyDate(DateUtils.getDateByString());
            noticService.save(notic);
            return ResultUtils.ok("公告添加成功");
        } catch (Exception e){
            log.error("公告添加失败,失败原因:{}",e);
            return ResultUtils.error("公告添加失败");
        }
    }

    /**
    * @Description: 修改公告
    * @Param: [notic]
    * @return: com.jimu.social.interfaces.utils.ResultUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:40
    */
    @PostMapping("/updateNotic")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateNoticForStatus(Notic notic){
        try{
            notic.setModifyDate(DateUtils.getDateByString());
            noticService.updateNotic(notic);
            return ResultUtils.ok("公告状态修改成功");
        } catch (Exception e){
            log.error("公告状态修改失败,失败原因:{}",e);
            return ResultUtils.error("公告状态修改失败");
        }
    }
}
