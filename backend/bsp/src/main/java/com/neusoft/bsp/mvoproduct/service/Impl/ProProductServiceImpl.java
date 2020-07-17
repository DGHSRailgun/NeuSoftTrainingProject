package com.neusoft.bsp.mvoproduct.service.Impl;

import com.neusoft.bsp.mvoproduct.entity.ProProduct;
import com.neusoft.bsp.mvoproduct.mapper.ProProductMapper;
import com.neusoft.bsp.mvoproduct.service.ProProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProProductService")
public class ProProductServiceImpl implements ProProductService {

    @Autowired
    ProProductMapper proProductMapper;

    @Override
    public List<ProProduct> searchProduct(int man_id) {
        return proProductMapper.searchProduct(man_id);
    }

    @Override
    public ProProduct searchByProId(int pro_id) {
        return proProductMapper.searchByProId(pro_id);
    }

    @Override
    public int updateDeletePro(int pro_id) {
        return proProductMapper.updateDeletePro(pro_id);
    }

    @Override
    public int updateAIPro(int pro_id, String sts_cd) {
        return proProductMapper.updateAIPro(pro_id, sts_cd);
    }
}
