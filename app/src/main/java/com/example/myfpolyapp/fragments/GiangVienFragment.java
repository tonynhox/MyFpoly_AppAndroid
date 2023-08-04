package com.example.myfpolyapp.fragments;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.adapters.GiangVienAdapter;
import com.example.myfpolyapp.adapters.NotificationAdapter;
import com.example.myfpolyapp.apis.APIInterfaces;
import com.example.myfpolyapp.constants.BaseUrl;
import com.example.myfpolyapp.models.GiangVienAPIModel;
import com.example.myfpolyapp.models.GiangVienModel;
import com.example.myfpolyapp.models.NotifiAPIModel;
import com.example.myfpolyapp.models.NotificationModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GiangVienFragment extends Fragment {

    private RecyclerView recyclerViewGiangvien;
    private GiangVienAdapter giangvienAdapter;
    private List<GiangVienModel> giangvienList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_giangvien, container, false);

        recyclerViewGiangvien = rootView.findViewById(R.id.recyclerViewGiangvien);

        // Use "requireContext()" in a fragment for the context
        recyclerViewGiangvien.setLayoutManager(new LinearLayoutManager(requireContext())); // Use "requireContext()" in a fragment for the context

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
        Call<GiangVienAPIModel> call = apiService.getAllInfor();
        call.enqueue(new Callback<GiangVienAPIModel>() {
            @Override
            public void onResponse(Call<GiangVienAPIModel> call, Response<GiangVienAPIModel> response) {
                if (response.isSuccessful()) {
                    GiangVienAPIModel apiResponse = response.body();
                    if (apiResponse != null) {
                        giangvienList = apiResponse.getData();
                        setupRecyclerView();
                    }
                } else {
                    // Handle the error.
                }
            }

            @Override
            public void onFailure(Call<GiangVienAPIModel> call, Throwable t) {
                Log.e("ERRRRRRR: ", t.toString());
            }

        });
    }



    private void setupRecyclerView() {
        giangvienAdapter = new GiangVienAdapter(giangvienList, requireContext());
        recyclerViewGiangvien.setAdapter(giangvienAdapter);
    }
}
