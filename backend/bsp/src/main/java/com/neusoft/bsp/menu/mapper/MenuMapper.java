package com.neusoft.bsp.menu.mapper;


import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.menu.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper{
    List<Menu> getAuthMenu(String username);

    Menu getById(String menuid);

}
