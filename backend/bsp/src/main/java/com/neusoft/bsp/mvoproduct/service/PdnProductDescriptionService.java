package com.neusoft.bsp.mvoproduct.service;

import com.neusoft.bsp.mvoproduct.entity.PdnProductDescription;

public interface PdnProductDescriptionService {
    PdnProductDescription searchPdn(int pro_id);
<<<<<<< HEAD
=======

    int insertByPro_id(String pro_id, String descrition);

    int updateByPro_id(String pro_id, String descrition);
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
