package cn.ucai.fulicenter.model.net;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class SharePrefrenceUtils {
    private static final String SHARE_PREFRENCE_NAME = "cn.ucai.fulicenter_user";
    private static final String SHARE_PREFRENCE_NAME_USERNAME = "cn.ucai.fulicenter_username";
    private static SharePrefrenceUtils instance;
    private static SharedPreferences prefrences;

    public SharePrefrenceUtils(Context context) {
        prefrences = context.getSharedPreferences(SHARE_PREFRENCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharePrefrenceUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SharePrefrenceUtils(context);
        }
        return instance;
    }

    public   void saveUser(String username) {
        prefrences.edit().putString(SHARE_PREFRENCE_NAME_USERNAME, username).commit();
    }

    public  String getUser() {
        return prefrences.getString(SHARE_PREFRENCE_NAME_USERNAME, null);
    }
}
