package com.secondwarranty.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.secondwarranty.app.Dashboard.FanActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.HomePageProducts.Categorydatum;
import com.secondwarranty.app.ResponseModel.HomePageProducts.Subcategorydatum;

import java.util.ArrayList;
import java.util.List;

public class HomeApplianceAdapter extends RecyclerView.Adapter<HomeApplianceAdapter.HomeApplianceViewHolder> {

    List<Subcategorydatum> subcategorydata;
    Context context;
    String BASE_URL = "https://apkconnectlab.com/secondwarranty/";

    public HomeApplianceAdapter(List<Subcategorydatum> subcategorydata,Context context) {
        this.subcategorydata = subcategorydata;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeApplianceAdapter.HomeApplianceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_applicances, parent, false);
        HomeApplianceAdapter.HomeApplianceViewHolder homeApplianceViewHolder = new HomeApplianceViewHolder(view);
        return homeApplianceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeApplianceAdapter.HomeApplianceViewHolder holder, int position) {
        Subcategorydatum categorydatum = subcategorydata.get(position);
        Glide.with(context).load(BASE_URL + categorydatum.getSubCategoryAppImage()).into(holder.imageView);
        holder.textView.setText(categorydatum.getSubCategoryName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(context, FanActivity.class);
                    intent.putExtra("SubCategory_Name",categorydatum.getSubCategoryName());
                    intent.putExtra("sub_category_id",String.valueOf(categorydatum.getSubCategoryId()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return subcategorydata.size();
    }

    public class HomeApplianceViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public HomeApplianceViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_cardview);
            textView = itemView.findViewById(R.id.txt_cardview);
        }
    }
}
