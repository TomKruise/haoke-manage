package com.tom.haoke.dubbo.server.service;

import com.tom.haoke.dubbo.server.pojo.Ad;
import com.tom.haoke.dubbo.server.vo.PageInfo;

public interface AdService {

    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}