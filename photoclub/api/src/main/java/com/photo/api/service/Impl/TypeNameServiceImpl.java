package com.photo.api.service.Impl;

import com.photo.api.service.TypeNameService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.dao.domain.TypeName;
import com.photo.dao.repository.TypeNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeNameServiceImpl implements TypeNameService {
    @Autowired
    private TypeNameMapper typeNameMapper;

    /**
     * 查找所有类被名称
     * @return
     */

    @Override
    public Result selectAllTypeName() {
        List<TypeName> typeNameList = typeNameMapper.selectAllTypeName();
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),typeNameList);
    }
}
