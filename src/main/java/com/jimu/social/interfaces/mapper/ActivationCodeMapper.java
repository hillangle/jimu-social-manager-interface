package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.ActivationCode;
import com.jimu.social.interfaces.domain.vo.ActivationCodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author liangqi
 * @date 2021/5/26 21:40
 */
public interface ActivationCodeMapper {

    void save(ActivationCode record);

    List<ActivationCode> queryActivationCodeList(Map<String, Object> map);

    List<ActivationCode> queryActivationCodePage(Map<String, Object> map);

    void updateActivationCode(ActivationCode activationCode);

    int count(Map<String, Object> map);

    List<ActivationCode> queryActivationCodeListByoidArray(@Param("oidArray") String[] oidArray);

    List<ActivationCodeVO> cancelVerificationList(Map<String, Object> map);

    ActivationCode queryActivationCode(String code);
}
