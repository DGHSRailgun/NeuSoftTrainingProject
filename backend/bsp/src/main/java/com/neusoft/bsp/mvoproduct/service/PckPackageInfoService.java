package com.neusoft.bsp.mvoproduct.service;

import com.neusoft.bsp.mvoproduct.entity.PckPackageInfo;

public interface PckPackageInfoService {
    PckPackageInfo searchPck(int pro_id);
<<<<<<< HEAD
=======

    int updateByPro_id(String pro_id, String width, String height, String length, String weight);

    int insertByPro_id(String pro_id, String width, String height, String length, String weight);
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
