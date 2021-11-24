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
import com.secondwarranty.app.ResponseModel.HomePageProducts.Subcategorydatum;

import java.util.ArrayList;
import java.util.List;

public class IndustryApplianceAdapter extends RecyclerView.Adapter<IndustryApplianceAdapter.IndustryApplianceViewHolder> {

    List<Subcategorydatum> subcategorydata;
    Context context;
    String BASE_URL = "https://apkconnectlab.com/secondwarranty/";

    public IndustryApplianceAdapter(List<Subcategorydatum> subcategorydata, Context context) {
        this.subcategorydata = subcategorydata;
        this.context = context;
    }

    @NonNull
    @Override
    public IndustryApplianceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.industry_appliances, parent, false);
        IndustryApplianceAdapter.IndustryApplianceViewHolder industryApplianceViewHolder = new IndustryApplianceViewHolder(view);
        return industryApplianceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IndustryApplianceViewHolder holder, int position) {
        Subcategorydatum subcategorydatum = subcategorydata.get(position);
        Glide.with(context).load(BASE_URL + subcategorydatum.getSubCategoryAppImage()).into(holder.imageView);
        holder.textView.setText(subcategorydatum.getSubCategoryName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FanActivity.class);
                intent.putExtra("SubCategory_Name",subcategorydatum.getSubCategoryName());
                intent.putExtra("sub_category_id",String.valueOf(subcategorydatum.getSubCategoryId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return subcategorydata.size();
    }

    public class IndustryApplianceViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public IndustryApplianceViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_industry_cardview);
            textView = itemView.findViewById(R.id.txt_industry_cardview);
        }
    }
}
