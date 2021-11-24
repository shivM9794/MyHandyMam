package com.secondwarranty.app.ConfirmedFragmentsPages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.secondwarranty.app.Adapter.PageAdapter;
import com.secondwarranty.app.Payment.PaymentActivity;
import com.secondwarranty.app.R;

public class FanInstallmentActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabItem1, tabItem2, tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    ImageView back;
    String Sub_cat= "";
    TextView txt_profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_installment);
        Sub_cat = getIntent().getStringExtra("Sub_cat");
        back = findViewById(R.id.back_arrow_installment);
        txt_profile = findViewById(R.id.txt_profile);
        txt_profile.setText(Sub_cat);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FanInstallmentActivity.this, PaymentActivity.class);
                startActivity(i);
                finish();
            }
        });
        tabLayout = findViewById(R.id.tablayout);
        tabItem1 = findViewById(R.id.tab1);

        tabItem2 = findViewById(R.id.tab2);
        tabItem3 = findViewById(R.id.tab3);
        viewPager = findViewById(R.id.vpager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}