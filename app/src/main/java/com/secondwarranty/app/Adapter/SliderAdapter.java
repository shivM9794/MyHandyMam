package com.secondwarranty.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.HomePageProducts.BannerDatum;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {

    List<BannerDatum> bannerData;
    String BASE_URL = "https://apkconnectlab.com/secondwarranty/";
    Context context;

    public SliderAdapter(List<BannerDatum> bannerDatum, Context context) {
        this.bannerData = bannerDatum;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider, parent, false);
        SliderAdapter.ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Glide.with(context).load(BASE_URL + bannerData.get(position).getImage()).into(viewHolder.slider_img);

    }

    @Override
    public int getCount() {
        return bannerData.size();
    }

    public class ViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView slider_img;

        public ViewHolder(View itemView) {
            super(itemView);
            slider_img = itemView.findViewById(R.id.slider);
        }
    }
}
