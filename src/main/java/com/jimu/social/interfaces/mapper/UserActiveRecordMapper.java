package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.UserActiveRecord;
import com.jimu.social.interfaces.domain.vo.UserActiveRecordVO;

import java.util.List;
import java.util.Map;

/**
 * @author liangqi
 * @date 2021/5/26 21:40
 */
public interface UserActiveRecordMapper {

    void save(UserActiveRecord record);

    List<UserActiveRecordVO> queryUserActiveRecordList(Map<String, Object> map);

    void updateUserActiveRecord(UserActiveRecord userActiveRecord);

    int count(Map<String, Object> map);

}
