package com.secondwarranty.app.Cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.secondwarranty.app.Adapter.AddToCartAdapter;
import com.secondwarranty.app.Adapter.BookingAdapter;
import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.Dashboard.FanActivity;
import com.secondwarranty.app.Dashboard.Fan_Date_Time_Activity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.GetCartData.MycartDatum;
import com.secondwarranty.app.ResponseModel.GetCartData.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;

import java.util.List;

public class AddCart extends AppCompatActivity {

    RecyclerView add_toCart_recycler;
    DataViewModel dataViewModel;
    AddToCartAdapter addToCartAdapter;
    Button btn_proceed;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        add_toCart_recycler = findViewById(R.id.add_toCart_recycler);
        add_toCart_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        addToCart();
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void addToCart() {

        dataViewModel.getCartDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.GetCartData.Result>() {
                    @Override
                    public void onChanged(Result result) {

                        if (result != null){

                            List<MycartDatum> mycartData = result.getMycartData();
                            addToCartAdapter = new AddToCartAdapter(mycartData, getApplicationContext());
                            add_toCart_recycler.setAdapter(addToCartAdapter);
                        }

                    }
                });
    }

    public void proceedBooking(View view) {

        Intent intent = new Intent(getApplicationContext(), Fan_Date_Time_Activity.class);
        startActivity(intent);
        finish();
    }
}