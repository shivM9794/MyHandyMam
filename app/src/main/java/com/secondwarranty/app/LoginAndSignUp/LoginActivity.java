package com.secondwarranty.app.LoginAndSignUp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.Login.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;

public class LoginActivity extends AppCompatActivity {
    Button login_btn, submit_btn;
    TextView sign_up, forgot_password;
    TextInputEditText ed_password;
    EditText ed_email_address;
    private static final int PERMISSION_READ_STATE = 1;
    boolean isAllFieldsChecked = false;
    DataViewModel dataViewModel;
    String user_email, user_password, user_type = "customer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        }
        ed_email_address = findViewById(R.id.ed_email_address);
        login_btn = findViewById(R.id.login_btn);

        sign_up = findViewById(R.id.btn_signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        forgot_password = findViewById(R.id.txt_forgot_password);


        ed_password = findViewById(R.id.ed_password);
        ed_password.setHint("Password");

    }

//    Validation
    private boolean CheckAllFields() {

        if (ed_email_address.length() == 0) {
            ed_email_address.setError("Email is required");
            return false;
        }
        if (ed_password.length() == 0) {
            ed_password.setError("Password is required");
            return false;
        } else if (ed_password.length() < 8) {
            ed_password.setError("Password must be minimum 8 characters");
            return false;
        }

        return true;
    }

    public void login_button(View view) {
        login_successful();
    }

//    Login Api
    private void login_successful() {
        user_email = ed_email_address.getText().toString();
        user_password = ed_password.getText().toString();


        dataViewModel.getLoginDetails(getApplicationContext(), user_email, user_password, user_type)
                .observe(this, new Observer<Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.Login.Result result) {

                        if (result != null) {


                            isAllFieldsChecked = CheckAllFields();
                            if (isAllFieldsChecked) {
                                Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    }
                });

    }



//    Run Time Permissions
    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_READ_STATE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED && grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[4] == PackageManager.PERMISSION_GRANTED) {

                } else {


                }
            }
            break;
        }

    }



//  Bottom Style Sheet
    public void txt_forgot_password(View view) {


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(LoginActivity.this, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_style_sheet, (LinearLayout) findViewById(R.id.bottomSheetContainer));
        EditText forgot_et_email = bottomSheetView.findViewById(R.id.forgot_et_email);
        bottomSheetView.findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetDialog.dismiss();
                Intent submit = new Intent(getApplicationContext(), ResetPasswordActivity.class);
                startActivity(submit);

                String mail = forgot_et_email.getText().toString();

                otp_sent(mail);
                finish();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

//    Forgot Password Api
    private void otp_sent(String mail) {

        dataViewModel.getForgotPassword(getApplicationContext(),mail)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.ForgotPassword.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.ForgotPassword.Result result) {

                        if (result != null) {

                            Intent intent = new Intent(getApplicationContext(),ResetPasswordActivity.class);
                            intent.putExtra("user_id",result.getUsersData().getUsersId());
                            startActivity(intent);



                        }
                    }
                });

    }
}





