package com.neusoft.bsp.mvoinfo.service;

import com.neusoft.bsp.mvoinfo.entity.BrdBrand;

import java.util.List;

public interface BrdBrandService {

    List<BrdBrand> getAllBrand(int man_id);

    int insertBrand(BrdBrand brdBrand);

    int deleteBrand(int brd_id);

    int updateBrand(BrdBrand brdBrand);
<<<<<<< HEAD
=======

    int searchLastedId();
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
