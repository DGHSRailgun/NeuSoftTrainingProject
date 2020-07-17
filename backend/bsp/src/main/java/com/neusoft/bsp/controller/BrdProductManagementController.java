package com.neusoft.bsp.controller;

import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import com.neusoft.bsp.mvoproduct.entity.*;
import com.neusoft.bsp.mvoproduct.service.*;
import com.neusoft.bsp.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//品牌商商品管理
@CrossOrigin
@RestController
@RequestMapping("/brdProductManagementController")
public class BrdProductManagementController extends BaseController {

    @Autowired
    ProProductService proProductService;

    @Autowired
    OfpOfferPriceService ofpOfferPriceService;

    @Autowired
    PckPackageInfoService pckPackageInfoService;

    @Autowired
    PdnProductDescriptionService pdnProductDescriptionService;

    @Autowired
    SpaSpecificAttributeService spaSpecificAttributeService;

    @Autowired
    SpvSpecificAttributeValueService spvSpecificAttributeValueService;

    @Autowired
    ImgImageService imgImageService;

    //注册redis
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/searchPro")
    public BaseModelJson<List<ProProduct>> searchPro(@RequestBody int man_id){//前端传回当前用户的man_buyer_id
        //测试redis缓存数据库
//        redisUtil.set("20182018","这是一条测试数据", RedisConstants.datebase1);
//        Long resExpire = redisUtil.expire("20182018", 60, RedisConstants.datebase1);
//        System.out.println(redisUtil.get("20182018", RedisConstants.datebase1));


        List<ProProduct> resultList = proProductService.searchProduct(man_id);
        if (resultList.size() != 0){
            BaseModelJson<List<ProProduct>> result = new BaseModelJson();
            result.data = resultList;
            result.message = "success";
            result.code = 200;
            return result;
        }else {
            BaseModelJson<List<ProProduct>> empty = new BaseModelJson();
            empty.data = resultList;
            empty.message = "no result";
            empty.code = 200;
            return empty;
        }
    }

    @RequestMapping("/searchUnionInfo")
    public BaseModelJson<List<Map>> searchUnionInfo(@RequestBody int man_id){
        List<ProProduct> resultPro = proProductService.searchProduct(man_id);//根据man_id查询对应的pro列表
        List<OfpOfferPrice> resultOfp;//用来记录每一个pro_id对应的多个ofp
        PckPackageInfo resultPak;//用来记录每一个pro_id对应的唯一pck
        PdnProductDescription resultPdn;//用来记录每一个pro_id对应的唯一pdn
        SpaSpecificAttribute resultSpa;//用来记录每一个pro_id对应的唯一spa
        SpvSpecificAttributeValue resultSpv;//用来记录每一个pro_id对应的唯一spv
        List<ImgImage> resultImg;//用来记录每一个pro_id对应的多个img


        List<Map> result = new ArrayList();//打包处理返回值(返回结果)

        BaseModelJson<List<Map>> resultMessage = new BaseModelJson();//返回的JSON字符串

        int count = 0;//记录产品的个数

        if(resultPro.size() != 0){//如果有对应的pro
            for(ProProduct p: resultPro){
                Map tempResult = new HashMap();//用map存储当前打包信息

                resultOfp = ofpOfferPriceService.getOfpByProId(p.getPro_id());//给当前产品查询对应的ofp列表
                resultPak = pckPackageInfoService.searchPck(p.getPro_id());//给当前商品查询唯一的pck
                resultPdn = pdnProductDescriptionService.searchPdn(p.getPro_id());//给当前商品查询唯一的pdn
                resultSpa = spaSpecificAttributeService.searchSpa(p.getPro_id());//给当前商品查询唯一的spa
                if(resultSpa != null){//如果有spa
                    resultSpv = spvSpecificAttributeValueService.searchSpv(resultSpa.getSpa_id());//给当前商品查询唯一的spv
                }else {
                    resultSpv = null;
                }
                resultImg = imgImageService.searchImg(p.getPro_id());

                tempResult.put("pro",p);
                tempResult.put("ofp",resultOfp);
                tempResult.put("pak",resultPak);
                tempResult.put("pdn",resultPdn);
                tempResult.put("spa",resultSpa);
                tempResult.put("spv",resultSpv);
                tempResult.put("img",resultImg);


                result.add(count,tempResult);
                count++;
            }
            resultMessage.code = 200;
            resultMessage.message = "success";
        }else {//如果没查询到pro
            resultMessage.code = 201;
            resultMessage.message = "no result data";
        }

        resultMessage.data = result;
        return resultMessage;
    }

    //删除商品
    @RequestMapping("/deleteProduct")
    public BaseModel deleteProduct(@Validated({UpdateGroup.class}) @RequestBody int pro_id){//根据前端传回的pro_id删除修改

        BaseModel baseModel = new BaseModel();

        if(proProductService.searchByProId(pro_id).getSts_cd().equals("D")){
            baseModel.code = 201;
            baseModel.message = "Do not delete again!";
            return baseModel;
        }

        int i = proProductService.updateDeletePro(pro_id);

        if(i == 1){
            baseModel.code = 200;
            baseModel.message = "success";
            return baseModel;
        }else {
            throw BusinessException.UPDATE_FAIL;
        }
    }

    //上架下架商品
    @RequestMapping("/changeStatus")
    public BaseModel changeStatus(@Validated({UpdateGroup.class})@RequestBody int pro_id, String status, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw BusinessException.PROID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{pro_id,status});
        } else {
            BaseModel baseModel = new BaseModel();

            if(proProductService.searchByProId(pro_id).getSts_cd().equals(status)){
                baseModel.code = 201;
                baseModel.message = "Do set the same status again!";
                return baseModel;
            }

            int i = proProductService.updateAIPro(pro_id,status);
            if(i == 1){
                baseModel.code = 200;
                baseModel.message = "success";
                return baseModel;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }

    }



}
