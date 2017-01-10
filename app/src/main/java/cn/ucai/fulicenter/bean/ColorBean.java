package cn.ucai.fulicenter.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class ColorBean {

    /**
     * id : 8445
     * goodsId : 0
     * colorId : 10
     * colorName : 花青
     * colorCode : #488eb5
     * colorImg :
     * colorUrl : http://item.jd.com/745025.html
     * albums : []
     */

    private int id;
    private int goodsId;
    private int colorId;
    private String colorName;
    private String colorCode;
    private String colorImg;
    private String colorUrl;
    private List<?> albums;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorImg() {
        return colorImg;
    }

    public void setColorImg(String colorImg) {
        this.colorImg = colorImg;
    }

    public String getColorUrl() {
        return colorUrl;
    }

    public void setColorUrl(String colorUrl) {
        this.colorUrl = colorUrl;
    }

    public List<?> getAlbums() {
        return albums;
    }

    public void setAlbums(List<?> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "ColorBean{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", colorId=" + colorId +
                ", colorName='" + colorName + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", colorImg='" + colorImg + '\'' +
                ", colorUrl='" + colorUrl + '\'' +
                ", albums=" + albums +
                '}';
    }
}

