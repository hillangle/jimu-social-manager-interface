package com.jimu.social.interfaces.controller.sys;

import com.jimu.social.interfaces.domain.UserActiveRecord;
import com.jimu.social.interfaces.domain.vo.UserActiveRecordVO;
import com.jimu.social.interfaces.service.IUserActiveRecordService;
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
* @Description: 用户活动记录接口
* @Param: 
* @return: 
* @Author: liangqi
*/
@RestController
@RequestMapping("/sys/userActiveRecord")
@Slf4j
public class SysUserActiveRecordController {
	
    @Autowired
    private IUserActiveRecordService userActiveRecordService;

    /**用户活动记录列表
    * @Description: 
    * @Param: [params]
    * @return: com.jimu.social.interfaces.utils.PageUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:39
    */
    @GetMapping("/getUserActiveRecordList")
    @ResponseBody
    public PageUtils getUserActiveRecordList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<UserActiveRecordVO> userActiveRecordList = userActiveRecordService.queryUserActiveRecordList(query);
        int total = userActiveRecordService.count(query);
        PageUtils pageUtils = new PageUtils(userActiveRecordList,total);
        return pageUtils;
    }

    /**
    * @Description: 添加用户活动记录
    * @Param: [userActiveRecord]
    * @return: com.jimu.social.interfaces.utils.ResultUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:39
    */
    @PostMapping("/addUserActiveRecord")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils addUserActiveRecord(UserActiveRecord userActiveRecord){
        try{
            userActiveRecord.setCreateDate(DateUtils.getDateByString());
            userActiveRecord.setModifyDate(DateUtils.getDateByString());
            userActiveRecord.setStatus("0");
            userActiveRecordService.save(userActiveRecord);
            return ResultUtils.ok("用户活动记录添加成功");
        } catch (Exception e){
            log.error("用户活动记录添加失败,失败原因:{}",e);
            return ResultUtils.error("用户活动记录添加失败");
        }
    }

    /**
    * @Description: 修改用户活动记录
    * @Param: [userActiveRecord]
    * @return: com.jimu.social.interfaces.utils.ResultUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:40
    */
    @PostMapping("/updateUserActiveRecord")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateUserActiveRecordForStatus(UserActiveRecord userActiveRecord){
        try{
            userActiveRecord.setModifyDate(DateUtils.getDateByString());
            userActiveRecordService.updateUserActiveRecord(userActiveRecord);
            return ResultUtils.ok("用户活动记录状态修改成功");
        } catch (Exception e){
            log.error("用户活动记录状态修改失败,失败原因:{}",e);
            return ResultUtils.error("用户活动记录状态修改失败");
        }
    }
}
 
