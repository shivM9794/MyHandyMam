package com.secondwarranty.app.Payment;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.secondwarranty.app.ConfirmedFragmentsPages.FanInstallmentActivity;
import com.secondwarranty.app.Maps.MapsActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.PaymentOptions.Finalorderplaced;
import com.secondwarranty.app.ResponseModel.SelectDates.Result;
import com.secondwarranty.app.Utility.PreferenceUtility;
import com.secondwarranty.app.ViewModel.DataViewModel;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity {
    TextView reschedule_cancel;
    ImageView razorpay_payment;
    ImageView back;
    RadioButton razorpay_radio_btn,radio_btn_cod;
    DataViewModel dataViewModel;
    String order_id = "", payment_mode = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        razorpay_radio_btn = findViewById(R.id.razorpay_radio);
        radio_btn_cod = findViewById(R.id.radio_btn_cod);
        order_id = getIntent().getStringExtra("order_id");
        back = findViewById(R.id.back_arrow_payment);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
            }
        });
        Checkout.preload(getApplicationContext());
        razorpay_radio_btn = findViewById(R.id.razorpay_radio);
        razorpay_radio_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makepayment();


            }
        });
        reschedule_cancel = findViewById(R.id.reschedule_cancel_txt);
        reschedule_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, FanInstallmentActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void makepayment() {
        Checkout checkout = new Checkout();

        checkout.setKeyID("rzp_test_JuiYmArGmYBP4F");

        checkout.setImage(R.drawable.logo);

        final Activity activity = this;


        try {
            JSONObject options = new JSONObject();

            options.put("name", "Second Warranty");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//                options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "55400");//pass amount in currency subunits
            options.put("prefill.email", "gaurav.kumar@example.com");
            options.put("prefill.contact", "9407106470");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch (Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }

    public void pay_COD(View view) {

        payment_mode = "COD";

        payment_COD();
    }

    private void payment_COD() {

        dataViewModel.getPayment(getApplicationContext(), order_id,payment_mode)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.PaymentOptions.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.PaymentOptions.Result result) {

                        if (result != null) {

                            Finalorderplaced finalorderplaced = result.getFinalorderplaced();

                            Intent intent = new Intent(PaymentActivity.this, FanInstallmentActivity.class);
                            intent.putExtra("Sub_cat",finalorderplaced.getSubCategoryName());
                            PreferenceUtility.setStringValue(getApplicationContext(),PreferenceUtility.order_id,order_id);
                            startActivity(intent);
                            finish();

                        }
                    }
                });
    }
}

//    @Override
//    public void onPaymentSuccess(String s, PaymentData paymentData) {
//        paytext.setText("Successful Payment ID :"+s);
//    }
//
//    @Override
//    public void onPaymentError(int i, String s, PaymentData paymentData) {
//        paytext.setText("Failed and cause is :"+s);
//
//    }
