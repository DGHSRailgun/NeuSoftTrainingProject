package com.neusoft.bsp.mvoinfo.service;

import com.neusoft.bsp.mvoinfo.entity.ManManufacturer;

public interface ManManufacturerService {

    ManManufacturer findInfoByMVO(int man_id);

    int insert(ManManufacturer manManufacturer);

<<<<<<< HEAD
=======
    int searchLatestManiId();

>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
