package com.example.myfpolyapp.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.adapters.NotificationAdapter;
import com.example.myfpolyapp.apis.APIInterfaces;
import com.example.myfpolyapp.constants.BaseUrl;
import com.example.myfpolyapp.models.NotifiAPIModel;
import com.example.myfpolyapp.models.NotificationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotifiFragment extends Fragment implements NotificationAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private List<NotificationModel> notificationList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifi, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewNotifi);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Fetch data using Retrofit
        fetchNotificationData();

        return rootView;
    }

    private void fetchNotificationData() {
        // Replace BASE_URL with your actual API base URL.
        String BASE_URL = BaseUrl.BASE_URL;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterfaces apiService = retrofit.create(APIInterfaces.class);
        Call<NotifiAPIModel> call = apiService.getNotifications();
        call.enqueue(new Callback<NotifiAPIModel>() {
            @Override
            public void onResponse(Call<NotifiAPIModel> call, Response<NotifiAPIModel> response) {
                if (response.isSuccessful()) {
                    NotifiAPIModel apiResponse = response.body();
                    if (apiResponse != null) {
                        notificationList = apiResponse.getData();
                        setupRecyclerView();
                    }
                } else {
                    // Handle the error.
                }
            }

            @Override
            public void onFailure(Call<NotifiAPIModel> call, Throwable t) {
                // Handle the failure.
            }

        });
    }

    private void setupRecyclerView() {
        notificationAdapter = new NotificationAdapter(notificationList, this);
        recyclerView.setAdapter(notificationAdapter);
    }

    @Override
    public void onItemClick(NotificationModel notification, int id) {
        // ID Ở ĐÂY NÈ EM
//        showDetailDialog(notification.getContent(), id);
        try {
            InfoDetailFragment infoDetailFragment = new InfoDetailFragment();
            Bundle args = new Bundle();
            args.putInt("info_id", id); // Replace id with the actual ID you want to fetch details for
            infoDetailFragment.setArguments(args);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, infoDetailFragment)
                    .addToBackStack(null)
                    .commit();
        } catch (Exception e) {
            Log.e("ERROR: ", e.toString());
        }

    }

    private void showDetailDialog(String content, int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Nội dung chi tiết");
        builder.setMessage("ID: " + id + "\nContent: " + content);
        builder.setPositiveButton("OK", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
