package com.secondwarranty.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.GetCartData.MycartDatum;

import java.util.List;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.AddToCartViewHolder> {

    List<MycartDatum> mycartData;
    Context context;

    public AddToCartAdapter(List<MycartDatum> mycartData, Context context) {
        this.mycartData = mycartData;
        this.context = context;
    }

    @NonNull
    @Override
    public AddToCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_to_cart, parent, false);
        AddToCartAdapter.AddToCartViewHolder addToCartViewHolder = new AddToCartAdapter.AddToCartViewHolder(view);
        return addToCartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddToCartViewHolder holder, int position) {
        MycartDatum mycartDatum = mycartData.get(position);
        holder.sw_id.setText("Job ID :"+ mycartDatum.getSequenceOrderId());
        holder.pending_txt1.setText("Product Details :"+ mycartDatum.getSubCategoryName()+ "( "+ mycartDatum.getServiceType() + " )");
        holder.date_of_booking.setText(mycartDatum.getDate());
        holder.time_slot.setText(mycartDatum.getTime());

    }

    @Override
    public int getItemCount() {
        return mycartData.size();
    }

    public class AddToCartViewHolder extends RecyclerView.ViewHolder {

        TextView sw_id,pending_txt1,pending_txt4,date_of_booking,time_slot;
        public AddToCartViewHolder(@NonNull View itemView) {
            super(itemView);

            sw_id = itemView.findViewById(R.id.sw_id);
            pending_txt1 = itemView.findViewById(R.id.pending_txt1);
            pending_txt4 = itemView.findViewById(R.id.pending_txt4);
            date_of_booking = itemView.findViewById(R.id.date_of_booking);
            time_slot = itemView.findViewById(R.id.time_slot);

        }
    }
}
