package com.jimu.social.interfaces.controller.sys;

import cn.hutool.json.JSONObject;
import com.jimu.social.interfaces.domain.Notic;
import com.jimu.social.interfaces.domain.UserLoginLog;
import com.jimu.social.interfaces.domain.vo.ActivationCodeVO;
import com.jimu.social.interfaces.service.*;
import com.jimu.social.interfaces.utils.PageUtils;
import com.jimu.social.interfaces.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @Description: 统计接口
*/
@RestController
@RequestMapping("/sys/statistical")
@Slf4j
public class StatisticalController {

    @Autowired
    private INoticService noticService;
    
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ITendencyService tendencyService;
    
    @Autowired
    private IActivationCodeService activationCodeService;
    
    @Autowired
    private IUserLoginLogService userLoginLogService;
    
    @Autowired
    private ISocialService socialService;

    /**新增用户数
    * @Description: 
    * @Param: [params]
    */
    @GetMapping("/getNewUserNum")
    @ResponseBody
    public Integer getNewUserNum(@RequestParam Map<String,Object> params){
        int newUserNum = sysUserService.count(params);
        return newUserNum;
    }

    /**新增动态数
    * @Description: 
    * @Param: [params]
    */
    @GetMapping("/getNewTendencyNum")
    @ResponseBody
    public Integer getNewTendencyNum(@RequestParam Map<String,Object> params){
        int newNum = tendencyService.count(params);
        return newNum;
    }

    /**激活码核销数
    * @Description: 
    * @Param: [params]
    */
    @GetMapping("/getActivationList")
    @ResponseBody
    public JSONObject getActivationList(@RequestParam Map<String,Object> params){

        List<String> createDate = new ArrayList<String>();
        List<String> status0 = new ArrayList<String>();
        List<String> status1 = new ArrayList<String>();
        List<String> status2 = new ArrayList<String>();
        JSONObject jsonObject = new JSONObject();
        try{

            List<ActivationCodeVO> list = activationCodeService.cancelVerificationList(params);
            list.forEach(l->
            {
                createDate.add(l.getCreateDate());
                status0.add(l.getStatus0());
                status1.add(l.getStatus1());
                status2.add(l.getStatus2());
            });
        } catch (Exception e) {
            log.error("查询激活码核销失败:{}",e);
        }
        jsonObject.put("createDate", createDate);
        jsonObject.put("status0", status0);
        jsonObject.put("status1", status1);
        jsonObject.put("status2", status2);
        return jsonObject;
    }

    /**
    * 公告列表
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

    /**用户登录统计
     * @Description:
     * @Param: [params]
     */
    @GetMapping("/getUserLoginLogList")
    @ResponseBody
    public JSONObject getUserLoginLogList(@RequestParam Map<String,Object> params){

        List<String> createDate = new ArrayList<String>();
        List<String> num = new ArrayList<String>();
        JSONObject jsonObject = new JSONObject();
        try{

            List<Map<String, Object>> list = userLoginLogService.selectUserLoginLogList(params);
            list.forEach(l->
            {
                createDate.add(l.get("createDate").toString());
                num.add(l.get("num").toString());
            });
        } catch (Exception e) {
            log.error("查询激活码核销失败:{}",e);
        }
        jsonObject.put("createDate", createDate);
        jsonObject.put("num", num);
        return jsonObject;
    }
    
    /**平台收藏统计
     * @Description:
     * @Param: [params]
     */
    @GetMapping("/getUserSocialList")
    @ResponseBody
    public JSONObject getUserSocialList(@RequestParam Map<String,Object> params){

        List<String> name = new ArrayList<String>();
        List<String> num = new ArrayList<String>();
        JSONObject jsonObject = new JSONObject();
        try{

            List<Map<String, Object>> list = socialService.selectUserSocialList(params);
            list.forEach(l->
            {
                name.add(l.get("name").toString());
                num.add(l.get("num").toString());
            });
        } catch (Exception e) {
            log.error("查询激活码核销失败:{}",e);
        }
        jsonObject.put("name", name);
        jsonObject.put("num", num);
        return jsonObject;
    }
    
    
}
