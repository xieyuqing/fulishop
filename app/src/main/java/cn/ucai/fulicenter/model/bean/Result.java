package cn.ucai.fulicenter.model.bean;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class Result {

    /**
     * retCode : 0
     * retMsg : true
     * retData : {"muserName":"a952700","muserNick":"士大夫","mavatarId":72,"mavatarPath":"user_avatar","mavatarSuffix":".jpg","mavatarType":0,"mavatarLastUpdateTime":"1478492451603"}
     */

    private int retCode;
    private boolean retMsg;
    private Object retData;
    public Result() {
    }
    public Result(boolean retMsg,int retCode){
        this.retMsg = retMsg;
        this.retCode = retCode;
    }
    public Result(int retCode, boolean retMsg, Object retData) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
    }
    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public boolean isRetMsg() {
        return retMsg;
    }

    public void setRetMsg(boolean retMsg) {
        this.retMsg = retMsg;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retCode=" + retCode +
                ", retMsg=" + retMsg +
                ", retData=" + retData +
                '}';
    }
}
