package com.service;

import com.dao.FoodOrderDao;
import com.pojo.Order;
import com.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private FoodOrderDao foodOrderDao;
    //添加订单
    public void orderGeneration(OrderVO vo) {
        Order po = new Order();
        BeanUtils.copyProperties(vo,po);
        int n = foodOrderDao.insert(po);
    }

}
