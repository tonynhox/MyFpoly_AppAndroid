package com.example.myfpolyapp.apis;

import com.example.myfpolyapp.models.GiangVienAPIModel;
import com.example.myfpolyapp.models.GiangVienModel;
import com.example.myfpolyapp.models.LichHocAPIModel;
import com.example.myfpolyapp.models.NotifiAPIModel;
import com.example.myfpolyapp.models.NotificationModel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;

public interface APIInterfaces{

    @GET("post/get-posts.php") // Replace "notifications" with the actual API endpoint for notifications.
    Call<NotifiAPIModel> getNotifications();

    @GET("schedules/get-schedules.php")
    Call<LichHocAPIModel> getSchedules(
            @Query("class_name") String className,
            @Query("type") int type
    );

    @GET("infomation/api-get-infomation.php") // Replace "notifications" with the actual API endpoint for notifications.
    Call<GiangVienAPIModel> getAllInfor();
}
