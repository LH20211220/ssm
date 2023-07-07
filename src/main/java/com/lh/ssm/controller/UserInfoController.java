package com.lh.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.lh.ssm.pojo.User;
import com.lh.ssm.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/user")
@RestController
@Api(tags = "示例API")
public class UserInfoController {
    //获取到UserInfoService
    @Autowired
    private UserInfoService userInfoService;

    //Get请求
    @GetMapping("/query")
    //@ResponseBody 注释后表示放回的是字符串
    @ResponseBody
    @ApiOperation("查询全部用户")
    public String queryAll() {
        List<User> userInfoList = userInfoService.queryAll();
        return JSON.toJSONString(userInfoList);
    }

    //使用了RestFull风格
    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation("按照id查询用户")
    public String query(@PathVariable(value = "id") Integer id) {
        User userInfo = userInfoService.queryById(id);
        List<User> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        return JSON.toJSONString(userInfoList);
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/add")
    @ResponseBody
    @ApiOperation("添加用户")
    public String add(@RequestBody User userInfo) {
        userInfoService.add(userInfo);
        return "添加OK";
    }

    //Delete请求
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation("按照id删除用户")
    public String delete(@PathVariable("id") Integer id) {
        userInfoService.delete(id);
        return "删除成功";
    }

    //Put请求
    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation("按照id更新用户")
    public String update(@PathVariable("id") Integer id, @RequestBody User userInfo) {
        userInfo.setId(id);
        userInfoService.update(userInfo);
        return "修改成功";
    }
}
