package cn.ucai.fulicenter.bean;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class MessageBean {

    /**
     * success : false
     * msg : 修改购物车中的商品失败
     */

    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
