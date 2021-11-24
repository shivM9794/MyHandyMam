package com.secondwarranty.app.TLFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.GetOrderDetails.Orderdetails;
import com.secondwarranty.app.ResponseModel.PaymentOptions.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;


public class Ftab1 extends Fragment {

    TextView address, time_date, payment_history,fan_installment,rupee_symbol,total_amt,safety_fees_amt;
    DataViewModel dataViewModel;
    Integer total_amount;


    public Ftab1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ftab1, container, false);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        address = view.findViewById(R.id.address);
        time_date = view.findViewById(R.id.time_date);
        safety_fees_amt = view.findViewById(R.id.safety_fees_amt);
        payment_history = view.findViewById(R.id.payment_history);
        fan_installment = view.findViewById(R.id.fan_installment);
        rupee_symbol = view.findViewById(R.id.rupee_symbol);
        total_amt = view.findViewById(R.id.total_amt);
        details_order();

        return view;
    }

    private void details_order() {

        dataViewModel.getOrderDetails(getActivity())
                .observe(getActivity(), new Observer<com.secondwarranty.app.ResponseModel.GetOrderDetails.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.GetOrderDetails.Result result) {

                        if (result != null) {
                            Orderdetails orderdetails = result.getOrderdetails();
                            address.setText(orderdetails.getCurrentLocation());
                            payment_history.setText(orderdetails.getPaymentMode());
                            rupee_symbol.setText("₹ "+ orderdetails.getMinCharge());
                            total_amount = Integer.valueOf(orderdetails.getMinCharge()) + 49;
                            total_amt.setText(String.valueOf("₹ "+total_amount));
                            time_date.setText(orderdetails.getDate()+ "," +orderdetails.getTime());

                        }
                    }
                });
    }

}