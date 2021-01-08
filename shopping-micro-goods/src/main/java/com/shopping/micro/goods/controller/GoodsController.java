package com.shopping.micro.goods.controller;

import com.shopping.micro.goods.cro.GoodsAllCro;
import com.shopping.micro.goods.cro.GoodsCro;
import com.shopping.micro.goods.entity.Goods;
import com.shopping.micro.goods.exception.MyShopException;
import com.shopping.micro.goods.remote.FeignUserService;
import com.shopping.micro.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/7 16:35
 * @Version 1.0
 */

@RestController
@RequestMapping("/service/v1")
public class GoodsController extends AbstractBaseCtrl {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/goods.addone")
    public Object addOne(@RequestBody GoodsCro goodsCro){
        goodsService.addOneGoods(goodsCro);
        return success("");
    }

    @PostMapping("/goods.addList")
    public Object addList(@RequestBody List<GoodsCro> goodsCroList){
        goodsService.addListGoods(goodsCroList);
        return success("");
    }

    @GetMapping("/goods.findById/{id}")
    public Object findGoodsById(@PathVariable("id") Long id){
        try{
            return success(goodsService.findGoodsById(id));
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/goods.findAll")
    public Object findGoodsAll(@RequestBody GoodsAllCro goodsAllCro){
        Page<Goods> pageGoods =  goodsService.findAllGoods(goodsAllCro);
        return success(getData(pageGoods));
    }

    @DeleteMapping("/goods.deleteById/{id}")
    public Object deleteGoodsById(@PathVariable("id") Long id){
        try{
            goodsService.deleteGoodsById(id);
            return success("");
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }

    }

//    @DeleteMapping("/goods.deleteAll")
//    public Object deleteGoodsList(@RequestBody List<GoodsCro> goodsCroList){
//        goodsService.deleteListGoods(goodsCroList);
//        return success("");
//    }

    @PutMapping("/goods.edit")
    public Object editGoods(@RequestBody GoodsCro goodsCro){
        try{
            return success(goodsService.editGoods(goodsCro));
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

}
