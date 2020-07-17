package com.neusoft.bsp.mvoproduct.service.Impl;

import com.neusoft.bsp.mvoproduct.entity.ImgImage;
import com.neusoft.bsp.mvoproduct.mapper.ImgImageMapper;
import com.neusoft.bsp.mvoproduct.service.ImgImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ImgImageService")
public class ImgImageServiceImpl implements ImgImageService {

    @Autowired
    ImgImageMapper imgImageMapper;

    @Override
    public List<ImgImage> searchImg(int pro_id) {
        return imgImageMapper.searchImg(pro_id);
    }
}
