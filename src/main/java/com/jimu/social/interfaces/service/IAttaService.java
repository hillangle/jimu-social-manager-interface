package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.Atta;

import java.util.List;
import java.util.Map;

public interface IAttaService {
    /**
     * 文件上传
     * @return unid
     */
    public void save(Map<String, Object> map);

    /**
     * 用户文件关联
     */
    public void saveUserAtta(Map<String, Object> map);

    /**
     * 修改附件
     */
    public void updateAtta(Map<String, Object> map);

    /**
     * 根据用户id查询关联附件
     */
    public List<Atta> queryAttaByUserId(Map<String, Object> map);
}
