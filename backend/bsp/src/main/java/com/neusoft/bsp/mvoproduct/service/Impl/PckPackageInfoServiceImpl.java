package com.neusoft.bsp.mvoproduct.service.Impl;

import com.neusoft.bsp.mvoproduct.entity.PckPackageInfo;
import com.neusoft.bsp.mvoproduct.mapper.PckPackageInfoMapper;
import com.neusoft.bsp.mvoproduct.service.PckPackageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PckPackageInfoService")
public class PckPackageInfoServiceImpl implements PckPackageInfoService {

    @Autowired
    PckPackageInfoMapper pckPackageInfoMapper;

    @Override
    public PckPackageInfo searchPck(int pro_id) {
        return pckPackageInfoMapper.searchPck(pro_id);
    }
}
