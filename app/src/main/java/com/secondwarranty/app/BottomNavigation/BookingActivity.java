package com.secondwarranty.app.BottomNavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.secondwarranty.app.Adapter.BookingAdapter;
import com.secondwarranty.app.Adapter.HomeApplianceAdapter;
import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.Bookings.MybookingDatum;
import com.secondwarranty.app.ResponseModel.GetUserDetails.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;

import java.util.List;

public class BookingActivity extends AppCompatActivity {
    ImageView back_icon;
    DataViewModel dataViewModel;
    RecyclerView booking_recycler;
    BookingAdapter bookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        booking_recycler = findViewById(R.id.booking_recycler);
        booking_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        back_icon = findViewById(R.id.back_arrow);
        back_icon.setOnClickListener(view -> {
            Intent intent = new Intent(BookingActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });
        bookingStatus();
    }

    private void bookingStatus() {

        dataViewModel.getBookingDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.Bookings.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.Bookings.Result result) {

                        if (result != null) {

                            List<MybookingDatum> mybookingDatum = result.getMybookingData();
                            bookingAdapter = new BookingAdapter(mybookingDatum, getApplicationContext());
                            booking_recycler.setAdapter(bookingAdapter);


                        }
                    }
                });
    }
}


