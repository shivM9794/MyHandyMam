package com.secondwarranty.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.secondwarranty.app.Dashboard.DashboardActivity;
import com.secondwarranty.app.LoginAndSignUp.LoginActivity;
import com.secondwarranty.app.Utility.PreferenceUtility;

public class MainActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (PreferenceUtility.getBoolValue(getApplicationContext(), PreferenceUtility.isLogin)) {

                    Intent intent1 = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent1);
                    finish();
                } else {
                    Intent i = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }


        }, 2000);
    }
}