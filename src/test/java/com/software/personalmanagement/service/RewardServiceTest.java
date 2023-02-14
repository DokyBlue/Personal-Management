package com.software.personalmanagement.service;

import com.software.personalmanagement.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RewardServiceTest {

    @Autowired
    private RewardService rewardService;

    @Test
    void findReward() {
        DataVO dataVO=rewardService.RewardList(1,10);
        int i=1;
    }
}