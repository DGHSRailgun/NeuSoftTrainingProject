package com.neusoft.bsp.wallet.service;

import com.neusoft.bsp.wallet.entity.Waf;

public interface WafService {

    Waf searchWafById(int buyer_id);

    int insertWaf(Waf waf);

    int updateWaf(Waf waf);

}
