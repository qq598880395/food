package com.action;

import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@Controller
public class UploadAction {
//    HttpServletRequest servletRequest
    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file, HttpServletRequest servletRequest)
            throws IOException {
        //如果文件内容不为空，则写入上传路径
        //String str = "";
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //上传文件路径
        String path = servletRequest.getServletContext().getRealPath("/uploadFile");

        System.out.println("文件名称"+file.getOriginalFilename());
        //上传文件名
        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        String fileName = hash + suffixName;
        File filepath = new File(path, fileName);
        System.out.println("随机数文件名称"+filepath.getName());
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);

        resUrl.put("src", tempFile.getPath());
        res.put("code", 0);
        res.put("msg", "");
        res.put("data", resUrl);
        //str = "{\"code\": 0,\"msg\": \"上传成功\",\"data\": {\"src\":\""+path+fileName + "\"}}";
        System.out.println("res里面的值：");
        System.out.println(res.toString());
        return res;
    }

}











