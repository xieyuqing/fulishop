package cn.ucai.fulicenter.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/1/11 0011.
 */

public class FooterViewHolder extends RecyclerView.ViewHolder{
    private String footerString;

    public FooterViewHolder(View view) {
            super(view);
        }

    public void setFooterString(String footerString) {
        this.footerString = footerString;
    }
}
