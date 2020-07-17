package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.Waf;
import org.springframework.stereotype.Repository;

@Repository
public interface WafMapper extends BaseMapper<String, Waf> {

    //根据buy_id查询Waf
    Waf searchWafById(int buyer_id);

    //钱包注册插入waf
    int insertWaf(Waf waf);

    //提现充值更新waf
    int updateWaf(Waf waf);

}
