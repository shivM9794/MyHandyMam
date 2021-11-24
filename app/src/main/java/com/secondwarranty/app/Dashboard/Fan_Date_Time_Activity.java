package com.secondwarranty.app.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.card.MaterialCardView;
import com.secondwarranty.app.Maps.MapsActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.SelectDates.Result;
import com.secondwarranty.app.ResponseModel.SelectDates.ScheduleDates;
import com.secondwarranty.app.ResponseModel.SelectDates.SelectDateResponse;
import com.secondwarranty.app.ViewModel.DataViewModel;

public class Fan_Date_Time_Activity extends AppCompatActivity {
    Button btn_continue;
    ImageView imageView;
    MaterialCardView card1, card2, card3, card_time1, card_time2, card_time3, card_time4;
    DataViewModel dataViewModel;
    String order_id = "", schedule_date = "", schedule_time = "",dates1="",dates2="",dates3="";
    TextView text_month_day,text_month_day1,text_month_day2,date,date1,date2,time_slot1,time_slot2,time_slot3,time_slot4,txt_fan;
    String subCategory = "",sub_category_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_date_time);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        subCategory = getIntent().getStringExtra("SubCategory_Name");
        txt_fan = findViewById(R.id.txt_fan);
        txt_fan.setText(subCategory);


        text_month_day = findViewById(R.id.text_month_day);
        text_month_day1 = findViewById(R.id.text_month_day1);
        text_month_day2 = findViewById(R.id.text_month_day2);
//        date = findViewById(R.id.date);
//        date1 = findViewById(R.id.date1);
//        date2 = findViewById(R.id.date2);
        time_slot1 = findViewById(R.id.time_slot1);
        time_slot2 = findViewById(R.id.time_slot2);
        time_slot3= findViewById(R.id.time_slot3);
        time_slot4 = findViewById(R.id.time_slot4);
        btn_continue = findViewById(R.id.continue_btn);
        order_id = getIntent().getStringExtra("order_id");
        imageView = findViewById(R.id.back_arrow2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fan_Date_Time_Activity.this, FanActivity.class);
                startActivity(intent);
                finish();
            }
        });
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card_time1 = findViewById(R.id.card_time1);
        card_time2 = findViewById(R.id.card_time2);
        card_time3 = findViewById(R.id.card_time3);
        card_time4 = findViewById(R.id.card_time4);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card3.setStrokeColor(getResources().getColor(R.color.gray_color));
                schedule_date = dates1;
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card2.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card3.setStrokeColor(getResources().getColor(R.color.gray_color));
                schedule_date = dates2;
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card3.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                schedule_date = dates3;
            }
        });
        card_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card_time2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time3.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time4.setStrokeColor(getResources().getColor(R.color.gray_color));
                schedule_time = time_slot1.getText().toString();
            }
        });
        card_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time2.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card_time3.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time4.setStrokeColor(getResources().getColor(R.color.gray_color));
                schedule_time = time_slot2.getText().toString();
            }
        });
        card_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time3.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                card_time4.setStrokeColor(getResources().getColor(R.color.gray_color));
                schedule_time = time_slot3.getText().toString();
            }
        });
        card_time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_time1.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time2.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time3.setStrokeColor(getResources().getColor(R.color.gray_color));
                card_time4.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                schedule_time = time_slot4.getText().toString();
            }
        });
        date();

    }

    private void date() {

        dataViewModel.getDates(getApplicationContext(), order_id)
                .observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.SelectDates.Result result) {

                        if (result != null) {
                            ScheduleDates selectDateResponse = result.getScheduleDates();
                            text_month_day.setText(selectDateResponse.getDate1());
                            dates1 = selectDateResponse.getDate1();
                            dates2 = selectDateResponse.getDate2();
                            dates3 = selectDateResponse.getDate3();
                            text_month_day1.setText(selectDateResponse.getDate2());
                            text_month_day2.setText(selectDateResponse.getDate3());


                        }

                    }
                });
    }


    public void continueBtn(View view) {

        selectDate_Time();
    }

    private void selectDate_Time() {

        dataViewModel.getTimeAndDate(getApplicationContext(), order_id, schedule_date, schedule_time)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.Result result) {

                        if (result != null) {

                            Intent i = new Intent(Fan_Date_Time_Activity.this, MapsActivity.class);
                            i.putExtra("order_id",order_id);
                            startActivity(i);
                            finish();

                        }
                    }
                });
    }
}