package com.secondwarranty.app.Dashboard;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.secondwarranty.app.R;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Element adsElement = new Element();
        adsElement.setTitle("Join Us");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.sw_about)
                .addItem(new Element().setTitle("Version 1.1"))
                .addItem(adsElement)
                .setDescription("My HandyMan is an online installment & repairing platform where the user will choose the time of installment & repairing according to his/her choice. ")
                .addGroup("Connect with us")
                .addEmail("secondwarranty@gmail.com")
                .addWebsite("https://www.secondwarranty.in/")
                .addFacebook("https://www.facebook.com/SecondWarranty/")
                .addTwitter("Second_Warranty")
//                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.secondwarranty.app")
                .addInstagram("secondWarranty")

                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setAutoApplyIconTint(true);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
//        copyRightsElement.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), copyrights, Toast.LENGTH_SHORT).show();
//            }
//        });
        return copyRightsElement;
    }
}
