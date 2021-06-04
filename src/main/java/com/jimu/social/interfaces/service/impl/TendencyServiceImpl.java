package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Discuss;
import com.jimu.social.interfaces.domain.Tendency;
import com.jimu.social.interfaces.domain.TendencyUserZan;
import com.jimu.social.interfaces.mapper.TendencyMapper;
import com.jimu.social.interfaces.service.ITendencyService;
import com.jimu.social.interfaces.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class TendencyServiceImpl implements ITendencyService {
    @Autowired
    private TendencyMapper tendencyMapper;

    @Override
    public boolean save(Map<String, Object> map) {
        try{
            map.put("userId",map.get("userId").toString());
            map.put("createDate", DateUtils.getDateByString());
            tendencyMapper.save(map);
            return true;
        }catch(Exception e) {
            log.error("添加动态信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public boolean saveZan(TendencyUserZan tendencyUserZan) {
        try{
            tendencyUserZan.setCreateDate(DateUtils.getDateByString());
            tendencyMapper.saveZan(tendencyUserZan);
            return true;
        }catch(Exception e) {
            log.error("添加赞态信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public boolean savePl(Discuss discuss) {
        try{
            discuss.setCreateDate(DateUtils.getDateByString());
            tendencyMapper.savePl(discuss);
            return true;
        }catch(Exception e) {
            log.error("添加赞态信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public List<Tendency> queryTendencyList(Map<String, Object> map) {
        try {
           return tendencyMapper.queryAllTendencyList(map);
        } catch(Exception e){
            log.error("获取动态列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public List<Tendency> queryTendencyPage(Map<String, Object> map) {
        try {
           return tendencyMapper.queryTendencyPage(map);
        } catch(Exception e){
            log.error("获取动态列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public TendencyUserZan queryZanByUserId(Map<String, Object> map) {
        try {
           return tendencyMapper.queryZanByUserId(map);
        } catch(Exception e){
            log.error("获取点赞历史失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public List<Tendency> queryAllTendencyList(Map<String, Object> map) {
        try {
           return tendencyMapper.queryAllTendencyList(map);
        } catch(Exception e){
            log.error("获取动态列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateTendency(Tendency tendency) {
        try{
            tendencyMapper.updateTendency(tendency);
            return true;
        }catch(Exception e) {
            log.error("修改动态信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public boolean updateZan(TendencyUserZan tendencyUserZan) {
        try{
            tendencyMapper.updateZan(tendencyUserZan);
            return true;
        }catch(Exception e) {
            log.error("修改赞状态失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return tendencyMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计动态数量失败,失败原因{}",e);
            return 0;
        }
    }
}
