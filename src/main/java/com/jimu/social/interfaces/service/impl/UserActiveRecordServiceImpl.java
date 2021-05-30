package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.UserActiveRecord;
import com.jimu.social.interfaces.domain.vo.UserActiveRecordVO;
import com.jimu.social.interfaces.mapper.UserActiveRecordMapper;
import com.jimu.social.interfaces.service.IUserActiveRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class UserActiveRecordServiceImpl implements IUserActiveRecordService {
    @Autowired
    private UserActiveRecordMapper userActiveRecordMapper;

    @Override
    public void save(UserActiveRecord userActiveRecord) {
        userActiveRecordMapper.save(userActiveRecord);
    }

    @Override
    public List<UserActiveRecordVO> queryUserActiveRecordList(Map<String, Object> map) {
        try {
           return userActiveRecordMapper.queryUserActiveRecordList(map);
        } catch(Exception e){
            log.error("获取公告列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateUserActiveRecord(UserActiveRecord userActiveRecord) {
        try{
            userActiveRecordMapper.updateUserActiveRecord(userActiveRecord);
            return true;
        }catch(Exception e) {
            log.error("修改公告信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return userActiveRecordMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计公告数量失败,失败原因{}",e);
            return 0;
        }
    }
}
