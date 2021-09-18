package com.nadim.jogajogapplication;

import com.google.gson.JsonObject;
import com.nadim.jogajogapplication.CustomerCall.CallHistoryModel;
import com.nadim.jogajogapplication.CustomerContactActivity.Model.CustomerHistoryOpportunityModel;
import com.nadim.jogajogapplication.Login.Model.UserEmployeeInfo;
import com.nadim.jogajogapplication.MainDashboard.Models.NotificationModel;
import com.nadim.jogajogapplication.MainDashboard.Models.OldContactShow;
import com.nadim.jogajogapplication.MainDashboard.Models.SaveContactShow;
import com.nadim.jogajogapplication.MainDashboard.NewContact.Model.CreateContactModel;
import com.nadim.jogajogapplication.MainDashboard.SupportReportActivity.Models.MwlGetByDate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface Api {
    //Login
    @GET("Authentication/LogIn/{username}/{password}")
    Call<UserEmployeeInfo> getEmployeeDataInfo(@Path("username") String userName,
                                               @Path("password") String userPassword);
    //Save Contact List
    /*@GET("Contact")
    Call<List<SaveContactShow>> getSaveContactList(@Header("Authorization") String authorization);
*/

    /*@GET("Contact/GetContactByUser/{userId}")*/

    @GET("Contact/GetNewContact/{userId}")
    Call<List<SaveContactShow>> getSaveContactList(@Header("Authorization") String authorization,
                                                    @Path("userId") Integer userId);
    @GET("Call/GetCallByUserAndContact/{userId}/{contactId}")
    Call<List<CallHistoryModel>> getCallHistoryList(@Header("Authorization") String authorization,
                                                    @Path("userId") Integer userId,
                                                    @Path("contactId") Integer contactId);

    @GET("Contact/GetOldContact/{userId}")
    Call<List<OldContactShow>> getOldContactList(@Header("Authorization") String authorization,
                                                 @Path("userId") Integer userId);

    @GET("Notification/GetNotification/{userId}/{dateTime}")
    Call<List<NotificationModel>> getNotificationList(@Header("Authorization") String authorization,
                                                      @Path("userId") Integer userId,
                                                      @Path("dateTime") String dateTime);

    @GET("Call/Dialer/{userId}/{contactId}")
    Call<String> getDialerShow(@Header("Authorization") String authorization,
                               @Path("userId") Integer userId,
                               @Path("contactId") Integer contactId);

    @POST("Call/CreateCall")
    Call<String> createNewCall( @Header("Authorization") String authorization,
                                 @Body JsonObject createContactModel);

    //New Contact
    @POST("Contact/CreateContact")
    Call<String> saveNewContact(@Header("Authorization") String authorization,
                                @Body JsonObject createContactModel);

    /////New CompanyName add
    @POST("Customer/CreateCustomer")
    Call<String> newCustomerContact(@Header("Authorization") String authorization,
                                                @Body JsonObject createContactModel);


    //// GetOpportunity
    @GET("Opportunity/GetOpportunityByContact/{contactId}")
    Call<List<CustomerHistoryOpportunityModel>> getOpportunity(@Header("Authorization") String authorization,
                                                               @Path("contactId") Integer contactId);

    /// Create opportunity
    @POST("Opportunity/CreateOpportunity")
    Call<String> getCreateOpportunity(@Header("Authorization") String authorization,
                                @Body JsonObject data);

    /// MWL Get Date
    @GET("MWL/GetMWLByDate/{userId}/{fromDate}/{toDate}")
    Call<List<MwlGetByDate>> getMwlGetByDate(@Header("Authorization") String authorization,
                                       @Path("userId") Integer userId,
                                       @Path("fromDate") String fromDate,
                                       @Path("toDate") String toDate);

    /// create MWL
    @POST("MWL/CreateMWL")
    Call<String> createMWL(@Header("Authorization") String authorization,
                                    @Body JsonObject createMWL);

}
