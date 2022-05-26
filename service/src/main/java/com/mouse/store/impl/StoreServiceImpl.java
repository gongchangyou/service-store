package com.mouse.store.impl;

import com.mouse.store.intf.StoreService;
import com.mouse.store.repository.StoreRepository;
import lombok.val;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/1/13 1:44 下午
 */
@Component
@DubboService(version = "1.0.0", group = "order-demo") //group是小的分类
public class StoreServiceImpl implements StoreService {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StoreRepository storeRepository;

    public int add(int i, int j) {
        Map<String, ProtocolConfig> map = applicationContext.getBeansOfType(ProtocolConfig.class);
        int port = 0;
        for(Map.Entry<String,ProtocolConfig> con: map.entrySet()){
            port = con.getValue().getPort();
        }
        return i + j + port;
    }

    /**
     * 改变库存的数量
     *
     * @param count
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int decr(int count) {
        val store = storeRepository.selectForUpdate();
        store.setCount(store.getCount() - count);
        return storeRepository.updateStore(store);
    }
}
