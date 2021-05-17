package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.Atta;
import com.jimu.social.interfaces.domain.UserAtta;

import java.util.List;
import java.util.Map;

public interface IAttaService {
    /**
     * 文件上传
     * @return unid
     */
    public void save(Atta atta);

    /**
     * 用户文件关联
     */
    public void saveUserAtta(UserAtta userAtta);

    /**
     * 修改附件
     */
    public void updateAtta(Map<String, Object> map);

    /**
     * 根据用户id查询关联附件
     */
    public List<Atta> queryAttaByUserId(Map<String, Object> map);
}
