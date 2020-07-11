package com.neusoft.bsp.mvoproduct.service;

import com.neusoft.bsp.mvoproduct.entity.ProProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProProductService {

    List<ProProduct> searchProduct(int man_id);

    ProProduct searchByProId(int pro_id);

    int updateDeletePro(int pro_id);

    int updateAIPro(@Param("pro_id") int pro_id, @Param("sts_cd") String sts_cd);

}
