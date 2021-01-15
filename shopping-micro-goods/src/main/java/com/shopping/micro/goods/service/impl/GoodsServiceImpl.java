package com.shopping.micro.goods.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.goods.constants.ShopExceptionCode;
import com.shopping.micro.goods.cro.GoodsAllCro;
import com.shopping.micro.goods.cro.GoodsCro;
import com.shopping.micro.goods.entity.FilesRes;
import com.shopping.micro.goods.entity.Goods;
import com.shopping.micro.goods.entity.User;
import com.shopping.micro.goods.exception.MyShopException;
import com.shopping.micro.goods.remote.FeignUserService;
import com.shopping.micro.goods.repository.GoodsRepository;
import com.shopping.micro.goods.service.FilesResService;
import com.shopping.micro.goods.service.GoodsService;
import com.shopping.micro.goods.utils.DateTimeUtils;
import com.shopping.micro.goods.utils.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/7 16:29
 * @Version 1.0
 */

@Slf4j
@Service
@Transactional
public class GoodsServiceImpl extends AbstractBaseImpl implements GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    FilesResService filesResService;

    @Autowired
    FeignUserService feignUserService;

    public JSONObject getCurLoginUser(String str){
        return feignUserService.findUserByUserNameOrMobile(str);
    }

    @Override
    public void addOneGoods(GoodsCro goodsCro) {
        Goods goods = new Goods(goodsCro.toDto());
        User curUser = (User) ThreadLocalUtils.get();
        goods.setGoodsUserId(curUser.getId());
        goods.setGoodsAddTime(DateTimeUtils.getSysCurDate());

        List<FilesRes> titleImgList = filesResService.saveFileRes(goods.getGoodsTitleImage());
        List<FilesRes> detailImgList = filesResService.saveFileRes(goods.getGoodsDetailImage());

        goods.setGoodsTitleImage(titleImgList);
        goods.setGoodsDetailImage(detailImgList);

        goodsRepository.save(goods);

    }

    @Override
    public void addListGoods(List<GoodsCro> goodsCroList) {
        List<Goods> goodsList = new ArrayList<Goods>();
        for(GoodsCro goodsCro : goodsCroList){
            Goods goods = new Goods(goodsCro.toDto());
            User curUser = (User)ThreadLocalUtils.get();
            goods.setGoodsUserId(curUser.getId());
            goods.setGoodsAddTime(DateTimeUtils.getSysCurDate());

            List<FilesRes> titleImgList = filesResService.saveFileRes(goods.getGoodsTitleImage());
            List<FilesRes> detailImgList = filesResService.saveFileRes(goods.getGoodsDetailImage());

            goods.setGoodsTitleImage(titleImgList);
            goods.setGoodsDetailImage(detailImgList);

            goodsList.add(goods);
        }
        goodsRepository.saveAll(goodsList);
    }

    @Override
    public void deleteGoodsById(Long id) {
        Goods curGoods = findGoodsById(id);
        List<FilesRes> titleImgList = curGoods.getGoodsTitleImage();
        List<FilesRes> detailImgList = curGoods.getGoodsDetailImage();

        filesResService.deleteFilesRes(titleImgList);
        filesResService.deleteFilesRes(detailImgList);

        goodsRepository.deleteById(id);
    }

    @Override
    public void deleteListGoods(List<GoodsCro> goodsCroList) {
        List<Goods> goodsList = new ArrayList<Goods>();
        for(GoodsCro goodsCro : goodsCroList){
            Goods goods = new Goods(goodsCro.toDto());
            User curUser = (User)ThreadLocalUtils.get();
            goods.setGoodsUserId(curUser.getId());
            goods.setGoodsAddTime(DateTimeUtils.getSysCurDate());
            goodsList.add(goods);
        }
        goodsRepository.deleteAll(goodsList);
    }

    @Override
    public Goods findGoodsById(Long id) {
        Goods curGoods = goodsRepository.findGoodsById(id);
        if(null == curGoods){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"实体对象不存在");
        }
        return curGoods;
    }

    @Override
    public Page<Goods> findAllGoods(GoodsAllCro goodsAllCro) {
        Pageable pageable = getPageable(goodsAllCro.getOffset(),goodsAllCro.getPageSize());
        Page<Goods> page = goodsRepository.findAll(pageable);
        return page;
    }

    @Override
    public Goods editGoods(GoodsCro goodsCro) {

        Goods curGoods = new Goods(goodsCro.toDto());

        curGoods.setGoodsName(goodsCro.getGoodsName());
        curGoods.setGoodsPrice(goodsCro.getGoodsPrice());
        curGoods.setGoodsInventoryCount(goodsCro.getGoodsInventoryCount());
        curGoods.setGoodsSalesCount(goodsCro.getGoodsSalesCount());
        curGoods.setGoodsDetailText(goodsCro.getGoodsDetailText());

        List<FilesRes> titleImgList = filesResService.saveFileRes(curGoods.getGoodsTitleImage());
        List<FilesRes> detailImgList = filesResService.saveFileRes(curGoods.getGoodsDetailImage());

        curGoods.setGoodsTitleImage(titleImgList);
        curGoods.setGoodsDetailImage(detailImgList);

        return goodsRepository.save(curGoods);
    }
}
