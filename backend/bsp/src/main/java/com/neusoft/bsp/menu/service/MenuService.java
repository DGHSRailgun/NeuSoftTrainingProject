package com.neusoft.bsp.menu.service;


import com.neusoft.bsp.menu.entity.Menu;

import java.util.List;

public interface MenuService {


    List<Menu> getAuthMenu(String username);

    Menu getById(String menuid);

}
