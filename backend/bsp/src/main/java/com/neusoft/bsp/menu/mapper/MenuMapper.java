package com.neusoft.bsp.menu.mapper;


import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.menu.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper{
    List<Menu> getAuthMenu(String username);

    Menu getById(String menuid);

    List<Menu> getAll();

    int deleteByUrl(String url);

    int deleteById(String id);

    Menu getByUrlAndName(String url, String name);

    int deleteByParentId(String id);

    int updateById(Menu menu);

    List<Menu> getMenuByRoleId(String id);

}
