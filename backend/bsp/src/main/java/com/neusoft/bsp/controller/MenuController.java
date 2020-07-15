package com.neusoft.bsp.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import com.neusoft.bsp.menu.entity.Menu;
import com.neusoft.bsp.menu.service.MenuService;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    MenuService menuService;

    @PostMapping("/getAuthMenu")
    public BaseModelJson<List<Menu>> getAuthMenu(@RequestParam String username)
    {

        BaseModelJson<List<Menu>> result = new BaseModelJson();

        result.code = 200;
        result.data = menuService.getAuthMenu(username);
        return result;
    }

    @PostMapping("/getMenuByRoleId")
    public BaseModelJson<List<Menu>> getMenuByRoleId(@RequestParam String id)
    {

        BaseModelJson<List<Menu>> result = new BaseModelJson();

        result.code = 200;
        result.data = menuService.getMenuByRoleId(id);
        return result;
    }

    @PostMapping("/getAll")
    public BaseModelJson<List<Menu>> getAll()
    {

        BaseModelJson<List<Menu>> result = new BaseModelJson();

        result.code = 200;
        result.data = menuService.getAll();
        return result;
    }

    @PostMapping("/deleteByUrlAndName")
    public BaseModelJson<Integer> deleteByUrl(@RequestParam String url, @RequestParam String name){
        BaseModelJson<Integer> result = new BaseModelJson();
        result.code=200;
        result.data = menuService.deleteByUrlAndName(url, name);
        return result;
    }

    @PostMapping("/updateById")
    @ResponseBody
    public BaseModelJson<Integer> updateById(@RequestBody Menu menu){
        BaseModelJson<Integer> result = new BaseModelJson();
        result.code=200;
        result.data = menuService.updateById(menu);
        return result;
    }


}
