package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.Waa;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
import org.springframework.stereotype.Repository;

@Repository
public interface WaaMapper extends BaseMapper<String, Waa> {
    //根据account_name查询waa
    Waa searchWaaByName(String account_name);

    //钱包注册插入waa
    int insertWaa(Waa waa);

    //钱包权限检测(根据account_name(或email)和password查询对应记录)
    int searchAuthority(Waa waa);

}
