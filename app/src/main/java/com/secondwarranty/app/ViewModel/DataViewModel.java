package com.secondwarranty.app.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.secondwarranty.app.Repository.DataRepository;
import com.secondwarranty.app.ResponseModel.Result;

import java.util.List;

import okhttp3.MultipartBody;

public class DataViewModel extends AndroidViewModel {


    private DataRepository dataRepository;

    public DataViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);

    }
    public LiveData<Result> getDetails(Context context,String name,String mobile,String email,String password) {
        return dataRepository.getDetails(context,name,mobile,email,password);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.Login.Result> getLoginDetails(Context context, String user_email,String user_password,String user_type) {
        return dataRepository.getLoginDetails(context,user_email,user_password,user_type);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.Logout.Result> getLogoutDetails(Context context) {
        return dataRepository.getLogoutDetails(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.ForgotPassword.Result> getForgotPassword(Context context, String mail) {
        return dataRepository.getForgotPassword(context, mail);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.HomePageProducts.Result> getHomeDetails(Context context) {
        return dataRepository.getHomeDetails(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.ServicePageDetails.Result> getServiceDetails(Context context, String sub_category_id) {
        return dataRepository.getServiceDetails(context, sub_category_id);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.ProceedButton.Result> getProceedButton(Context context, String sub_category_id, String category_id, String service_type, String min_charge, String est_range, String disclaimer) {
        return dataRepository.getProceedButton(context, sub_category_id,category_id,service_type,min_charge,est_range,disclaimer);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate.Result> getTimeAndDate(Context context, String order_id, String schedule_date, String schedule_time) {
        return dataRepository.getTimeAndDate(context, order_id, schedule_date,schedule_time);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.SelectDates.Result> getDates(Context context, String order_id) {
        return dataRepository.getDates(context, order_id);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.Location.Result> getLocation(Context context, String order_id) {
        return dataRepository.getLocation(context, order_id);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.PaymentOptions.Result> getPayment(Context context, String order_id, String payment_mode) {
        return dataRepository.getPayment(context, order_id,payment_mode);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.GetOrderDetails.Result> getOrderDetails(Context context) {
        return dataRepository.getOrderDetails(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.Cancellation.Result> getCancellation(Context context, String cancellation_reason) {
        return dataRepository.getCancellation(context,cancellation_reason);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.SideNavDetails.Result> getCustomerDetail(Context context) {
        return dataRepository.getCustomerDetail(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.ChangeDateAndTime.Result> getRescheduled(Context context, String schedule_date, String schedule_time) {
        return dataRepository.getRescheduled(context,schedule_date,schedule_time);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.GetUserDetails.Result> getUserDetail(Context context) {
        return dataRepository.getUserDetail(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.UpdateUserProfile.Result> getUpdatedProfile(Context context, String users_name, String users_email, String users_mobile, String users_type,  String users_address, String users_landmark, String users_pincode) {
        return dataRepository.getUpdatedProfile(context,users_name,users_email,users_mobile,users_type,users_address,users_landmark,users_pincode);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.Bookings.Result> getBookingDetails(Context context) {
        return dataRepository.getBookingDetails(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.HelpCentreSideNav.Result> getHelpCentreDetails(Context context, String message) {
        return dataRepository.getHelpCentreDetails(context,message);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.SearchBox.Result> getSearchDetails(Context context, String search_text) {
        return dataRepository.getSearchDetails(context,search_text);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.DashboardProfileImage.Result> getImageDetails(Context context, List<MultipartBody.Part> files) {
        return dataRepository.getImageDetails(context,files);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.ResetPassword.Result> getResetPassword(Context context, String users_forgot_password_code, String users_password) {
        return dataRepository.getResetPassword(context,users_forgot_password_code,users_password);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.GetCartData.Result> getCartDetails(Context context) {
        return dataRepository.getCartDetails(context);
    }

    public LiveData<com.secondwarranty.app.ResponseModel.AddToCart.Result> getAddToCartDetails(Context context) {
        return dataRepository.getAddToCartDetails(context);
    }






}
