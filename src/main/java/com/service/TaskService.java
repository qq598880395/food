package com.service;

import cn.hutool.core.io.FileUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * 定时器
 */
@Service
public class TaskService {
    /*
        *  任意时间
        ?  计算值，一般用于日和星期
        -  区间
        /  间隔
     */
   @Scheduled(cron = "0 59 11 * * ?")
//                    秒分 时
    public void clearTmp()
    {
       String path = System.getProperty("ROOT")+"/uploadFile";
        FileUtil.del(path);
    }
}
