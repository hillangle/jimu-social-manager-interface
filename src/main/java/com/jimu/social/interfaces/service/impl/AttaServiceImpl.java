package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Atta;
import com.jimu.social.interfaces.mapper.AttaMapper;
import com.jimu.social.interfaces.service.IAttaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class AttaServiceImpl implements IAttaService {

    @Autowired
    private AttaMapper attaMapper;

    @Override
    public void save(Map<String, Object> map) {
        attaMapper.save(map);
    }

    @Override
    public void saveUserAtta(Map<String, Object> map) {
        attaMapper.saveUserAtta(map);
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
