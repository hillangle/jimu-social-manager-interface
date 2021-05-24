package com.jimu.social.interfaces.controller.app;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jimu.social.interfaces.domain.*;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.service.IAttaService;
import com.jimu.social.interfaces.service.ITendencyService;
import com.jimu.social.interfaces.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/tendency")
@Slf4j
public class TendencyController {

    @Autowired
    private IAttaService attaService;

    @Autowired
    private ITendencyService tendencyService;

    @PostMapping(value = "/getTendencyList", consumes = "application/json")
    public String getTendencyList(HttpServletRequest request){
        log.info("开始获取动态信息");
        Result result = new Result();
        Map<String, Object> map = new HashMap<>();
        map.put("status","0");
        try {
            List tendencys = tendencyService.queryAllTendencyList(map);
                result.setResultCode("true");
                result.setResultData(JSONUtil.toJsonStr(JSONUtil.toJsonStr(tendencys).replace("\"", "\\\"")));
                result.setResultMsg("动态查询成功");
                result.setHttpCode(200);
                log.info("获取动态信息成功");
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("动态查询失败");
            result.setHttpCode(200);
            log.error("获取动态信息失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/addTendency", consumes = "application/json")
    public String addTendency(@RequestBody Map<String,Object> map, HttpServletRequest request){
        log.info("开始发布动态信息");
        Result result = new Result();
        map.put("status","0");
        try {
            boolean flag = tendencyService.save(map);
            if(flag){
                JSONArray imagesJson = JSONUtil.parseArray(map.get("images"));
                JSONObject img;
                TendencyAtta tendencyAtta = new TendencyAtta();
                Atta atta = new Atta();
                for(Object image : imagesJson){
                    img = JSONUtil.parseObj(image);
                    atta.setAttaType(img.get("attaType").toString());
                    atta.setAttaName(img.get("attaName").toString());
                    atta.setAttaPath(img.get("attaPath").toString());
                    atta.setStatus("0");
                    atta.setCreateDate(DateUtils.getDateByString());
                    attaService.save(atta);
                    tendencyAtta.setAttaId(atta.getAttaUnid());
                    tendencyAtta.setTendencyId(map.get("unid").toString());
                    tendencyAtta.setStatus("0");
                    tendencyAtta.setCreateDate(DateUtils.getDateByString());
                    attaService.saveTendencyAtta(tendencyAtta);
                }
                result.setResultCode("true");
                result.setResultData(JSONUtil.toJsonStr(tendencyAtta).toString().replace("\"", "\\\""));
                result.setResultMsg("动态发布成功");
                result.setHttpCode(200);
                log.info("动态发布成功");
            }else{
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("动态发布失败");
                result.setHttpCode(200);
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("动态发布失败");
            result.setHttpCode(200);
            log.error("动态发布失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/zan", consumes = "application/json")
    public String zan(@RequestBody Map<String,Object> map, HttpServletRequest request){
        log.info("开始点赞操作");
        Result result = new Result();
        boolean flag = false;
        TendencyUserZan zan = null;
        try {
            zan = tendencyService.queryZanByUserId(map);
            if(zan != null && !"".equals(zan.getUnid())){
                zan.setStatus(map.get("status").toString());
                flag = tendencyService.updateZan(zan);
                if(flag) {
                    result.setResultCode("true");
                    result.setResultData(JSONUtil.toJsonStr(zan).toString().replace("\"", "\\\""));
                    result.setResultMsg("赞状态修改成功");
                    result.setHttpCode(200);
                    log.info("赞状态修改成功");
                }else {
                    result.setResultCode("false");
                    result.setResultData(null);
                    result.setResultMsg("赞状态修改失败");
                    result.setHttpCode(200);
                }
            }else{
                zan = new TendencyUserZan();
                zan.setTendencyId(map.get("tendencyId").toString());
                zan.setUserId(map.get("userId").toString());
                zan.setStatus(map.get("status").toString());
                flag = tendencyService.saveZan(zan);
                if(flag) {
                    result.setResultCode("true");
                    result.setResultData(JSONUtil.toJsonStr(zan).toString().replace("\"", "\\\""));
                    result.setResultMsg("赞添加成功");
                    result.setHttpCode(200);
                    log.info("赞添加成功");
                }else {
                    result.setResultCode("false");
                    result.setResultData(null);
                    result.setResultMsg("赞添加失败");
                    result.setHttpCode(200);
                }
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("点赞失败");
            result.setHttpCode(200);
            log.error("点赞失败",e);
        }
        return result.toJSONString();
    }

    @PostMapping(value = "/pl", consumes = "application/json")
    public String pl(@RequestBody Discuss discuss, HttpServletRequest request){
        log.info("开始评论操作");
        Result result = new Result();
        boolean flag = false;
        try {
            discuss.setStatus("0");
            flag = tendencyService.savePl(discuss);
            if(flag) {
                result.setResultCode("true");
                result.setResultData(JSONUtil.toJsonStr(discuss).toString().replace("\"", "\\\""));
                result.setResultMsg("赞状态修改成功");
                result.setHttpCode(200);
                log.info("赞状态修改成功");
            }else {
                result.setResultCode("false");
                result.setResultData(null);
                result.setResultMsg("赞状态修改失败");
                result.setHttpCode(200);
            }
        } catch(Exception e){
            result.setResultCode("false");
            result.setResultData(null);
            result.setResultMsg("动态发布失败");
            result.setHttpCode(200);
            log.error("动态发布失败",e);
        }
        return result.toJSONString();
    }
}
