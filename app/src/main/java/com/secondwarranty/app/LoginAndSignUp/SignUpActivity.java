package com.secondwarranty.app.LoginAndSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;

public class SignUpActivity extends AppCompatActivity {
    TextView login_txt;
    TextInputEditText pass, cnf_pass;
    Button sign_up;
    EditText full_name, mobile_no, email_address;
    CountryCodePicker cpp;
    RadioGroup radioGroup;
    RadioButton radio_btn_male, radio_btn_female, radio_btn_others;
    DataViewModel dataViewModel;
    String full_names, mobile, email_addresss, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        login_txt = findViewById(R.id.txt_login);
        login_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        pass = findViewById(R.id.pass);
        pass.setHint("Password");
        cnf_pass = findViewById(R.id.pass_cnf);
        cnf_pass.setHint("Confirm Password");
        sign_up = findViewById(R.id.sign_up_btn);

        full_name = findViewById(R.id.ed_full_name);
        mobile_no = findViewById(R.id.et_mobile_no);
        email_address = findViewById(R.id.et_email_address);
        cpp = findViewById(R.id.cpp);
//        radioGroup = findViewById(R.id.radio_grp_gender);
//        radio_btn_male = findViewById(R.id.radio_btn_male);
//        radio_btn_female = findViewById(R.id.radio_btn_female);
//        radio_btn_others = findViewById(R.id.radio_btn_others);
    }

//    SignUp Api
    private void signUp_verification() {

        full_names = full_name.getText().toString();
        mobile = mobile_no.getText().toString();
        email_addresss = email_address.getText().toString();
        password = pass.getText().toString();

        dataViewModel.getDetails(getApplicationContext(), full_names, mobile, email_addresss, password)
                .observe(this, new Observer<Result>() {
            @Override
            public void onChanged(Result result) {

                if (result != null) {

                    Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();


                }
            }
        });
    }

    public void btn_Submit(View view) {
        signUp_verification();
    }
}