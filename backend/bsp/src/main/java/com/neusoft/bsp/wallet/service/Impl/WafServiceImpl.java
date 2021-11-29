package com.neusoft.bsp.wallet.service.Impl;

import com.neusoft.bsp.wallet.entity.Waf;
import com.neusoft.bsp.wallet.mapper.WafMapper;
import com.neusoft.bsp.wallet.service.WafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.math.BigDecimal;

>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
@Service("WafService")
public class WafServiceImpl implements WafService {

    @Autowired
    WafMapper wafMapper;

    @Override
    public Waf searchWafById(int buyer_id) {
        return wafMapper.searchWafById(buyer_id);
    }

    @Override
    public int insertWaf(Waf waf) {
        return wafMapper.insertWaf(waf);
    }

    @Override
    public int updateWaf(Waf waf) {
        return wafMapper.updateWaf(waf);
    }
<<<<<<< HEAD
=======

    @Override
    public int updateMoney(int buyer_id, BigDecimal a_money, BigDecimal d_money, BigDecimal w_money) {
        return wafMapper.updateMoney(buyer_id, a_money, d_money, w_money);
    }
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
