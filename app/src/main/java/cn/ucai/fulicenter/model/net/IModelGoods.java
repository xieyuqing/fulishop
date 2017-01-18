package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.model.bean.GoodsDetailsBean;
import cn.ucai.fulicenter.model.bean.MessageBean;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;

/**
 * Created by Administrator on 2017/1/12 0012.
 */

public interface IModelGoods {
    void downData(Context context, int goodsId,OnCompleteListener<GoodsDetailsBean> listener);

    void isCollect(Context context,int goodsId,String username,OnCompleteListener<MessageBean> listener);
}
