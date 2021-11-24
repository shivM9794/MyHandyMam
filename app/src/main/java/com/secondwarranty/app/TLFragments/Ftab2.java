package com.secondwarranty.app.TLFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.card.MaterialCardView;
import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.ChangeDateAndTime.Rescheduledatetimes;
import com.secondwarranty.app.ResponseModel.SelectDates.Result;
import com.secondwarranty.app.ResponseModel.SelectDates.ScheduleDates;
import com.secondwarranty.app.ViewModel.DataViewModel;


public class Ftab2 extends Fragment {

    DataViewModel dataViewModel;
    MaterialCardView card1, card2, card3, card_time1, card_time2, card_time3, card_time4;
    String schedule_date = "", schedule_time = "", dates1 = "", dates2 = "", dates3 = "", order_id = "";
    TextView text_month_day, text_month_day1, text_month_day2, time_slot1, time_slot2, time_slot3, time_slot4;
    Button reschedule_btn;

    public Ftab2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ftab2, container, false);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


        text_month_day = view.findViewById(R.id.text_month_day);
        text_month_day1 = view.findViewById(R.id.text_month_day1);
        text_month_day2 = view.findViewById(R.id.text_month_day2);
        time_slot1 = view.findViewById(R.id.time_slot1);
        time_slot2 = view.findViewById(R.id.time_slot2);
        time_slot3 = view.findViewById(R.id.time_slot3);
        time_slot4 = view.findViewById(R.id.time_slot4);

        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card_time1 = view.findViewById(R.id.card_time1);
        card_time2 = view.findViewById(R.id.card_time2);
        card_time3 = view.findViewById(R.id.card_time3);
        card_time4 = view.findViewById(R.id.card_time4);
        reschedule_btn = view.findViewById(R.id.reschedule_btn);
        reschedule_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changedDateAndTime();
            }
        });

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
//                schedule_time = time_slot2.getText().toString();
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


        return view;

    }

    private void date() {


        dataViewModel.getDates(getActivity(), order_id)
                .observe(getActivity(), new Observer<Result>() {
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


    private void changedDateAndTime() {

        dataViewModel.getRescheduled(getActivity(), schedule_date, schedule_time)
                .observe(getActivity(), new Observer<com.secondwarranty.app.ResponseModel.ChangeDateAndTime.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.ChangeDateAndTime.Result result) {

                        if (result != null) {

                            Rescheduledatetimes rescheduledatetimes = result.getRescheduledatetimes();

                            Intent i = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(i);


                        }
                    }
                });
    }
}



