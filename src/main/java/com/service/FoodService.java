package com.service;

import com.dao.FoodListDao;
import com.pojo.VipList;
import com.vo.FoodVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodListDao foodListDao;

    //   添加菜品
    public int addFoodList(FoodVO vo) {
//      vo转po
        VipList po = new VipList();
        BeanUtils.copyProperties(vo, po);
        int n = foodListDao.insert(po);
        return n;
    }

}
