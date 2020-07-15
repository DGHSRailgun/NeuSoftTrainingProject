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

    @Override
    public List<Menu> getAll() {

        List<Menu> menus = menuMapper.getAll();

        return addChildMenus(menus);
    }

    // 根据username获取权限菜单
    @Override
    public List<Menu> getAuthMenu(String username) {

        List<Menu> menus = menuMapper.getAuthMenu(username);
        return addChildMenus(menus);
    }

    @Override
    public Menu getById(String menuid) {
        return menuMapper.getById(menuid);
    }

    // 连同子菜单一起删除
    @Override
    public int deleteByUrlAndName(String url, String name) {
        Menu todelete = menuMapper.getByUrlAndName(url, name);
        System.out.println("name" + name);
        // 如果是父菜单
        if (todelete.getParent_id() == null){
            String id = todelete.getMenu_id();
            menuMapper.deleteByParentId(id);
        }
        return menuMapper.deleteByUrl(url);
    }

    // 将子菜单加入到父菜单中
    public List<Menu> addChildMenus(List<Menu> menus){
        List<Menu> mm = new ArrayList<>();
        for (Menu m : menus){
            if (m.getMenu_url().startsWith("#")){
                mm.add(m);
            }
        }
        // System.out.println(mm);
        for (int k=0;k<menus.size();k++){
            Menu m = menus.get(k);
            System.out.println(m.getMenu_url());
            if (!m.getMenu_url().startsWith("#")){
                for (int i=0; i<mm.size(); i++){
                    if (m.getParent_id().equals(mm.get(i).getMenu_id())){
                        mm.get(i).addChild(m);
                    }
                }
            }
        }
        // System.out.println(mm);
        return mm;
    }

    @Override
    public List<Menu> getMenuByRoleId(String id) {
        return menuMapper.getMenuByRoleId(id);
    }

    @Override
    public int updateById(Menu menu) {
        return menuMapper.updateById(menu);
    }
}
