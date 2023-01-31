package com.software.personalmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.personalmanagement.entity.Reward;

public interface RewardMapper extends BaseMapper<Reward> {
    public Reward getReward(Reward reward);
}
