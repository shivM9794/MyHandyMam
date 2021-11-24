package com.secondwarranty.app.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.secondwarranty.app.Dashboard.FanActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.HomePageProducts.Subcategorydatum;
import com.secondwarranty.app.ResponseModel.ServicePageDetails.ServiceType;

import java.util.List;

public class Srevice_page extends RecyclerView.Adapter<Srevice_page.HomeApplianceViewHolder> {


    List<ServiceType> serviceType;
    Context context;
    public OnclickListener onclickListener;

    public Srevice_page(List<ServiceType> serviceType,Context context, OnclickListener onclickListener) {
        this.serviceType = serviceType;
        this.context = context;
        this.onclickListener = onclickListener;
    }

    @NonNull
    @Override
    public Srevice_page.HomeApplianceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_service, parent, false);
        Srevice_page.HomeApplianceViewHolder homeApplianceViewHolder = new Srevice_page.HomeApplianceViewHolder(view);
        return homeApplianceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Srevice_page.HomeApplianceViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.fan_not_working.setText(serviceType.get(position).getEstimateRange());
        holder.disclaimer_txt.setText(serviceType.get(position).getDisclaimer());
        holder.radio_btn1.setText(serviceType.get(position).getHeading()   +  "  Min Charges ₹ "+  serviceType.get(position).getMinCharge());
        holder.radio_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onclickListener.onClick(String.valueOf(serviceType.get(position).getMinCharge()),serviceType.get(position).getHeading(),serviceType.get(position).getDisclaimer(),serviceType.get(position).getEstimateRange());
            }
        });
        holder.radio_btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    holder.materialCardView2.setVisibility(View.VISIBLE);
                }
                else {
                    holder.materialCardView2.setVisibility(View.GONE);

                }
            }
        });



    }

    @Override
    public int getItemCount() {

        return serviceType.size();
    }

    public class HomeApplianceViewHolder extends RecyclerView.ViewHolder {

        TextView textView,fan_not_working,disclaimer_txt,fan_speed_low;
        RadioButton radio_btn1;
        MaterialCardView materialCardView1, materialCardView2;


        public HomeApplianceViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.repair_range_txt);
            fan_not_working = itemView.findViewById(R.id.fan_not_working);
//            fan_speed_low = itemView.findViewById(R.id.fan_speed_low);
            disclaimer_txt = itemView.findViewById(R.id.disclaimer_txt);
            radio_btn1 = itemView.findViewById(R.id.radio_btn1);
            materialCardView1 = itemView.findViewById(R.id.materialCardView);
            materialCardView2 = itemView.findViewById(R.id.materialCardView2);



        }
    }
    public interface OnclickListener{

        public void onClick(String string,String heading,String disclaimer,String est_range);

    }
}
