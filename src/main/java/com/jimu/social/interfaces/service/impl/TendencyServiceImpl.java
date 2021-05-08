package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Tendency;
import com.jimu.social.interfaces.mapper.TendencyMapper;
import com.jimu.social.interfaces.service.ITendencyService;
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
    public void save(Tendency tendency) {
        tendencyMapper.save(tendency);
    }

    @Override
    public List<Tendency> queryTendencyList(Map<String, Object> map) {
        try {
           return tendencyMapper.queryTendencyList(map);
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
    public int count(Map<String, Object> map) {
        try{
            return tendencyMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计动态数量失败,失败原因{}",e);
            return 0;
        }
    }
}
