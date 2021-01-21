package cc.onion.cosyfans.item.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.item.entity.PhotoModel;
import cc.onion.cosyfans.module_item.R;

/**
 * @author guobihai
 * @created 2019/4/10
 */
public class CoverPagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<PhotoModel> data;
    private OnPagerItemClick  itemClick ;

    public CoverPagerAdapter(Context context, List<PhotoModel> data) {
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View rootView = mInflater.inflate(R.layout.item_cover_page, null);

        ImageView ivCover = rootView.findViewById(R.id.used_house_cell_cover_iv);


        if(StringUtils.isNoneEmpty(data.get(position).getImgUrl())){
            BaseBindingAdapter.loadImageLarge(ivCover,data.get(position).getImgUrl());

        }
        rootView.setOnClickListener(v -> {
            if (itemClick != null){
                itemClick.onPagerItemClick(v,position,data.get(position));
            }
        });
        container.addView(rootView);

        return rootView;
    }

    public interface OnPagerItemClick {

        void onPagerItemClick(View v, int position, PhotoModel item);
    }

    public void setItemClick(OnPagerItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
