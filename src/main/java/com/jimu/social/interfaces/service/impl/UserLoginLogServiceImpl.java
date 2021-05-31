package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.UserLoginLog;
import com.jimu.social.interfaces.mapper.UserLoginLogMapper;
import com.jimu.social.interfaces.service.IUserLoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class UserLoginLogServiceImpl implements IUserLoginLogService {
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public void save(UserLoginLog userLoginLog) {
        userLoginLogMapper.save(userLoginLog);
    }

    @Override
    public List<UserLoginLog> queryUserLoginLogList(Map<String, Object> map) {
        try {
           return userLoginLogMapper.queryUserLoginLogList(map);
        } catch(Exception e){
            log.error("获取公告列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return userLoginLogMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计公告数量失败,失败原因{}",e);
            return 0;
        }
    }

    @Override
    public List<Map<String, Object>> selectUserLoginLogList(Map<String, Object> map) {
        return userLoginLogMapper.selectUserLoginLogList(map);
    }
}
