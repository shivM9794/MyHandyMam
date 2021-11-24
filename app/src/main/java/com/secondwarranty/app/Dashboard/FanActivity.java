package com.secondwarranty.app.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.secondwarranty.app.Adapter.Srevice_page;
import com.secondwarranty.app.Cart.AddCart;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.AddToCart.Result;
import com.secondwarranty.app.ResponseModel.ProceedButton.OrderplaceData;
import com.secondwarranty.app.ResponseModel.ServicePageDetails.ServiceType;
import com.secondwarranty.app.ResponseModel.ServicePageDetails.Servicepagedetails;
import com.secondwarranty.app.Utility.PreferenceUtility;
import com.secondwarranty.app.ViewModel.DataViewModel;

import java.util.List;

public class FanActivity extends AppCompatActivity implements Srevice_page.OnclickListener {
    ImageView back_arrow;
    Button add_to_cart, proceed;
    RadioButton radioButton1, radioButton2, radioButton3;
    String subCategory = "";
    TextView txt_fan;
    DataViewModel dataViewModel;
    String sub_category_id = "", category_id = "", min_charge = "", service_type = "", order_id = "",esti_range = "",disclaimers = "";
    RecyclerView rec_service;
    Srevice_page srevice_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        subCategory = getIntent().getStringExtra("SubCategory_Name");
        sub_category_id = getIntent().getStringExtra("sub_category_id");
        rec_service = findViewById(R.id.rec_service);
        rec_service.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        radioButton1 = findViewById(R.id.radio_btn1);
        radioButton2 = findViewById(R.id.radio_btn2);
        radioButton3 = findViewById(R.id.radio_btn3);
        txt_fan = findViewById(R.id.txt_fan);
        txt_fan.setText(subCategory);
        back_arrow = findViewById(R.id.back_arrow1);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FanActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
        add_to_cart = findViewById(R.id.add_to_cart);
        proceed = findViewById(R.id.btn_proceed);
        servicePage();
    }

    private void servicePage() {

        dataViewModel.getServiceDetails(getApplicationContext(), sub_category_id)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.ServicePageDetails.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.ServicePageDetails.Result result) {

                        if (result != null) {

                            List<ServiceType> serviceType = result.getServicepagedetails().getServiceType();
                            Servicepagedetails servicepagedetails = result.getServicepagedetails();
                            category_id = String.valueOf(servicepagedetails.getCategoryId());
                            sub_category_id = String.valueOf(servicepagedetails.getSubCategoryId());
                            srevice_page = new Srevice_page(serviceType, getApplicationContext(), FanActivity.this);
                            rec_service.setAdapter(srevice_page);


                        }
                    }
                });
    }

    public void proceedBtn(View view) {

        proceedBooking();
    }

    private void proceedBooking() {

        dataViewModel.getProceedButton(getApplicationContext(), sub_category_id, category_id, service_type, min_charge,esti_range,disclaimers)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.ProceedButton.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.ProceedButton.Result result) {

                        if (result != null) {

                            OrderplaceData orderplaceData = result.getOrderplaceData();
                            order_id = String.valueOf(orderplaceData.getOrderId());
                            Intent intent1 = new Intent(FanActivity.this, Fan_Date_Time_Activity.class);
                            intent1.putExtra("order_id",order_id);
                            PreferenceUtility.setStringValue(getApplicationContext(),PreferenceUtility.order_id,order_id);
                            intent1.putExtra("SubCategory_Name", orderplaceData.getSubCategoryName());
                            startActivity(intent1);
                            finish();

                        }
                    }
                });
    }

    @Override
    public void onClick(String string, String heading,String disclaimer,String est_range) {
        min_charge = string;
        service_type = heading;
        esti_range = est_range;
        disclaimers = disclaimer;
    }

    public void add_Product(View view) {

        Add_ProductTo_Cart();
    }

    private void Add_ProductTo_Cart() {

        dataViewModel.getAddToCartDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.AddToCart.Result>() {
                    @Override
                    public void onChanged(Result result) {

                        if (result != null){

                            Intent i = new Intent(FanActivity.this, AddCart.class);
                            startActivity(i);
                            finish();

                        }

                    }
                });
    }
}