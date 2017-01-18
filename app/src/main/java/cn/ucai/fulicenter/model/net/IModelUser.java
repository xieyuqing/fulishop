package cn.ucai.fulicenter.model.net;

import android.content.Context;

import java.io.File;

import cn.ucai.fulicenter.model.bean.GoodsDetailsBean;
import cn.ucai.fulicenter.model.bean.User;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public interface IModelUser {
    void login(Context context, String username, String password, OnCompleteListener<String> listener);

    void register(Context context, String username, String usernick, String password, OnCompleteListener<String> listener);

    void updateNick(Context context,String username,String usernick,OnCompleteListener<String> listener);

    void uploadAvatar(Context context, String username, File file,OnCompleteListener<String> listener);
}
