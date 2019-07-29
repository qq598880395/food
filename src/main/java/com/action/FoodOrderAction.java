package com.action;

import com.service.OrderService;
import com.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RequestMapping("/Order")
@Controller
public class FoodOrderAction {
   @Autowired
    private OrderService orderService;
//订单生成
@RequestMapping("/orderGeneration")
@ResponseBody
    public String orderGeneration(OrderVO vo){
       String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
       String uuid = UUID.randomUUID().toString();
       String order= uuid.replaceAll("-","");
       vo.setOrder_time(date);
       vo.setFood_order_id(order);
       orderService.orderGeneration(vo);
        return "success";
    }

//订单删除
    @RequestMapping("/orderDelete")
    @ResponseBody
    public  String orderDelete(OrderVO vo){
        return "success";
    }

}
