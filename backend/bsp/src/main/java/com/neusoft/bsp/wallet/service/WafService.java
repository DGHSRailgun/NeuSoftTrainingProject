package com.neusoft.bsp.wallet.service;

import com.neusoft.bsp.wallet.entity.Waf;
<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584

public interface WafService {

    Waf searchWafById(int buyer_id);

    int insertWaf(Waf waf);

    int updateWaf(Waf waf);

<<<<<<< HEAD
=======
    int updateMoney(int buyer_id, BigDecimal a_money, BigDecimal d_money, BigDecimal w_money);


>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
