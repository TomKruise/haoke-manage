package com.tom.haoke.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tom.haoke.dubbo.server.pojo.Ad;
import com.tom.haoke.dubbo.server.service.AdService;
import com.tom.haoke.dubbo.server.service.BaseServiceImpl;
import com.tom.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {

    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {
        QueryWrapper queryWrapper = new QueryWrapper();

        // 排序
        queryWrapper.orderByDesc("updated");

        // 查询的条件
        queryWrapper.eq("type", ad.getType());

        IPage iPage = super.queryPageList(queryWrapper, page, pageSize);

        return new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(), page, pageSize, iPage.getRecords());
    }

}
