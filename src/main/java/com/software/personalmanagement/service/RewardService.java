package com.software.personalmanagement.service;

import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.RewardVO;

public interface RewardService {
    public DataVO<RewardVO> findReward(Integer page, Integer limit);
}
