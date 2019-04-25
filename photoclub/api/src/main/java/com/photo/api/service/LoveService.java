package com.photo.api.service;

import com.photo.common.results.Result;
import com.photo.dao.domain.Love;

public interface LoveService {
    /**
     * 点赞
     * @param love
     * @return
     */
    Result insertLove(Love love);


    /**
     * 取消点赞
     * @param love
     * @return
     */
    Result removeLove(Love love);

}
