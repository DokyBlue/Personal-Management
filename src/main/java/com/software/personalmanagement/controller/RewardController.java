package com.software.personalmanagement.controller;

import com.software.personalmanagement.entity.Reward;
import com.software.personalmanagement.service.RewardService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @RequestMapping("/rewardlist")
    @ResponseBody
    public DataVO rewardlist(Integer page, Integer limit){
        return rewardService.RewardList(page, limit);
    }

    //新增数据
    @PostMapping("/addReward")
    @ResponseBody
    public void insert(@RequestBody HashMap<String, String> map){
        Integer departmentId = Integer.valueOf(map.get("department"));
        String name = map.get("name");
        String theme = map.get("theme");
        Double price = Double.valueOf(map.get("price"));
        String message = map.get("message");
        String department;

        switch (departmentId){
            case 1: department="管理部";break;
            case 2: department="财务部";break;
            case 3: department="测试部";break;
            case 4: department="人事部";break;
            case 5: department="行政部";break;
            case 6: department="宣传部";break;
            default: department=null;
        }

        Reward reward = new Reward();
        reward.setDepartment(department);
        reward.setName(name);
        reward.setPrice(price);
        reward.setMessage(message);
        reward.setTheme(theme);
        reward.setStatus(1);
        rewardService.insertReward(reward);
    }

    //删除数据
    @DeleteMapping("/deleteReward/{id}")
    public void delete(@PathVariable Integer id){
        rewardService.delete(id);
    }

    //根据姓名查找
    @RequestMapping("/findReward/{name}")
    @ResponseBody
    public DataVO find(@PathVariable String name){
        return rewardService.findReward(name);
    }

    //修改数据
    @PostMapping("/updateReward")
    @ResponseBody
    public void updateReward(@RequestBody HashMap<String, String> map){
        Integer id = Integer.valueOf(map.get("id"));
        String department = map.get("department");
        String name = map.get("name");
        String theme = map.get("theme");
        String status = map.get("status");
        Double price = Double.valueOf(map.get("price"));
        String message = map.get("message");

        Reward reward = new Reward();

        if(status.equals("在职"))reward.setStatus(1);
        else reward.setStatus(0);

        reward.setId(id);
        reward.setName(name);
        reward.setPrice(price);
        reward.setTheme(theme);
        reward.setDepartment(department);
        reward.setMessage(message);
        rewardService.updateReward(reward);
    }

    @GetMapping("/reward/{reward}")
    public String redirect(@PathVariable("reward") String url) {
        return url;
    }
}
