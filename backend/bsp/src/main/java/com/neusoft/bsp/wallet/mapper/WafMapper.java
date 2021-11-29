package com.neusoft.bsp.wallet.mapper;

<<<<<<< HEAD
import com.neusoft.bsp.wallet.entity.Waf;
import org.springframework.stereotype.Repository;

@Repository
public interface WafMapper {
=======
import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.Waf;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface WafMapper extends BaseMapper<String, Waf> {
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584

    //根据buy_id查询Waf
    Waf searchWafById(int buyer_id);

    //钱包注册插入waf
    int insertWaf(Waf waf);

    //提现充值更新waf
    int updateWaf(Waf waf);

<<<<<<< HEAD
=======
    //更新available_money,depositing_money,withdrawing_money
    int updateMoney(@Param("buyer_id") int buyer_id, @Param("a_money") BigDecimal a_money, @Param("d_money") BigDecimal d_money, @Param("w_money") BigDecimal w_money);

>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
}
