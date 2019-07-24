<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/7/22
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css">
<script src="js/layui/layui.js" type="text/javascript" charset="UTF-8"></script>
<style>
    .wrap {
        /* width: 1190px; */
        margin-left: auto;
        margin-right: auto;
    }
    ::-webkit-scrollbar {
        width: 5px; /*对垂直流动条有效*/
        height: 5px; /*对水平流动条有效*/
    }

    /*定义滚动条的轨道颜色、内阴影及圆角*/
    ::-webkit-scrollbar-track{
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color: rosybrown;
        border-radius: 3px;
        display: none;
    }

    /*定义滑块颜色、内阴影及圆角*/
    ::-webkit-scrollbar-thumb{
        border-radius: 7px;
        -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
        background-color: #E8E8E8;
    }

    /*定义两端按钮的样式*/
    ::-webkit-scrollbar-button {

    }
    /*定义右下角汇合处的样式*/
    ::-webkit-scrollbar-corner {

    }
    .layui-upload-img{
        width: 100px;
        height: 100px;
    }
</style>
<body>
<div class="wrap layui-container">
    <div class="layui-bg-red layui-row">
        <div class="layui-col-md8 layui-col-xs8 layui-col-sm8">
            <!-- 返回按钮 -->
            <div class="layui-btn layui-btn-primary">
                返回
            </div>

            <form class="layui-form" method="post" action="${pageContext.request.contextPath}/FoodList/addFoodList">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>菜品添加</legend>
                </fieldset>
                <!-- <button class="layui-btn layui-btn-radius layui-btn-warm">删除菜品</button> -->
                <div class="layui-form-item">
                    <label class="layui-form-label">分类</label>
                    <div class="layui-input-block">
                        <input type="text" name="food_type"  placeholder="请输入菜品分类" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <!-- 菜名 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">菜名</label>
                    <div class="layui-input-block">
                        <input type="text" name="food_name" placeholder="请输入菜名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <!-- 价格 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-block">
                        <input type="text" name="food_price"  placeholder="请输入价格" autocomplete="off" class="layui-input">
                    </div>
                </div>
             <%--图片上传--%>
                <div class="layui-form-item">
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                        <legend>添加图片</legend>
                    </fieldset>
                    <div class="layui-upload">
                        <button type="button" class="layui-btn" id="test2">多图片上传</button>
                        　<!-- 隐藏的input,一个隐藏的input（用于保存文件url） -->
                        　<input type="hidden" id="img_url" name="food_pic" value=""/>
                        <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                            预览图：
                            <div class="layui-upload-list" id="demo2"></div>
                        </blockquote>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">填写描述</label>
                    <div class="layui-input-block">
                        <textarea name="food_details" placeholder="请输入菜品描述" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="*">立即添加</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    sum = 0;
    // 加载layui的表单向
    layui.use('form', function() {
        var form = layui.form;
    });
    //加载文件上传
    layui.use(['upload', 'layer'], function() {
        var $ = layui.jquery,
            upload = layui.upload,
            layer = layui.layer;
        //多图片上传
        upload.render({
            elem: '#test2',
            url: getRootPath()+'/upload',
            multiple: true,
            accept: 'images',
            // auto: false,
            // bindAction:'#test2',
            size: 5000,
            before: function(obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result) {
                    if (sum < 1) {
                        $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img">')
                        sum++;
                    } else {
                        layer.msg('最多只能添加1张图片');
                    }
                });
            },
            done: function(res) {
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
                document.getElementById("img_url").value = res.data.src;
                return layer.msg('上传成功');

            },
        });
    });
    //得到工程路径
    function getRootPath() {
        // http://localhost:8083/uimcardprj/share/meun.jsp
        var curWwwPath = window.document.location.href;
        // uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        // http://localhost:8083
        var localhostPaht = curWwwPath.substring(0, pos);
        // uimcardprj
        var projectName = pathName
            .substring(0, pathName.substr(1).indexOf('/') + 1);
        if (projectName == "/weixin" || projectName == "/admin"  || projectName == "/pc")
            projectName = "";
        return (localhostPaht + projectName);
    }
</script>
</html>

