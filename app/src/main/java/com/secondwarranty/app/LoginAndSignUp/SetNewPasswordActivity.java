package com.secondwarranty.app.LoginAndSignUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.ResetPassword.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;

public class SetNewPasswordActivity extends AppCompatActivity {
    
    TextInputEditText ed_password,ed_password1;
    Button btn_set_password;

    DataViewModel dataViewModel;
    EditText num;
    String pass = "", con_pass = "";
    String users_forgot_password_code = "", user_id = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        user_id = getIntent().getStringExtra("user_id");
        users_forgot_password_code = getIntent().getStringExtra("verification_code");

        ed_password = findViewById(R.id.ed_password);
        ed_password1 = findViewById(R.id.ed_password1);
        btn_set_password = findViewById(R.id.btn_set_password);
    }

    public void updatePassword(View view) {

        pass = ed_password.getText().toString().trim();
        con_pass = ed_password1.getText().toString().trim();

        if (pass.equals("") || con_pass.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();

        } else {
            if (pass.charAt(0) == '-') {
                Toast.makeText(getApplicationContext(), "Password cannot start with -", Toast.LENGTH_LONG).show();
                return;
            } else {

            }
        }

        if (!pass.equals(con_pass)) {
            Toast.makeText(getApplicationContext(), "Passwords do not match!!", Toast.LENGTH_LONG).show();
            return;
        } else {

        }
        newPassword();
    }

    private void newPassword() {

        dataViewModel.getResetPassword(getApplicationContext(), users_forgot_password_code, pass)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.ResetPassword.Result>() {

                    @Override
                    public void onChanged(Result result) {

                        Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        finish();

                    }
                });
    }
    }
