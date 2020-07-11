package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.wallet.entity.Wtr;
import org.springframework.stereotype.Repository;

@Repository
public interface WtrMapper {
    //插入wtr
    int insertWtr(Wtr wtr);

}
