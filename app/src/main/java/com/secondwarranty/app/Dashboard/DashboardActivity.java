package com.secondwarranty.app.Dashboard;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.drjacky.imagepicker.ImagePicker;
import com.google.android.material.navigation.NavigationView;
import com.secondwarranty.app.Adapter.HomeApplianceAdapter;
import com.secondwarranty.app.Adapter.IndustryApplianceAdapter;
import com.secondwarranty.app.Adapter.SliderAdapter;
import com.secondwarranty.app.BottomNavigation.BookingActivity;
import com.secondwarranty.app.BottomNavigation.ProfileActivity;
import com.secondwarranty.app.LoginAndSignUp.LoginActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.HomePageProducts.BannerDatum;
import com.secondwarranty.app.ResponseModel.HomePageProducts.Subcategorydatum;
import com.secondwarranty.app.ResponseModel.SearchBox.Result;
import com.secondwarranty.app.ResponseModel.SideNavDetails.Userdetails;
import com.secondwarranty.app.ViewModel.DataViewModel;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String APP_NAME = "Second Warranty";
    SliderView sliderView;
    RecyclerView.Adapter adapter;
    RecyclerView homeApplianceRecycler, industryApplianceRecycler;
    SmoothBottomBar bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;
    Button logout;
//    CircleImageView circular_img;
    DataViewModel dataViewModel;
    String profile = "", search_text = "";
    TextView name_txt, txt_mobile_no,txt_industry_appliance,home_applicanes_txt;
    EditText search_box;
    View view1,view2;
    final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");
    String BASE_URL = "https://apkconnectlab.com/secondwarranty/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initViwes();
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


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
            }

            return true;
        });


        homeAppliance();
        industryAppliance();
        navigationdrawer();
        side_nav_details();
//        searchItems();


    }

    private void searchItems() {

        dataViewModel.getSearchDetails(getApplicationContext(), search_text)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.SearchBox.Result>() {
                    @Override
                    public void onChanged(Result result) {

                        if (result != null) {

                        }

                    }
                });
    }


    private void side_nav_details() {

        dataViewModel.getCustomerDetail(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.SideNavDetails.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.SideNavDetails.Result result) {

                        if (result != null) {

                            Userdetails userdetails = result.getUserdetails();
                            name_txt.setText(userdetails.getUsersName());
                            txt_mobile_no.setText(String.valueOf(userdetails.getUsersMobile()));

                        }
                    }
                });
    }

    private void initViwes() {
        sliderView = findViewById(R.id.slider_image);
        homeApplianceRecycler = findViewById(R.id.recycler_home_applicanes);
        industryApplianceRecycler = findViewById(R.id.recycler_industry_appliances);
        drawerLayout = findViewById(R.id.drawer_layout);
        imageView = findViewById(R.id.menu);
        navigationView = findViewById(R.id.navigation_view);
        txt_industry_appliance = findViewById(R.id.txt_industry_appliance);
        home_applicanes_txt = findViewById(R.id.home_applicanes_txt);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        logout = findViewById(R.id.logout_btn);
//        circular_img = findViewById(R.id.circular_img);
        search_box = findViewById(R.id.search_box);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        View navHeaderView = navigationView.getHeaderView(0);
        name_txt = navHeaderView.findViewById(R.id.name_txt);
        txt_mobile_no = navHeaderView.findViewById(R.id.txt_mobile_no);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

//            Uri uri = data.getData();
//            profile = String.valueOf(uri);
//            circular_img.setImageURI(uri);

            Uri selectedImage = data.getData();

            List<MultipartBody.Part> files = new ArrayList<>();

            profile = FilePath.getPath(getApplicationContext(), selectedImage);

            if (profile != null && !profile.isEmpty()) {
                File panFile = new File(profile);
                files.add(MultipartBody.Part.createFormData("users_image",
                        panFile.getName(),
                        RequestBody.create(panFile, MEDIA_TYPE_PNG)));

                updateProfilePic(files);

            }
            else{
                Toast.makeText(getApplicationContext(),"image not found",Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void navigationdrawer() {

        //navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.partner);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);


                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.share_second_warranty:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareSubject = "My HandyMan";
                String shareBodyText = "https://play.google.com/store/apps/details?id=com.secondwarranty.app";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.rate_second_warranty:
                rateApp();
                break;


            case R.id.about_second_warranty:
                Intent intent1 = new Intent(getApplicationContext(), About_Us.class);
                startActivity(intent1);
                break;

            case R.id.help_centre:
                Intent intent2 = new Intent(getApplicationContext(), HelpCentreActivity.class);
                startActivity(intent2);
                break;

            case R.id.schedule_second_warranty:
                Intent intent3 = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent3);
                break;

            case R.id.setting_second_warranty:
                Intent intent4 = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent4);
                break;


        }
        return true;
    }

    public void rateApp()
    {
        try
        {
            Intent rateIntent = rateIntentForUrl("market://details");
            startActivity(rateIntent);
        }
        catch (ActivityNotFoundException e)
        {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details?id=com.secondwarranty.app");
            startActivity(rateIntent);
        }
    }

    private Intent rateIntentForUrl(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21)
        {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        }
        else
        {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }


    private void industryAppliance() {

        dataViewModel.getHomeDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.HomePageProducts.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.HomePageProducts.Result result) {

                        if (result != null) {

                            txt_industry_appliance.setVisibility(View.VISIBLE);
                            view2.setVisibility(View.VISIBLE);
                            industryApplianceRecycler.setHasFixedSize(true);
                            industryApplianceRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                            List<Subcategorydatum> subcategorydata = result.getCategorydata().get(1).getSubcategorydata();
                            Log.e("HomePageResponse", "Response: " + subcategorydata.size());
                            adapter = new IndustryApplianceAdapter(subcategorydata, getApplicationContext());
                            industryApplianceRecycler.setAdapter(adapter);
                        }
                    }
                });
    }

    private void homeAppliance() {

        dataViewModel.getHomeDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.HomePageProducts.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.HomePageProducts.Result result) {

                        if (result != null) {
                            List<BannerDatum> bannerDatum = result.getBannerData();
                            SliderAdapter sliderAdapter = new SliderAdapter(bannerDatum, getApplicationContext());
                            sliderView.setSliderAdapter(sliderAdapter);
                            sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
                            sliderView.setScrollTimeInSec(3);
                            sliderView.setAutoCycle(true);
                            sliderView.startAutoCycle();
                        }

                        home_applicanes_txt.setVisibility(View.VISIBLE);
                        view1.setVisibility(View.VISIBLE);

                        homeApplianceRecycler.setHasFixedSize(true);
                        homeApplianceRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                        List<Subcategorydatum> categorydata = result.getCategorydata().get(0).getSubcategorydata();
                        Log.e("HomePageResponse", "Response: " + categorydata.size());
                        adapter = new HomeApplianceAdapter(categorydata, getApplicationContext());
                        homeApplianceRecycler.setAdapter(adapter);
                    }
                });
    }


    public void logout_button(View view) {
        logout_successful();
    }


    //  Logout Api
    private void logout_successful() {

        dataViewModel.getLogoutDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.Logout.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.Logout.Result result) {

                        if (result != null) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                            builder.setTitle("Second Warranty");
                            builder.setMessage("Are you sure you want to exit ?");
                            builder.setCancelable(false);
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent1);
                                    finish();

                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            builder.create().show();
                        }
                    }
                });
    }


    public void setProfile(View view) {

        ImagePicker.Companion.with(DashboardActivity.this)
                .crop()
                .cropOval()
                .maxResultSize(1080, 1080)
                .start(0);
    }

    private void updateProfilePic(List<MultipartBody.Part> files) {

        Toast.makeText(getApplicationContext(), "Enter", Toast.LENGTH_SHORT).show();

        dataViewModel.getImageDetails(getApplicationContext(), files)
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.DashboardProfileImage.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.DashboardProfileImage.Result result) {

                        if (result != null) {

//                            Glide.with(getApplicationContext()).load(BASE_URL + result.getUsersData().getUsersImage()).into(circular_img);

                        }


                    }
                });
    }
}

