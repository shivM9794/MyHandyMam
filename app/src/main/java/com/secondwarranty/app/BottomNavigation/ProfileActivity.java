package com.secondwarranty.app.BottomNavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.google.android.material.navigation.NavigationView;
import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.GetUserDetails.UsersData;
import com.secondwarranty.app.ResponseModel.SelectDates.Result;
import com.secondwarranty.app.ViewModel.DataViewModel;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class ProfileActivity extends AppCompatActivity {

    ImageView back_icon;
    SmoothBottomBar bottomNavigationView;
    EditText profile_full_name,profile_mobile_no,profile_email_address,profile_address,profile_landmark,et_email_address;
    DataViewModel dataViewModel;
    String users_name = "", users_email = "", users_mobile = "",users_type = "customer",users_address="",users_pincode="",users_landmark="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        profile_full_name = findViewById(R.id.profile_full_name);
        profile_mobile_no = findViewById(R.id.profile_mobile_no);
        profile_email_address = findViewById(R.id.profile_email_address);
        profile_address = findViewById(R.id.profile_address);
        profile_landmark = findViewById(R.id.profile_landmark);
        et_email_address = findViewById(R.id.et_email_address);
        back_icon = findViewById(R.id.back_arrow);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            switch (i) {


                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), BookingActivity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent2);
                    break;

//                case 3:
//                    Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
//                    startActivity(intent);
//                    break;


            }

            return true;
        });

        fetchUserDetails();

    }

    private void fetchUserDetails() {

        dataViewModel.getUserDetail(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.GetUserDetails.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.GetUserDetails.Result result) {

                        if (result != null) {

                            UsersData usersData = result.getUsersData();
                            profile_full_name.setText(usersData.getUsersName());
                            profile_mobile_no.setText(usersData.getUsersMobile());
                            profile_email_address.setText(usersData.getUsersEmail());

                        }
                    }
                });
    }

    public void saveUserProfile(View view) {

        updateUserProfile();
    }

    private void updateUserProfile() {

      users_name =  profile_full_name.getText().toString();
      users_mobile =  profile_mobile_no.getText().toString();
      users_email =  profile_email_address.getText().toString();
      users_address =  profile_address.getText().toString();
       users_landmark = profile_landmark.getText().toString();
      users_pincode =  et_email_address.getText().toString();

        dataViewModel.getUpdatedProfile(getApplicationContext(),users_name,users_email,users_mobile,users_type,users_address,users_landmark,users_pincode)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.UpdateUserProfile.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.UpdateUserProfile.Result result) {

                        if (result != null) {

                            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    }
                });
    }
}





