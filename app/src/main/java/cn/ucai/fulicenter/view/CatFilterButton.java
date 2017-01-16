package cn.ucai.fulicenter.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.controller.activity.CategoryChildActivity;
import cn.ucai.fulicenter.model.bean.CategoryChildBean;
import cn.ucai.fulicenter.model.utils.ImageLoader;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class CatFilterButton extends Button {
    boolean isExpan;
    PopupWindow mPopupWindow;
    Context mContext;
    CatFileterAdapter adapter;
    GridView mGirdView;
    String groupName;

    public CatFilterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void initCatFileterButtom(String groupName, ArrayList<CategoryChildBean> list) {
        this.groupName = groupName;
        this.setText(groupName);
        setCatFilterButtonListener();
        adapter = new CatFileterAdapter(mContext,list);
        initGirdView();
    }

    private void initGirdView() {
        mGirdView = new GridView(mContext);
        mGirdView.setVerticalSpacing(10);
        mGirdView.setHorizontalSpacing(10);
        mGirdView.setNumColumns(GridView.AUTO_FIT);
        mGirdView.setAdapter(adapter);
    }

    private void setCatFilterButtonListener() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExpan) {
                    initPopup();
                } else {
                    if (mPopupWindow.isShowing()) {
                        mPopupWindow.dismiss();
                    }
                }
                setArrow();
            }
        });
    }

    private void initPopup() {
        mPopupWindow = new PopupWindow();
        mPopupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0xbb000000));
        mPopupWindow.setContentView(mGirdView);
        mPopupWindow.showAsDropDown(this);
    }

    private void setArrow() {
        Drawable right;
        if (isExpan) {
            right = getResources().getDrawable(R.mipmap.arrow2_up);
        } else {
            right = getResources().getDrawable(R.mipmap.arrow2_down);
        }
        right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, right, null);
        isExpan = !isExpan;
    }

    class CatFileterAdapter extends BaseAdapter {
        Context context;
        ArrayList<CategoryChildBean> list;

        public CatFileterAdapter(Context context, ArrayList<CategoryChildBean> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CategoryChildBean getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            CatFileterViewHolder vh = null;
            if (view == null) {
                view = View.inflate(context, R.layout.item_cat_filter, null);
                vh = new CatFileterViewHolder(view);
                view.setTag(vh);
            } else {
                vh = (CatFileterViewHolder) view.getTag();
            }
            vh.bind(position);
            return view;
        }

         class CatFileterViewHolder {
            @BindView(R.id.ivCategoryChildThumb)
            ImageView mIvCategoryChildThumb;
            @BindView(R.id.tvCategoryChildName)
            TextView mTvCategoryChildName;
            @BindView(R.id.layout_category_child)
            RelativeLayout mLayoutCategoryChild;

             CatFileterViewHolder(View view) {
                ButterKnife.bind(this, view);
            }

             public void bind(final int position) {
                 ImageLoader.downloadImg(context,mIvCategoryChildThumb,list.get(position).getImageUrl());
                 mTvCategoryChildName.setText(list.get(position).getName());
                 mLayoutCategoryChild.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         MFGT.gotoCategoryChild(context,
                                 list.get(position).getId(),
                                 groupName,
                                 list);
                         MFGT.finish((CategoryChildActivity)mContext);
                     }
                 });
             }
         }
    }

}
