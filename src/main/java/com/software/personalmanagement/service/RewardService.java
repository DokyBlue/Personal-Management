package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Reward;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.RewardVO;

public interface RewardService {
    DataVO<RewardVO> RewardList(Integer page, Integer limit);

    //新增
    int insertReward(Reward reward);

    //删除
    Integer delete(int id);

    //查询
    DataVO<RewardVO> findReward(String name);

    //更新
    int updateReward(Reward reward);
}
