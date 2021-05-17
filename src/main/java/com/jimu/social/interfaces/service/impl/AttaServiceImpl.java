package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Atta;
import com.jimu.social.interfaces.domain.UserAtta;
import com.jimu.social.interfaces.mapper.AttaMapper;
import com.jimu.social.interfaces.service.IAttaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class AttaServiceImpl implements IAttaService {

    @Autowired
    private AttaMapper attaMapper;

    @Override
    public void save(Atta atta) {
        attaMapper.save(atta);
    }

    @Override
    public void saveUserAtta(UserAtta userAtta) {
        attaMapper.saveUserAtta(userAtta);
    }

    @Override
    public void updateAtta(Map<String, Object> map) {
        attaMapper.updateAtta(map);
    }

    @Override
    public List<Atta> queryAttaByUserId(Map<String, Object> map) {
        return attaMapper.queryAttaByUserId(map);
    }
}
