package com.secondwarranty.app.TLFragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.Cancellation.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;


public class Ftab3 extends Fragment {
    Button cancel;
    DataViewModel dataViewModel;
    String cancellation_reason = "";
    RadioButton radio_btn1, radio_btn2, radio_btn3, radio_btn4, radio_btn5, radio_btn6, radio_btn7;
    RadioGroup radio_grp;


    public Ftab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ftab3, container, false);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        cancel = view.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cancellation_btn();
            }
        });
        radio_btn1 = view.findViewById(R.id.radio_btn1);
        radio_btn2 = view.findViewById(R.id.radio_btn2);
        radio_btn3 = view.findViewById(R.id.radio_btn3);
        radio_btn4 = view.findViewById(R.id.radio_btn4);
        radio_btn5 = view.findViewById(R.id.radio_btn5);
        radio_btn6 = view.findViewById(R.id.radio_btn6);
        radio_btn7 = view.findViewById(R.id.radio_btn7);
        radio_grp = view.findViewById(R.id.radio_grp);
        radio_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Log.e("RejectBookingResponse", "a");
                if (radio_btn1.isChecked()) {
                    cancellation_reason = radio_btn1.getText().toString();
                } else if (radio_btn2.isChecked()) {
                    cancellation_reason = radio_btn2.getText().toString();
                } else if (radio_btn3.isChecked()) {
                    cancellation_reason = radio_btn3.getText().toString();
                } else if (radio_btn4.isChecked()) {
                    cancellation_reason = radio_btn4.getText().toString();
                } else if (radio_btn5.isChecked()) {
                    cancellation_reason = radio_btn5.getText().toString();
                } else if (radio_btn6.isChecked()) {
                    cancellation_reason = radio_btn6.getText().toString();
                }

            }
        });


        return view;


    }

    public void cancellation_btn() {

        dataViewModel.getCancellation(getActivity(), cancellation_reason)
                .observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.Cancellation.Result result) {

                        if (result != null) {

                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);


                        }
                    }
                });
    }

}