package cn.ucai.fulicenter.controller.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.model.bean.Result;
import cn.ucai.fulicenter.model.net.IModelUser;
import cn.ucai.fulicenter.model.net.ModelUser;
import cn.ucai.fulicenter.model.net.OnCompleteListener;
import cn.ucai.fulicenter.model.utils.CommonUtils;
import cn.ucai.fulicenter.model.utils.L;
import cn.ucai.fulicenter.model.utils.ResultUtils;
import cn.ucai.fulicenter.view.DisplayUtils;
import cn.ucai.fulicenter.view.MFGT;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etNick)
    EditText etNick;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;

    IModelUser model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        DisplayUtils.initBackWithTitle(this,"用户登录");
    }

    @OnClick(R.id.btnRegister)
    public void checkInput() {
        String username = etUserName.getText().toString().trim();
        String usernick = etNick.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirm = etConfirmPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            etUserName.setError(getResources().getString(R.string.user_name_connot_be_empty));
            etUserName.requestFocus();
        } else if (!username.matches("[a-zA-Z]\\w{5,15}")){
            etUserName.setError(getResources().getString(R.string.illegal_user_name));
            etUserName.requestFocus();
        }else if (TextUtils.isEmpty(usernick)) {
            etNick.setError(getResources().getString(R.string.nick_name_connot_be_empty));
            etNick.requestFocus();
        }else if (TextUtils.isEmpty(password)) {
            etPassword.setError(getResources().getString(R.string.password_connot_be_empty));
            etPassword.requestFocus();
        }else if (TextUtils.isEmpty(confirm)) {
            etConfirmPassword.setError(getResources().getString(R.string.confirm_password_connot_be_empty));
            etConfirmPassword.requestFocus();
        } else if (!password.equals(confirm)) {
            etConfirmPassword.setError(getResources().getString(R.string.two_input_password));
            etConfirmPassword.requestFocus();
        } else {
            register(username,usernick,password);
        }
    }

    private void register(String username, String usernick, String password) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage(getString(R.string.registering));
        model = new ModelUser();
        model.register(this, username, usernick, password, new OnCompleteListener<String>() {
            @Override
            public void onSuccess(String s) {
                if (s != null) {
                    Result result = ResultUtils.getResultFromJson(s, Result.class);
                    L.e(TAG,"result="+result);
                    if (result != null) {
                        if (result.isRetMsg()) {
                            //register success
                            CommonUtils.showLongToast(R.string.register_success);
                            MFGT.finish(RegisterActivity.this);
                        } else {
                            //register fial,username 102
                            CommonUtils.showLongToast(R.string.register_fail_exists);
                        }
                    } else {
                        CommonUtils.showLongToast(R.string.register_fail);
                    }
                }
                dialog.dismiss();
            }

            @Override
            public void onError(String error) {
                dialog.dismiss();
                CommonUtils.showLongToast(error);
            }
        });
    }
}
