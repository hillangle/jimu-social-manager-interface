package com.jimu.social.interfaces.controller.sys;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jimu.social.interfaces.domain.ActivationCode;
import com.jimu.social.interfaces.service.IActivationCodeService;
import com.jimu.social.interfaces.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
* @Description: 激活码接口
* @Param: 
* @return: 
* @Author: liangqi
*/
@RestController
@RequestMapping("/sys/activationCode")
@Slf4j
public class ActivationCodeController {
    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
    @Autowired
    private IActivationCodeService activationCodeService;

    /**激活码列表
    * @Description: 
    * @Param: [params]
    * @return: com.jimu.social.interfaces.utils.PageUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:39
    */
    @GetMapping("/getActivationCodeList")
    @ResponseBody
    public PageUtils getActivationCodeList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<ActivationCode> activationCodeList = activationCodeService.queryActivationCodeList(query);
        int total = activationCodeService.count(query);
        PageUtils pageUtils = new PageUtils(activationCodeList,total);
        return pageUtils;
    }

    /**
    * @Description: 添加激活码
    * @Param: [activationCode]
    * @return: com.jimu.social.interfaces.utils.ResultUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:39
    */
    @PostMapping("/addActivationCode")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils addActivationCode(ActivationCode activationCode, int num){
        try{
            activationCode.setCreateDate(DateUtils.getDateByString());
            activationCode.setModifyDate(DateUtils.getDateByString());
            for (int i=0; i<num; i++) {
                activationCode.setCode(randomCode(12));
                activationCodeService.save(activationCode);
            }
            return ResultUtils.ok("激活码添加成功");
        } catch (Exception e){
            log.error("激活码添加失败,失败原因:{}",e);
            return ResultUtils.error("激活码添加失败");
        }
    }

    /**
    * @Description: 修改激活码
    * @Param: [activationCode]
    * @return: com.jimu.social.interfaces.utils.ResultUtils
    * @Author: liangqi
    * @Date: 2021/5/26 0:40
    */
    @PostMapping("/updateActivationCode")
    @PreAuthorize("hasRole('SYSUSER')")
    public ResultUtils updateActivationCodeForStatus(ActivationCode activationCode){
        try{
            activationCode.setModifyDate(DateUtils.getDateByString());
            activationCodeService.updateActivationCode(activationCode);
            return ResultUtils.ok("激活码状态修改成功");
        } catch (Exception e){
            log.error("激活码状态修改失败,失败原因:{}",e);
            return ResultUtils.error("激活码状态修改失败");
        }
    }
    
    @GetMapping("/exportActivationCode")
    @PreAuthorize("hasRole('SYSUSER')")
    public void exportActivationCode(HttpServletResponse response, String unids){
        try{
            List<ActivationCode> activationCodeList;
            //不为空，导出所选   为空导出全部未导出状态的
            if (StringUtils.isNotEmpty(unids)) {
                String[] oidArray = unids.split(",");
                activationCodeList = activationCodeService.queryActivationCodeListByoidArray(oidArray);
            } else {
                activationCodeList = activationCodeService.queryActivationCodeListByoidArray(null);
            }
            JSONArray jsonArray = JsonUtil.objToJSONArray(activationCodeList);
            if (jsonArray != null) {
                String title = "激活码列表";
                String[] rowsName = new String[] { "序号", "激活码", "状态" };
                List<Object[]> dataList = new ArrayList<Object[]>();
                Object[] objs = null;
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObj = JsonUtil.objToJSONObject(jsonArray.get(i));

                    objs = new Object[rowsName.length];
                    objs[0] = i + 1;
                    if (!StrUtil.isBlank(jsonObj.getString("code"))) {
                        objs[1] = jsonObj.getString("code");
                    } else {
                        objs[1] = "--";
                    }
                    if (!StrUtil.isBlank(jsonObj.getString("status"))) {
                        if ("0".equals(jsonObj.getString("status"))) {
                            objs[2] = "未导出";
                        } else if ("1".equals(jsonObj.getString("status"))) {
                            objs[2] = "未激活";
                        } else if ("2".equals(jsonObj.getString("status"))) {
                            objs[2] = "已激活";
                        }
                    } else {
                        objs[2] = "--";
                    }
                    dataList.add(objs);
                }
                ExportExcelUtil ex = new ExportExcelUtil();
                ex.export(response, title, rowsName, dataList);
            }
            
        } catch (Exception e){
            log.error("激活码导出失败,失败原因:{}",e);
            
        }
    }
    
    public String randomCode(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(LETTERCHAR.length())));
        }
        return sb.toString();
    }
}
