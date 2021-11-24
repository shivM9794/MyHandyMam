package com.secondwarranty.app.Repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.secondwarranty.app.ResponseModel.AddToCart.AddToCartResponse;
import com.secondwarranty.app.ResponseModel.Bookings.BookingsResponseClass;
import com.secondwarranty.app.ResponseModel.Cancellation.CancellationResponse;
import com.secondwarranty.app.ResponseModel.ChangeDateAndTime.ChangeDateTimeResponse;
import com.secondwarranty.app.ResponseModel.DashboardProfileImage.DashboardImageResponse;
import com.secondwarranty.app.ResponseModel.ForgotPassword.ForgotPasswordResponse;
import com.secondwarranty.app.ResponseModel.GetCartData.GetCartDataResponse;
import com.secondwarranty.app.ResponseModel.GetOrderDetails.OrderDetailsResponse;
import com.secondwarranty.app.ResponseModel.GetUserDetails.GetUserDetailsResponse;
import com.secondwarranty.app.ResponseModel.HelpCentreSideNav.HelpCentreResponse;
import com.secondwarranty.app.ResponseModel.HomePageProducts.HomePageResponse;
import com.secondwarranty.app.ResponseModel.Location.LocationResponse;
import com.secondwarranty.app.ResponseModel.Login.LoginResponse;
import com.secondwarranty.app.ResponseModel.Logout.LogoutResponse;
import com.secondwarranty.app.ResponseModel.PaymentOptions.PaymentResponse;
import com.secondwarranty.app.ResponseModel.ProceedButton.ProceedButtonResponse;
import com.secondwarranty.app.ResponseModel.ResetPassword.ResetPasswordResponse;
import com.secondwarranty.app.ResponseModel.Result;
import com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.ScheduleTimeDateResponse;
import com.secondwarranty.app.ResponseModel.SearchBox.SearchBoxResponse;
import com.secondwarranty.app.ResponseModel.SelectDates.SelectDateResponse;
import com.secondwarranty.app.ResponseModel.ServicePageDetails.ServicePageResponse;
import com.secondwarranty.app.ResponseModel.SideNavDetails.SideNavResponse;
import com.secondwarranty.app.ResponseModel.SignUpVerification;
import com.secondwarranty.app.ResponseModel.UpdateUserProfile.UpdateUserProfileResponse;
import com.secondwarranty.app.Retrofit.RetrofitClient;
import com.secondwarranty.app.Utility.PreferenceUtility;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {
    public DataRepository(Context application) {
    }

//    For Signup

    private MutableLiveData<Result> getDetails = new MutableLiveData<>();

    public MutableLiveData<Result> getDetails(Context context, String name, String mobile, String email, String password) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_name", name);
        params.put("users_email", email);
        params.put("users_mobile", mobile);
        params.put("users_password", password);
        params.put("users_type", "customer");
        params.put("users_gender", "Male");

        Call<SignUpVerification> call = apiService
                .getApi()
                .signUp(headerMap, params);

        call.enqueue(new Callback<SignUpVerification>() {
            @Override
            public void onResponse(Call<SignUpVerification> call, Response<SignUpVerification> response) {
                Log.e("SignUp", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getDetails.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getDetails.setValue(null);
//                        Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getDetails.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpVerification> call, Throwable t) {
                getDetails.setValue(null);
                Log.e("SignUp", " - > Error    " + t.getMessage());
            }
        });
        return getDetails;
    }

//    For Logging

    private MutableLiveData<com.secondwarranty.app.ResponseModel.Login.Result> getLoginDetails = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.Login.Result> getLoginDetails(Context context,
                                                                                              String user_email,
                                                                                              String user_password,
                                                                                              String user_type) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_email", user_email);
        params.put("users_password", user_password);
        params.put("users_type", user_type);


        Call<LoginResponse> call = apiService
                .getApi()
                .login(headerMap, params);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("LoginResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getLoginDetails.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        PreferenceUtility.setStringValue(context.getApplicationContext(), PreferenceUtility.users_id, String.valueOf(response.body().getResult().getUsersData().getUsersId()));
                        PreferenceUtility.setStringValue(context.getApplicationContext(), PreferenceUtility.users_token, response.body().getResult().getUsersData().getUsersToken());
                        PreferenceUtility.setStringValue(context.getApplicationContext(), PreferenceUtility.users_email, response.body().getResult().getUsersData().getUsersEmail());
                        PreferenceUtility.setBoolValue(context.getApplicationContext(), PreferenceUtility.isLogin, true);


                    } else {
                        getLoginDetails.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getLoginDetails.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                getLoginDetails.setValue(null);
                Log.e("LoginResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getLoginDetails;
    }


//  For Logout

    private MutableLiveData<com.secondwarranty.app.ResponseModel.Logout.Result> getLogoutDetails = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.Logout.Result> getLogoutDetails(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));

        PreferenceUtility.setBoolValue(context.getApplicationContext(), PreferenceUtility.isLogin, false);


        Call<LogoutResponse> call = apiService
                .getApi()
                .logout(headerMap, params);

        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                Log.e("LogoutResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getLogoutDetails.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getLogoutDetails.setValue(null);
//                        Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getLogoutDetails.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                getLogoutDetails.setValue(null);
                Log.e("LogoutResponse", " - > Error    " + t.getMessage());
            }
        });
        return getLogoutDetails;
    }

//  For Forgot Password

    private MutableLiveData<com.secondwarranty.app.ResponseModel.ForgotPassword.Result> getForgotPassword = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.ForgotPassword.Result> getForgotPassword(Context context,String mail) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("user_email", mail);

        Call<ForgotPasswordResponse> call = apiService
                .getApi()
                .forgot_password(headerMap, params);

        call.enqueue(new Callback<ForgotPasswordResponse>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponse> call, Response<ForgotPasswordResponse> response) {
                Log.e("ForgotPasswordResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getForgotPassword.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();


                    } else {
                        getForgotPassword.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getForgotPassword.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {
                getForgotPassword.setValue(null);
                Log.e("ForgotPasswordResponse", " - > Error    " + t.getMessage());
            }
        });
        return getForgotPassword;
    }


//  For Dashboard Section(Home & Industry Appliance)

    private MutableLiveData<com.secondwarranty.app.ResponseModel.HomePageProducts.Result> getHomeDetails = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.HomePageProducts.Result> getHomeDetails(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));

        Call<HomePageResponse> call = apiService
                .getApi()
                .home_page(headerMap, params);

        call.enqueue(new Callback<HomePageResponse>() {
            @Override
            public void onResponse(Call<HomePageResponse> call, Response<HomePageResponse> response) {
                Log.e("HomePageResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getHomeDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();


                    } else {
                        getHomeDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getHomeDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HomePageResponse> call, Throwable t) {
                getHomeDetails.setValue(null);
                Log.e("HomePageResponse", " - > Error    " + t.getMessage());
            }
        });
        return getHomeDetails;
    }


//  For Service Page Details

    private MutableLiveData<com.secondwarranty.app.ResponseModel.ServicePageDetails.Result> getServiceDetails = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.ServicePageDetails.Result> getServiceDetails(Context context, String sub_category_id) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("sub_category_id", sub_category_id);

        Call<ServicePageResponse> call = apiService
                .getApi()
                .service_page(headerMap, params);

        call.enqueue(new Callback<ServicePageResponse>() {
            @Override
            public void onResponse(Call<ServicePageResponse> call, Response<ServicePageResponse> response) {
                Log.e("ServicePageResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getServiceDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();


                    } else {
                        getServiceDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getServiceDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServicePageResponse> call, Throwable t) {
                getServiceDetails.setValue(null);
                Log.e("ServicePageResponse", " - > Error    " + t.getMessage());
            }
        });
        return getServiceDetails;
    }


//  For Proceed Button(Order Place)

    private MutableLiveData<com.secondwarranty.app.ResponseModel.ProceedButton.Result> getProceedButton = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.ProceedButton.Result> getProceedButton(Context context, String sub_category_id, String category_id, String service_type, String min_charge, String est_range, String disclaimer) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("sub_category_id", sub_category_id);
        params.put("min_charge", min_charge);
        params.put("category_id", category_id);
        params.put("service_type", service_type);
        params.put("est_range", est_range);
        params.put("disclaimer", disclaimer);

        Call<ProceedButtonResponse> call = apiService
                .getApi()
                .proceed_button(headerMap, params);

        call.enqueue(new Callback<ProceedButtonResponse>() {
            @Override
            public void onResponse(Call<ProceedButtonResponse> call, Response<ProceedButtonResponse> response) {
                Log.e("ProceedButtonResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getProceedButton.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();


                    } else {
                        getProceedButton.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getProceedButton.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProceedButtonResponse> call, Throwable t) {
                getProceedButton.setValue(null);
                Log.e("ProceedButtonResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getProceedButton;
    }

//  For Scheduling Date And Time

    private MutableLiveData<com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.Result> getTimeAndDate = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.Result> getTimeAndDate(Context context, String order_id, String schedule_date, String schedule_time) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", order_id);
        params.put("schedule_date", schedule_date);
        params.put("schedule_time", schedule_time);

        Call<ScheduleTimeDateResponse> call = apiService
                .getApi()
                .date_time_schedule(headerMap, params);

        call.enqueue(new Callback<ScheduleTimeDateResponse>() {
            @Override
            public void onResponse(Call<ScheduleTimeDateResponse> call, Response<ScheduleTimeDateResponse> response) {
                Log.e("ScheduleTimeDateResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getTimeAndDate.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();


                    } else {
                        getTimeAndDate.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getTimeAndDate.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ScheduleTimeDateResponse> call, Throwable t) {
                getTimeAndDate.setValue(null);
                Log.e("ScheduleTimeDateResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getTimeAndDate;
    }


//   For Selecting Dates

    private MutableLiveData<com.secondwarranty.app.ResponseModel.SelectDates.Result> getDates = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.SelectDates.Result> getDates(Context context, String order_id) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", PreferenceUtility.getStringValue(context.getApplicationContext(),PreferenceUtility.order_id));


        Call<SelectDateResponse> call = apiService
                .getApi()
                .dates_select(headerMap, params);

        call.enqueue(new Callback<SelectDateResponse>() {
            @Override
            public void onResponse(Call<SelectDateResponse> call, Response<SelectDateResponse> response) {
                Log.e("Reschedule", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getDates.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getDates.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getDates.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SelectDateResponse> call, Throwable t) {
                getDates.setValue(null);
                Log.e("Reschedule", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getDates;
    }


//  For Location

    private MutableLiveData<com.secondwarranty.app.ResponseModel.Location.Result> getLocation = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.Location.Result> getLocation(Context context, String order_id) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", order_id);


        Call<LocationResponse> call = apiService
                .getApi()
                .location_user(headerMap, params);

        call.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                Log.e("LocationResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getLocation.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getLocation.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getLocation.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                getLocation.setValue(null);
                Log.e("LocationResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getLocation;
    }

//  For Payment

    private MutableLiveData<com.secondwarranty.app.ResponseModel.PaymentOptions.Result> getPayment = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.PaymentOptions.Result> getPayment(Context context, String order_id, String payment_mode) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", order_id);
        params.put("payment_mode", payment_mode);


        Call<PaymentResponse> call = apiService
                .getApi()
                .payment(headerMap, params);

        call.enqueue(new Callback<PaymentResponse>() {
            @Override
            public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
                Log.e("PaymentResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getPayment.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getPayment.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getPayment.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PaymentResponse> call, Throwable t) {
                getPayment.setValue(null);
                Log.e("PaymentResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getPayment;
    }


//  For Getting Order Details

    private MutableLiveData<com.secondwarranty.app.ResponseModel.GetOrderDetails.Result> getOrderDetails = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.GetOrderDetails.Result> getOrderDetails(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.order_id));


        Call<OrderDetailsResponse> call = apiService
                .getApi()
                .order_details(headerMap, params);

        call.enqueue(new Callback<OrderDetailsResponse>() {
            @Override
            public void onResponse(Call<OrderDetailsResponse> call, Response<OrderDetailsResponse> response) {
                Log.e("OrderDetailsResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getOrderDetails.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getOrderDetails.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getOrderDetails.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderDetailsResponse> call, Throwable t) {
                getOrderDetails.setValue(null);
                Log.e("OrderDetailsResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getOrderDetails;
    }


//   For Cancellation

    private MutableLiveData<com.secondwarranty.app.ResponseModel.Cancellation.Result> getCancellation = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.Cancellation.Result> getCancellation(Context context, String cancellation_reason) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.order_id));
        params.put("cancellation_reason", cancellation_reason);


        Call<CancellationResponse> call = apiService
                .getApi()
                .cancellation(headerMap, params);

        call.enqueue(new Callback<CancellationResponse>() {
            @Override
            public void onResponse(Call<CancellationResponse> call, Response<CancellationResponse> response) {
                Log.e("CancellationResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getCancellation.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getCancellation.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getCancellation.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CancellationResponse> call, Throwable t) {
                getCancellation.setValue(null);
                Log.e("CancellationResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getCancellation;
    }

//  For Customer Details

    private MutableLiveData<com.secondwarranty.app.ResponseModel.SideNavDetails.Result> getCustomerDetail = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.SideNavDetails.Result> getCustomerDetail(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));


        Call<SideNavResponse> call = apiService
                .getApi()
                .side_nav(headerMap, params);

        call.enqueue(new Callback<SideNavResponse>() {
            @Override
            public void onResponse(Call<SideNavResponse> call, Response<SideNavResponse> response) {
                Log.e("SideNavResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getCustomerDetail.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getCustomerDetail.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getCustomerDetail.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SideNavResponse> call, Throwable t) {
                getCustomerDetail.setValue(null);
                Log.e("SideNavResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getCustomerDetail;
    }


//  For Rescheduling Date & Time

    private MutableLiveData<com.secondwarranty.app.ResponseModel.ChangeDateAndTime.Result> getRescheduled = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.ChangeDateAndTime.Result> getRescheduled(Context context, String schedule_date, String schedule_time) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.order_id));
        params.put("schedule_date", schedule_date);
        params.put("schedule_time", schedule_time);


        Call<ChangeDateTimeResponse> call = apiService
                .getApi()
                .change_dateTime(headerMap, params);

        call.enqueue(new Callback<ChangeDateTimeResponse>() {
            @Override
            public void onResponse(Call<ChangeDateTimeResponse> call, Response<ChangeDateTimeResponse> response) {
                Log.e("ChangeDateTimeResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getRescheduled.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getRescheduled.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getRescheduled.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChangeDateTimeResponse> call, Throwable t) {
                getRescheduled.setValue(null);
                Log.e("ChangeDateTimeResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getRescheduled;
    }

//  For Getting User Details

    private MutableLiveData<com.secondwarranty.app.ResponseModel.GetUserDetails.Result> getUserDetail = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.GetUserDetails.Result> getUserDetail(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));


        Call<GetUserDetailsResponse> call = apiService
                .getApi()
                .user_details(headerMap, params);

        call.enqueue(new Callback<GetUserDetailsResponse>() {
            @Override
            public void onResponse(Call<GetUserDetailsResponse> call, Response<GetUserDetailsResponse> response) {
                Log.e("GetUserDetailsResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getUserDetail.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getUserDetail.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getUserDetail.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetUserDetailsResponse> call, Throwable t) {
                getUserDetail.setValue(null);
                Log.e("GetUserDetailsResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getUserDetail;
    }


//   For Updating User Profile

    private MutableLiveData<com.secondwarranty.app.ResponseModel.UpdateUserProfile.Result> getUpdatedProfile = new MutableLiveData<>();

    public MutableLiveData<com.secondwarranty.app.ResponseModel.UpdateUserProfile.Result> getUpdatedProfile(Context context, String users_name, String users_email, String users_mobile, String users_type, String users_address, String users_landmark, String users_pincode) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("users_name", users_name);
        params.put("users_email", users_email);
        params.put("users_mobile", users_mobile);
        params.put("users_type", users_type);
        params.put("users_address",users_address);
        params.put("users_landmark",users_landmark);
        params.put("users_pincode",users_pincode);


        Call<UpdateUserProfileResponse> call = apiService
                .getApi()
                .update_details(headerMap, params);

        call.enqueue(new Callback<UpdateUserProfileResponse>() {
            @Override
            public void onResponse(Call<UpdateUserProfileResponse> call, Response<UpdateUserProfileResponse> response) {
                Log.e("UpdateUserProfileResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getUpdatedProfile.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getUpdatedProfile.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getUpdatedProfile.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUserProfileResponse> call, Throwable t) {
                getUpdatedProfile.setValue(null);
                Log.e("UpdateUserProfileResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getUpdatedProfile;
    }

//  For Bookings

    private MutableLiveData<com.secondwarranty.app.ResponseModel.Bookings.Result> getBookingDetails = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.Bookings.Result> getBookingDetails(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));


        Call<BookingsResponseClass> call = apiService
                .getApi()
                .booking_details(headerMap, params);

        call.enqueue(new Callback<BookingsResponseClass>() {
            @Override
            public void onResponse(Call<BookingsResponseClass> call, Response<BookingsResponseClass> response) {
                Log.e("BookingsResponseClass", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getBookingDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getBookingDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getBookingDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookingsResponseClass> call, Throwable t) {
                getBookingDetails.setValue(null);
                Log.e("BookingsResponseClass", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getBookingDetails;
    }


//    For Help Centre (Side Nav Bar)

    private MutableLiveData<com.secondwarranty.app.ResponseModel.HelpCentreSideNav.Result> getHelpCentreDetails = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.HelpCentreSideNav.Result> getHelpCentreDetails(Context context, String message) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("message",message);


        Call<HelpCentreResponse> call = apiService
                .getApi()
                .helpCentre_Response(headerMap, params);

        call.enqueue(new Callback<HelpCentreResponse>() {
            @Override
            public void onResponse(Call<HelpCentreResponse> call, Response<HelpCentreResponse> response) {
                Log.e("HelpCentreResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getHelpCentreDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getHelpCentreDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getHelpCentreDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HelpCentreResponse> call, Throwable t) {
                getHelpCentreDetails.setValue(null);
                Log.e("HelpCentreResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getHelpCentreDetails;
    }


//    For Search Box

    private MutableLiveData<com.secondwarranty.app.ResponseModel.SearchBox.Result> getSearchDetails = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.SearchBox.Result> getSearchDetails(Context context, String search_text) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("search_text",search_text);


        Call<SearchBoxResponse> call = apiService
                .getApi()
                .searchBox_Response(headerMap, params);

        call.enqueue(new Callback<SearchBoxResponse>() {
            @Override
            public void onResponse(Call<SearchBoxResponse> call, Response<SearchBoxResponse> response) {
                Log.e("SearchBoxResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getSearchDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getSearchDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getSearchDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchBoxResponse> call, Throwable t) {
                getSearchDetails.setValue(null);
                Log.e("SearchBoxResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getSearchDetails;
    }


//    For Dashboard Image

    private MutableLiveData<com.secondwarranty.app.ResponseModel.DashboardProfileImage.Result> getImageDetails = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.DashboardProfileImage.Result> getImageDetails(Context context, List<MultipartBody.Part> files) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        Toast.makeText(context.getApplicationContext(), PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id), Toast.LENGTH_SHORT).show();


        Call<DashboardImageResponse> call = apiService
                .getApi()
                .dashboard_image(headerMap, params,files);

        call.enqueue(new Callback<DashboardImageResponse>() {
            @Override
            public void onResponse(Call<DashboardImageResponse> call, Response<DashboardImageResponse> response) {
                Log.e("DashboardImageResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getImageDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getImageDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getImageDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DashboardImageResponse> call, Throwable t) {
                getImageDetails.setValue(null);
                Log.e("DashboardImageResponse", " - > Error    " + t.getMessage());
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return getImageDetails;
    }


//    For Resetting Password

    private MutableLiveData<com.secondwarranty.app.ResponseModel.ResetPassword.Result> getResetPassword = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.ResetPassword.Result> getResetPassword(Context context, String users_forgot_password_code, String users_password) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_forgot_password_code",users_forgot_password_code);
        params.put("users_password",users_password);

        Call<ResetPasswordResponse> call = apiService
                .getApi()
                .reset_Password(headerMap, params);

        call.enqueue(new Callback<ResetPasswordResponse>() {
            @Override
            public void onResponse(Call<ResetPasswordResponse> call, Response<ResetPasswordResponse> response) {
                Log.e("ResetPasswordResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getResetPassword.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getResetPassword.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getResetPassword.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResetPasswordResponse> call, Throwable t) {
                getResetPassword.setValue(null);
                Log.e("ResetPasswordResponse", " - > Error    " + t.getMessage());
            }
        });
        return getResetPassword;
    }


//    For Getting Cart Details

    private MutableLiveData<com.secondwarranty.app.ResponseModel.GetCartData.Result> getCartDetails = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.GetCartData.Result> getCartDetails(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token",PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));

        Call<GetCartDataResponse> call = apiService
                .getApi()
                .cart_Response(headerMap, params);

        call.enqueue(new Callback<GetCartDataResponse>() {
            @Override
            public void onResponse(Call<GetCartDataResponse> call, Response<GetCartDataResponse> response) {
                Log.e("GetCartDataResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getCartDetails.setValue(response.body().getResult());
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getCartDetails.setValue(null);
//                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getCartDetails.setValue(null);
//                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetCartDataResponse> call, Throwable t) {
                getCartDetails.setValue(null);
                Log.e("GetCartDataResponse", " - > Error    " + t.getMessage());
            }
        });
        return getCartDetails;
    }


//    For Adding Product into Cart

    private MutableLiveData<com.secondwarranty.app.ResponseModel.AddToCart.Result> getAddToCartDetails = new MutableLiveData<>();
    public MutableLiveData<com.secondwarranty.app.ResponseModel.AddToCart.Result> getAddToCartDetails(Context context) {
        RetrofitClient apiService = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtility.getHeaderMap(context);
        HashMap<String, String> params = new HashMap<>();

        params.put("users_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_id));
        params.put("users_token",PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.users_token));
        params.put("order_id", PreferenceUtility.getStringValue(context.getApplicationContext(), PreferenceUtility.order_id));

        Call<AddToCartResponse> call = apiService
                .getApi()
                .addToCart_Response(headerMap, params);

        call.enqueue(new Callback<AddToCartResponse>() {
            @Override
            public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
                Log.e("AddToCartResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        getAddToCartDetails.setValue(response.body().getResult());
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        getAddToCartDetails.setValue(null);
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    getAddToCartDetails.setValue(null);
                    Toast.makeText(context, "Cannot Fetch Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddToCartResponse> call, Throwable t) {
                getAddToCartDetails.setValue(null);
                Log.e("AddToCartResponse", " - > Error    " + t.getMessage());
            }
        });
        return getAddToCartDetails;
    }






}
