package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.ActivationCode;
import com.jimu.social.interfaces.mapper.ActivationCodeMapper;
import com.jimu.social.interfaces.service.IActivationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class ActivationCodeServiceImpl implements IActivationCodeService {
    @Autowired
    private ActivationCodeMapper activationCodeMapper;

    @Override
    public void save(ActivationCode activationCode) {
        activationCodeMapper.save(activationCode);
    }

    @Override
    public List<ActivationCode> queryActivationCodeList(Map<String, Object> map) {
        try {
           return activationCodeMapper.queryActivationCodeList(map);
        } catch(Exception e){
            log.error("获取公告列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateActivationCode(ActivationCode activationCode) {
        try{
            activationCodeMapper.updateActivationCode(activationCode);
            return true;
        }catch(Exception e) {
            log.error("修改公告信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return activationCodeMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计公告数量失败,失败原因{}",e);
            return 0;
        }
    }

    @Override
    public List<ActivationCode> queryActivationCodeListByoidArray(String[] oidArray) {
        return activationCodeMapper.queryActivationCodeListByoidArray(oidArray);
    }
}
