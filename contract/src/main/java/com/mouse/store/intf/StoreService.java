package com.mouse.store.intf;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/1/12 9:56 上午
 */
public interface StoreService {

    /**
     * 改变库存的数量
     * @param count
     * @return
     */
    int decr(int count);
}
