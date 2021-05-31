package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Social;
import com.jimu.social.interfaces.domain.UserSocial;
import com.jimu.social.interfaces.mapper.SocialMapper;
import com.jimu.social.interfaces.service.ISocialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class SocialServiceImpl implements ISocialService {
    @Autowired
    private SocialMapper socialMapper;

    @Override
    public void save(Social social) {
        socialMapper.save(social);
    }

    @Override
    public void saveUserSocial(UserSocial userSocial) {
        socialMapper.saveUserSocial(userSocial);
    }

    @Override
    public List<Social> querySocialList(Map<String, Object> map) {
        try {
           return socialMapper.querySocialList(map);
        } catch(Exception e){
            log.error("获取社交平台列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public List<Social> queryUserSocial(Map<String, Object> map) {
        try {
            return socialMapper.queryUserSocial(map);
        } catch(Exception e){
            log.error("获取社交平台列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateSocial(Social social) {
        try{
            socialMapper.updateSocial(social);
            return true;
        }catch(Exception e) {
            log.error("修改社交平台信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public boolean updateUserSocial(UserSocial userSocial) {
        try{
            socialMapper.updateUserSocial(userSocial);
            return true;
        }catch(Exception e) {
            log.error("修改社交平台信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return socialMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计社交平台数量失败,失败原因{}",e);
            return 0;
        }
    }

    @Override
    public List<Map<String, Object>> selectUserSocialList(Map<String, Object> params) {
        return socialMapper.selectUserSocialList(params);
    }
}
