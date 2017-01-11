package cn.ucai.fulicenter.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.model.bean.NewGoodsBean;
import cn.ucai.fulicenter.model.utils.ImageLoader;
import cn.ucai.fulicenter.view.FooterViewHolder;

/**
 * Created by Administrator on 2017/1/11 0011.
 */

public class GoodsAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<NewGoodsBean> mList;
    boolean isMore;

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
        notifyDataSetChanged();
    }

    public GoodsAdapter(Context context, ArrayList<NewGoodsBean> list) {
        mContext = context;
        mList = new ArrayList<>();
        mList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == I.TYPE_FOOTER) {
            holder = new FooterViewHolder(View.inflate(mContext, R.layout.item_footer, null));
        } else {
            holder = new GoodsViewHolder(View.inflate(mContext, R.layout.item_goods, null));
        }
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == I.TYPE_FOOTER) {
            FooterViewHolder vh = (FooterViewHolder) holder;
            vh.setFooterString(mContext.getString(getFooterString()));
        } else {
            GoodsViewHolder vh= (GoodsViewHolder) holder;
            ImageLoader.downloadImg(mContext,vh.mIvGoodsThumb,mList.get(position).getGoodsThumb());
            vh.mTvGoodsName.setText(mList.get(position).getGoodsName());
            vh.mTvGoodsPrice.setText(mList.get(position).getCurrencyPrice());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return  I.TYPE_FOOTER;
        }
        return I.TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void initData(ArrayList<NewGoodsBean> list) {
        if (mList != null) {
            mList.clear();
        }
       addData(list);
    }

    public void addData(ArrayList<NewGoodsBean> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public int getFooterString() {

        return isMore?R.string.load_more:R.string.no_more;
    }

    static class GoodsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ivGoodsThumb)
        ImageView mIvGoodsThumb;
        @BindView(R.id.tvGoodsName)
        TextView mTvGoodsName;
        @BindView(R.id.tvGoodsPrice)
        TextView mTvGoodsPrice;
        @BindView(R.id.layout_goods)
        LinearLayout mLayoutGoods;

        GoodsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
