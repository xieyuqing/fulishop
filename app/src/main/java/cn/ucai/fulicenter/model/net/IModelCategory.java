package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.model.bean.CategoryChildBean;
import cn.ucai.fulicenter.model.bean.CategoryGroupBean;

/**
 * Created by Administrator on 2017/1/13 0013.
 */

public interface IModelCategory {
    void downDataGroup(Context context, OnCompleteListener<CategoryGroupBean[]> listener);

    void downDataChild(Context context, int parentId, OnCompleteListener<CategoryChildBean[]> listener);
}
