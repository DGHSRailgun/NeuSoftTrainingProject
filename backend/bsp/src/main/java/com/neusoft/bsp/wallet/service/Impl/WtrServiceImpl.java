package com.neusoft.bsp.wallet.service.Impl;

import com.neusoft.bsp.wallet.entity.Wtr;
import com.neusoft.bsp.wallet.mapper.WtrMapper;
import com.neusoft.bsp.wallet.service.WtrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
@Service("WtrService")
public class WtrServiceImpl implements WtrService {

    @Autowired
    WtrMapper wtrMapper;

    @Override
    public int insertWtr(Wtr wtr) {
        return wtrMapper.insertWtr(wtr);
    }
<<<<<<< HEAD
=======

    @Override
    public List<Wtr> searchWtrByBuyerId(int buyer_id) {
        return wtrMapper.searchWtrByBuyerId(buyer_id);
    }

    @Override
    public List<Wtr> searchAllWtrByFilter() {
        return wtrMapper.searchAllWtrByFilter();
    }

    @Override
    public Wtr searchWtrById(int transaction_id) {
        return wtrMapper.searchWtrById(transaction_id);
    }

    @Override
    public int updateWtrStatus(int transaction_id, int status) {
        return wtrMapper.updateWtrStatus(transaction_id, status);
    }

    @Override
    public int getMaxId() {
        return wtrMapper.getMaxId();
    }
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
