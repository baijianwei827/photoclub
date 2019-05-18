package com.zw.admin.service.Impl;

import com.photo.common.results.Result;
import com.photo.common.tools.MapUtil;
import com.zw.admin.service.adminService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class adminServiceImpl implements adminService {
    @Override
    public Result login(Map map) {
        String account = (String) map.get("account");
        String password = (String) map.get("password");

        return null;
    }
}
