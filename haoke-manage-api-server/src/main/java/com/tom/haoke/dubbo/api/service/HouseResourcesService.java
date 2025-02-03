package com.tom.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tom.haoke.dubbo.server.api.ApiHouseResourcesService;
import com.tom.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {
    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources) {
        int result = apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }
}
