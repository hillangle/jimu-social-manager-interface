package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.ActivationCode;
import com.jimu.social.interfaces.domain.vo.ActivationCodeVO;

import java.util.List;
import java.util.Map;

public interface IActivationCodeService {

    /**
     * 新增激活码
     * @return
     */
    public void save(ActivationCode activationCode);

    /**
     * 获取激活码分页列表
     * @param map
     * @return Tendency
     */
    List<ActivationCode> queryActivationCodeList(Map<String, Object> map);

    /**
     * 获取激活码分页列表
     * @param map
     * @return Tendency
     */
    List<ActivationCode> queryActivationCodePage(Map<String, Object> map);

    /**
     * 激活码信息修改
     * @param activationCode
     * @return flag
     */
    boolean updateActivationCode(ActivationCode activationCode);

    /**
     * 获取激活码分页列表总数
     * @param map
     * @return ActivationCode
     */
    int count(Map<String, Object> map);

    /**
    * @Description: 根据数组查询激活码列表
    * @Param: [oidArray]
    * @return: java.util.List<com.jimu.social.interfaces.domain.ActivationCode>
    * @Author: liangqi
    * @Date: 2021/5/27 14:20
    */
    List<ActivationCode> queryActivationCodeListByoidArray(String[] oidArray);

    /**
    * @Description: 激活码核销数
    * @Param: [params]
    * @return: java.util.List<java.lang.String>
    * @Author: liangqi
    * @Date: 2021/5/29 11:49
    */
    List<ActivationCodeVO> cancelVerificationList(Map<String, Object> params);

    /**
     * @Description: 根据code获取激活码实体
     * @Param: code
     * @return: com.jimu.social.interfaces.domain.ActivationCode
     * @Author: qwb
     * @Date: 2021/5/29 11:49
     */
    ActivationCode queryActivationCode(String code);
}
