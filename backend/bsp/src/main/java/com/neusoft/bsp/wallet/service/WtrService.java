package com.neusoft.bsp.wallet.service;

import com.neusoft.bsp.wallet.entity.Wtr;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
public interface WtrService {

    int insertWtr(Wtr wtr);

<<<<<<< HEAD
=======
    List<Wtr> searchWtrByBuyerId(int buyer_id);

    List<Wtr> searchAllWtrByFilter();

    Wtr searchWtrById(int transaction_id);

    int updateWtrStatus(int transaction_id, int status);

    int getMaxId();


>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
