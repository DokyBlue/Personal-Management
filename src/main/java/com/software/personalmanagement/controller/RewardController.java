package com.software.personalmanagement.controller;

import com.software.personalmanagement.service.RewardService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @RequestMapping("/rewardlist")
    @ResponseBody
    public DataVO rewardlist(Integer page, Integer limit){
        return rewardService.findReward(page, limit);
    }

    @GetMapping("/reward/{reward}")
    public String redirect(@PathVariable("reward") String url) {
        return url;
    }
}
