package com.secondwarranty.app.Retrofit;

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
import com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.ScheduleTimeDateResponse;
import com.secondwarranty.app.ResponseModel.SearchBox.SearchBoxResponse;
import com.secondwarranty.app.ResponseModel.SelectDates.SelectDateResponse;
import com.secondwarranty.app.ResponseModel.ServicePageDetails.ServicePageResponse;
import com.secondwarranty.app.ResponseModel.SideNavDetails.SideNavResponse;
import com.secondwarranty.app.ResponseModel.SignUpVerification;
import com.secondwarranty.app.ResponseModel.UpdateUserProfile.UpdateUserProfileResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface Api {

    @FormUrlEncoded
    @POST("users/putSignupForm")
    Call<SignUpVerification> signUp(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @POST("users/updateProfileImage")
    @Multipart
    Call<DashboardImageResponse> dashboard_image(@HeaderMap Map<String,String> headers,
                                                 @PartMap Map<String, String> map,
                                                 @Part List<MultipartBody.Part> files);

    @FormUrlEncoded
    @POST("users/setLogin")
    Call<LoginResponse> login(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("users/setLogout")
    Call<LogoutResponse> logout(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("users/setForgotPassword")
    Call<ForgotPasswordResponse> forgot_password(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getcustomerHomepageData")
    Call<HomePageResponse> home_page(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getservicePageDetailData")
    Call<ServicePageResponse> service_page(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/customerorderplace")
    Call<ProceedButtonResponse> proceed_button(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/scheduletimeDate")
    Call<ScheduleTimeDateResponse> date_time_schedule(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getscheduleDates")
    Call<SelectDateResponse> dates_select(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/addusersAddress")
    Call<LocationResponse> location_user(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/completepaymentwithCOD")
    Call<PaymentResponse> payment(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getOrderdetailsData")
    Call<OrderDetailsResponse> order_details(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/cancelorder")
    Call<CancellationResponse> cancellation(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getcustomerdetails")
    Call<SideNavResponse> side_nav(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/rescheduledatetimes")
    Call<ChangeDateTimeResponse> change_dateTime(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("users/getProfileData")
    Call<GetUserDetailsResponse> user_details(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("users/updateProfileData")
    Call<UpdateUserProfileResponse> update_details(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getMybookingdata")
    Call<BookingsResponseClass> booking_details(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/contacthelpcenter")
    Call<HelpCentreResponse> helpCentre_Response(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/searchData")
    Call<SearchBoxResponse> searchBox_Response(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("users/setResetPassword")
    Call<ResetPasswordResponse> reset_Password(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/getcartData")
    Call<GetCartDataResponse> cart_Response(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("customer/addtoCart")
    Call<AddToCartResponse> addToCart_Response(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);










}
