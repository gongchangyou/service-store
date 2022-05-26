package com.mouse.store.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mouse.store.repository.db.mapper.StoreMapper;
import com.mouse.store.repository.db.model.Store;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2021/11/17 8:37 下午
 */
@Component
public class StoreRepository {
    @Autowired
    private StoreMapper storeMapper;


    public int updateStore(Store store) {
        return storeMapper.updateById(store);
    }

    public Store selectForUpdate() {
        return storeMapper.selectOne(new LambdaQueryWrapper<Store>()
            .eq(com.mouse.store.repository.db.model.Store::getId, 1L)
            .last(" for update"));
    }



}
