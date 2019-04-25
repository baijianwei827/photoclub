package com.photo.dao.repository;

import com.photo.dao.domain.TypeName;

import java.util.List;

public interface TypeNameMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(Integer t_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(TypeName record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(TypeName record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    TypeName selectByPrimaryKey(Integer t_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(TypeName record);

    /**
     * 查找所有类别名称
     * @return
     */
    List<TypeName> selectAllTypeName();

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(TypeName record);
}