package com.shopping.micro.goods.cro;

import com.shopping.micro.goods.cro.base.BaseCro;

public class GoodsAllCro extends BaseCro {

    // 当前第几页。从0开始
    private int offset;
    // 每页的数量
    private int pageSize;

    public GoodsAllCro() {}

    public GoodsAllCro(int offset, int pageSize) {
        this.offset = offset;
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
