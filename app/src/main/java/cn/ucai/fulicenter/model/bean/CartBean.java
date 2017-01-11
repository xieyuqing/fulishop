package cn.ucai.fulicenter.model.bean;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class CartBean {

    /**
     * id : 2016
     * userName : a123456
     * goodsId : 7672
     * goods : []
     * count : 2
     * isChecked : false
     * checked : false
     */

    private int id=0;
    private String userName;
    private int goodsId;
    private int count;
    private boolean isChecked;
    private GoodsDetailsBean goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public GoodsDetailsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsDetailsBean goods) {
        this.goods = goods;
    }


    @Override
    public String toString() {
        return "CartBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", goodsId=" + goodsId +
                ", count=" + count +
                ", isChecked=" + isChecked +
                ", goods=" + goods +
                '}';
    }
}
