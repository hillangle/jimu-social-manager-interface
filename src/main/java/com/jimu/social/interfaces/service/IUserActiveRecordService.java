package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.UserActiveRecord;
import com.jimu.social.interfaces.domain.vo.UserActiveRecordVO;

import java.util.List;
import java.util.Map;

public interface IUserActiveRecordService {

    /**
     * 新增激活码
     * @return
     */
    public void save(UserActiveRecord userActiveRecord);

    /**
     * 获取激活码分页列表
     * @param map
     * @return Tendency
     */
    List<UserActiveRecordVO> queryUserActiveRecordList(Map<String, Object> map);

    /**
     * 激活码信息修改
     * @param userActiveRecord
     * @return flag
     */
    boolean updateUserActiveRecord(UserActiveRecord userActiveRecord);

    /**
     * 获取激活码分页列表总数
     * @param map
     * @return UserActiveRecord
     */
    int count(Map<String, Object> map);

}
