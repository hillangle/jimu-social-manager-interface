package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Activity;
import com.jimu.social.interfaces.mapper.ActivityMapper;
import com.jimu.social.interfaces.service.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class ActivityServiceImpl implements IActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public void save(Activity activity) {
        activityMapper.save(activity);
    }

    @Override
    public List<Activity> queryActivityList(Map<String, Object> map) {
        try {
           return activityMapper.queryActivityList(map);
        } catch(Exception e){
            log.error("获取活动列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public List<Activity> queryActivityPage(Map<String, Object> map) {
        try {
           return activityMapper.queryActivityPage(map);
        } catch(Exception e){
            log.error("获取活动列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateActivity(Activity activity) {
        try{
            activityMapper.updateActivity(activity);
            return true;
        }catch(Exception e) {
            log.error("修改活动信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return activityMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计活动数量失败,失败原因{}",e);
            return 0;
        }
    }
}
