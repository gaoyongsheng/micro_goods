package com.shopping.micro.goods.cro;

import com.shopping.micro.goods.cro.base.BaseCro;
import com.shopping.micro.goods.dto.GoodsDto;
import com.shopping.micro.goods.entity.FilesRes;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/7 15:47
 * @Version 1.0
 */
public class GoodsCro extends BaseCro {

    private Long id;

    private String goodsName;

    private String goodsPrice;

    private String goodsInventoryCount;

    private String goodsSalesCount;

    private List<FilesRes> goodsTitleImage;

    private String goodsDetailText;

    private String goodsAddTime;

    private List<FilesRes> goodsDetailImage;

    public GoodsDto toDto(){
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(id);
        goodsDto.setGoodsName(goodsName);
        goodsDto.setGoodsPrice(goodsPrice);
        goodsDto.setGoodsInventoryCount(goodsInventoryCount);
        goodsDto.setGoodsSalesCount(goodsSalesCount);
        goodsDto.setGoodsTitleImage(goodsTitleImage);
        goodsDto.setGoodsDetailText(goodsDetailText);
        goodsDto.setGoodsDetailImage(goodsDetailImage);
        goodsDto.setGoodsAddTime(goodsAddTime);
        return goodsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsInventoryCount() {
        return goodsInventoryCount;
    }

    public void setGoodsInventoryCount(String goodsInventoryCount) {
        this.goodsInventoryCount = goodsInventoryCount;
    }

    public String getGoodsSalesCount() {
        return goodsSalesCount;
    }

    public void setGoodsSalesCount(String goodsSalesCount) {
        this.goodsSalesCount = goodsSalesCount;
    }

    public List<FilesRes> getGoodsTitleImage() {
        return goodsTitleImage;
    }

    public void setGoodsTitleImage(List<FilesRes> goodsTitleImage) {
        this.goodsTitleImage = goodsTitleImage;
    }

    public String getGoodsDetailText() {
        return goodsDetailText;
    }

    public void setGoodsDetailText(String goodsDetailText) {
        this.goodsDetailText = goodsDetailText;
    }

    public String getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(String goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public List<FilesRes> getGoodsDetailImage() {
        return goodsDetailImage;
    }

    public void setGoodsDetailImage(List<FilesRes> goodsDetailImage) {
        this.goodsDetailImage = goodsDetailImage;
    }
}
