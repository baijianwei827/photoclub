package com.photo.api.service;

import com.photo.common.results.Result;
import com.photo.dao.domain.Attention;

public interface AttentionService {
    /**
     * 添加关注
     * @param attention
     * @return
     */
    Result insertAttention(Attention attention);

    /**
     * 取消关注
     * @return
     */
    Result removeAttention(Attention attention);

    /**
     * 查找用户下所有关注
     * @param u_id
     * @param type
     * @return
     */
    Result selectAttentionByU_id(String u_id,Integer type);

    /**
     * 查找具体一个关注
     * @param u_id
     * @param by_u_id
     * @return
     */
    Result selectAttentionByU_idBy_id(String u_id,String by_u_id);

    /**
     * 查找粉丝
     * @param u_id
     * @return
     */
    Result selectBeanByU_id(String u_id);

    /**
     * 查找用户关注的专辑(待定)
     * @param u_id
     * @return
     */
    Result selectAttentionSpecailByU_id(String u_id);


}
