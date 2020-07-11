package com.neusoft.bsp.menu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.menu.entity.Menu;
import com.neusoft.bsp.menu.mapper.MenuMapper;
import com.neusoft.bsp.menu.service.MenuService;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    // 根据uid获取权限菜单
    @Override
    public List<Menu> getAuthMenu(String username) {
        List<Menu> mm = new ArrayList<>();
        List<Menu> menus = menuMapper.getAuthMenu(username);
        for (Menu m : menus){
            if (m.getMenu_url().equals("#")){
                mm.add(m);
            }
        }
        System.out.println(mm);
        for (int k=0;k<menus.size();k++){
            Menu m = menus.get(k);
            System.out.println(m.getMenu_url());
            if (!m.getMenu_url().equals("#")){
                for (int i=0; i<mm.size(); i++){
                    if (m.getParent_id().equals(mm.get(i).getMenu_id())){
                        mm.get(i).addChild(m);
                    }
                }
            }
        }
        System.out.println(mm);
        return mm;
    }

    @Override
    public Menu getById(String menuid) {
        return menuMapper.getById(menuid);
    }

//    @Override
//    public List<Menu> getAll() {
//        Menu m32 = new Menu();
//        m32.setMenu_id("32");
//        m32.setMenu_name("我的信息");
//        m32.setParent_id("31");
//        m32.setMenu_order(11);
//        m32.setMenu_url("/mvo/mvo-myInfo");
//        m32.setMenu_hidden(false);
//        Menu m33 = new Menu();
//        m33.setMenu_id("31");
//        m33.setMenu_name("商品录入");
//        m33.setParent_id("31");
//        m33.setMenu_order(12);
//        m33.setMenu_url("/mvo/mvo-goodsRecord");
//        m33.setMenu_hidden(false);
//        Menu m31 = new Menu();
//        m31.setMenu_name("MVO");
//        m31.setMenu_url("#");
//        m31.setMenu_hidden(false);
//        List mm = new ArrayList();
//        mm.add(m33);
//        mm.add(m32);
//        m31.setChildren(mm);
//        List menus = new ArrayList();
//        menus.add(m31);
//        return menus;
//    }
}
