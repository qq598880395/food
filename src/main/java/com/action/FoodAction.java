package com.action;

import cn.hutool.core.io.FileUtil;
import com.service.FoodService;
import com.vo.FoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@RequestMapping("/FoodList")
@Controller
public class FoodAction {

    @Autowired
   private FoodService foodService;
//添加菜品
   @PostMapping("/addFoodList")
    @ResponseBody
    public String addFoodList(FoodVO vo, String image) {
       //image="/tmp/123456.jpg
        System.out.println("image:" + image);
        String srcPath =  image;//从哪里复制
        String desPath = System.getProperty("ROOT") + "/images";// 制到哪里
        System.out.println("src:" + srcPath);
        System.out.println("des:" + desPath);

        File desPathFile = new File(desPath);
        if (desPathFile.exists() == false) {
            desPathFile.mkdir();
        }

        //复制文件
        FileUtil.copy(srcPath, desPath, true);
        String newPath = "/images" + image.substring(4);
        vo.setFood_pic(newPath);
//数据库操作
        foodService.addFoodList(vo);
        return "success";
    }

}