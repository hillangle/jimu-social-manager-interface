package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Notic;
import com.jimu.social.interfaces.mapper.NoticMapper;
import com.jimu.social.interfaces.service.INoticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class NoticServiceImpl implements INoticService {
    @Autowired
    private NoticMapper noticMapper;

    @Override
    public void save(Notic notic) {
        noticMapper.save(notic);
    }

    @Override
    public List<Notic> queryNoticList(Map<String, Object> map) {
        try {
           return noticMapper.queryNoticList(map);
        } catch(Exception e){
            log.error("获取公告列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateNotic(Notic notic) {
        try{
            noticMapper.updateNotic(notic);
            return true;
        }catch(Exception e) {
            log.error("修改公告信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return noticMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计公告数量失败,失败原因{}",e);
            return 0;
        }
    }
}
