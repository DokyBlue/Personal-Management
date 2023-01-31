package com.software.personalmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.entity.Reward;
import com.software.personalmanagement.mapper.RewardMapper;
import com.software.personalmanagement.service.RewardService;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.EmployeeVO;
import com.software.personalmanagement.vo.RewardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardMapper rewardMapper;

    @Override
    public DataVO<RewardVO> findReward(Integer page, Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Reward> rewardIPage = new Page<>(page,limit);
        IPage<Reward> result = rewardMapper.selectPage(rewardIPage,null);

        dataVO.setCount((int) result.getTotal());
        List<Reward> rewardList = result.getRecords();
        List<RewardVO> rewardVOList = new ArrayList<>();

        for (Reward reward : rewardList){
            RewardVO rewardVO = new RewardVO();
            BeanUtils.copyProperties(reward,rewardVO);

            if(reward.getStatus()) rewardVO.setStatus(("在职"));
            else rewardVO.setStatus("离职");

            rewardVOList.add(rewardVO);
        }
        dataVO.setData(rewardVOList);
        return dataVO;
    }
}
