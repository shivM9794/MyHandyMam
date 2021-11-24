package com.secondwarranty.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.Bookings.MybookingDatum;

import java.util.List;



public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    List<MybookingDatum> mybookingData;
    Context context;
    String BASE_URL = "https://apkconnectlab.com/secondwarranty/";

    public BookingAdapter(List<MybookingDatum> mybookingData, Context context) {
        this.mybookingData = mybookingData;
        this.context = context;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_status, parent, false);
        BookingAdapter.BookingViewHolder bookingViewHolder = new BookingAdapter.BookingViewHolder(view);
        return bookingViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        MybookingDatum mybookingDatum = mybookingData.get(position);
        holder.fan_installment.setText(mybookingDatum.getSubCategoryName());
        holder.fan_installment_date_time.setText(mybookingDatum.getDate() + " at " + mybookingDatum.getTime());

    }

    @Override
    public int getItemCount() {
        return mybookingData.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder {

        TextView fan_installment,fan_installment_date_time;
        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);

            fan_installment = itemView.findViewById(R.id.fan_installment);
            fan_installment_date_time = itemView.findViewById(R.id.fan_installment_date_time);
        }
    }
}
