package com.tom.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tom.haoke.dubbo.api.vo.Pagination;
import com.tom.haoke.dubbo.api.vo.TableResult;
import com.tom.haoke.dubbo.server.api.ApiHouseResourcesService;
import com.tom.haoke.dubbo.server.pojo.HouseResources;
import com.tom.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {
    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources) {
        int result = apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

    public TableResult<HouseResources> queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.
                queryHouseResourcesList(currentPage, pageSize, houseResources);
        return new TableResult<>(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

    /**
     * 根据id查询房源数据
     *
     * @param id
     * @return
     */
    public HouseResources queryHouseResourcesById(Long id){
        // 调用dubbo中的服务进行查询数据
        return this.apiHouseResourcesService.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return apiHouseResourcesService.update(houseResources);
    }
}
