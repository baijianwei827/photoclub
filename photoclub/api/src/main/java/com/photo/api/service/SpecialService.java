package com.photo.api.service;

import com.photo.common.results.Result;
import com.photo.dao.domain.Special;
public interface SpecialService {

    /**
     *添加专辑
     * @param special
     * @return
     */
    Result insertSpecial(Special special);

    /**
     * 删除专辑
     * @param special
     * @return
     */
    Result removeSpecial(Special special);

    /**
     * 修改专辑
     * @param special
     * @return
     */
    
    Result updateSpecial(Special special);

    /**
     * 通过用户ID查找专辑
     * @param u_id
     * @return
     */
    Result selectSpecialByU_id(String u_id,Integer sortType,Integer pageNum,Integer pageSize);

    /**
     * 通过类别、名称查询
     * @param t_id
     * @param name
     * @return
     */
    Result selectSpecialByT_idAndName(Integer t_id,String name,Integer sortType,Integer pageNum,Integer pageSize);

    /**
     * 通过专辑ID查找专辑
     * @param s_id
     * @return
     */
    Result selectSpecialByS_id(String s_id,Integer pageNum,Integer pageSize);

    /**
     * 查询首页置顶专辑
     * @return
     */
    Result selectSpecialRecommend();
}
