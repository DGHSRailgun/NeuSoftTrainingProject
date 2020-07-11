package com.neusoft.bsp.controller;


import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import com.neusoft.bsp.mvoinfo.entity.BrdBrand;
import com.neusoft.bsp.mvoinfo.service.BrdBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brdBrandController")
public class BrdBrandController extends BaseController {

    @Autowired
    BrdBrandService brdBrandService;

    //查询当前MVO所有的品牌信息(根据man_id查询brd_brand)
    @RequestMapping("/getBrandInfo")
    public BaseModelJson<List<BrdBrand>> getBrandInfo(@RequestBody int man_id){
        List<BrdBrand> resultList = brdBrandService.getAllBrand(man_id);
        if (resultList.size() != 0){
            BaseModelJson<List<BrdBrand>> result = new BaseModelJson();
            result.data = resultList;
            result.code = 200;
            result.message = "success";
            return result;
        }else {
            BaseModelJson<List<BrdBrand>> empty = new BaseModelJson();
            empty.data = null;
            empty.code = 200;
            empty.message = "no result";
            return empty;
        }
    }

    //新增品牌信息
    @RequestMapping("/addBrand")
    public BaseModel addBrand(@Validated({InsertGroup.class}) @RequestBody BrdBrand brdBrand, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{brdBrand.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = brdBrandService.insertBrand(brdBrand);
            if (i == 1) {
                result.code = 200;
                result.message = "success";
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    //删除品牌信息
    @RequestMapping("/deleteBrand")
    public BaseModel deleteBrand(@Validated({DeleteGroup.class}) @RequestBody BrdBrand brdBrand, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw BusinessException.BRDID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{brdBrand.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = brdBrandService.deleteBrand(brdBrand.getBrd_id());
            if (i == 1) {
                result.code = 200;
                result.message = "success";
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }

    //修改品牌信息
    @RequestMapping("/updateBrand")
    public BaseModel updateBrand(@Validated({UpdateGroup.class}) @RequestBody BrdBrand brdBrand, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.BRDID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{brdBrand.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =brdBrandService.updateBrand(brdBrand);
            if(i==1){
                result.code = 200;
                result.message = "success";
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
