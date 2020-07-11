package com.neusoft.bsp.mvoproduct.service.Impl;

import com.neusoft.bsp.mvoproduct.entity.PdnProductDescription;
import com.neusoft.bsp.mvoproduct.mapper.PdnProductDescriptionMapper;
import com.neusoft.bsp.mvoproduct.service.PdnProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PdnProductDescriptionService")
public class PdnProductDescriptionServiceImpl implements PdnProductDescriptionService {

    @Autowired
    PdnProductDescriptionMapper pdnProductDescriptionMapper;

    @Override
    public PdnProductDescription searchPdn(int pro_id) {
        return pdnProductDescriptionMapper.searchPdn(pro_id);
    }
}
