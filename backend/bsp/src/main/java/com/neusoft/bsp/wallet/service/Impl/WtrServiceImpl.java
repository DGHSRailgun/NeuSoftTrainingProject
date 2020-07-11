package com.neusoft.bsp.wallet.service.Impl;

import com.neusoft.bsp.wallet.entity.Wtr;
import com.neusoft.bsp.wallet.mapper.WtrMapper;
import com.neusoft.bsp.wallet.service.WtrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WtrService")
public class WtrServiceImpl implements WtrService {

    @Autowired
    WtrMapper wtrMapper;

    @Override
    public int insertWtr(Wtr wtr) {
        return wtrMapper.insertWtr(wtr);
    }
}
