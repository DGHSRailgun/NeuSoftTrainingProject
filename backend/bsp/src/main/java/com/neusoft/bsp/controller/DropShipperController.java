package com.neusoft.bsp.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.base.BaseModelJson1;
import com.neusoft.bsp.dropshipper.service.DropShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController

public class DropShipperController {

    @Autowired
    DropShipperService dropShipperService;

    @PostMapping("/getDropShipper")
    public String getDropShipper(@RequestBody Map<String,String> param){
        int code = 200;
        String DSR_ID = param.get("dsrID");
        //System.out.println("DSRID: " + DSR_ID);
        List<HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("dropShipperName", dropShipperService.getDropShipperName(DSR_ID));
        responseMap.put("dropShipperRemark", dropShipperService.getDropShipperRemark(DSR_ID));
        /*System.out.println("Name: " +  dropShipperService.getDropShipperName(DSR_ID));
        System.out.println("RESPONSEMAP: " + responseMap);*/
        response.add(responseMap);
        return JSON.toJSONString(new BaseModelJson1<>(code,response));
    }

    @PostMapping("/updateDropShipper")
    public String updateDropShipper(@RequestBody Map<String, String> param){
        int code = 200;
        String DSR_ID = param.get("dsr_ID");
        String NAME = param.get("dsr_Name");
        String REMARK = param.get("dsr_remark");
        System.out.println("Remark" + REMARK + "ID " + DSR_ID);
        dropShipperService.updateDropShipperName(DSR_ID, NAME);
        dropShipperService.updateRemark(DSR_ID, REMARK);
        List<HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        response.add(responseMap);
        return JSON.toJSONString(new BaseModelJson1<>(code,response));
    }


    /*@PostMapping("/getDropShipperRemark")
    public String getDropShipperRemark(@RequestBody Map<String,String> param){
        int code = 20000;
        String DSR_ID = param.get("dsrID");
        //System.out.println("DSRID: " + DSR_ID);
        List<HashMap> response = new LinkedList<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("dropShipperRemark", dropShipperService.getDropShipperRemark(DSR_ID));
        *//*System.out.println("Name: " +  dropShipperService.getDropShipperName(DSR_ID));
        System.out.println("RESPONSEMAP: " + responseMap);*//*
        response.add(responseMap);
        return JSON.toJSONString(new BaseModelJson<>(code,response));
    }*/

}
