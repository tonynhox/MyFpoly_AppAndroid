package com.example.myfpolyapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.adapters.LichHocAdapter;
import com.example.myfpolyapp.apis.APIInterfaces;
import com.example.myfpolyapp.apis.RetrofitClient;
import com.example.myfpolyapp.constants.BaseUrl;
import com.example.myfpolyapp.models.LichHocAPIModel;
import com.example.myfpolyapp.models.LichHocModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LichHocFragment extends Fragment {
    private RecyclerView recyclerView;
    private LichHocAdapter lichHocAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lichhoc, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewLichHoc);

        Spinner dropdownPicker = rootView.findViewById(R.id.spnLichHoc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.lichhoc_options, R.layout.spinner_item_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_custom); // Use the updated custom layout here
        dropdownPicker.setAdapter(adapter);

        // Fetch data using Retrofit
        fetchLichHocData();

        return rootView;
    }

    private void fetchLichHocData() {
        String BASE_URL = BaseUrl.BASE_URL; // Replace with your actual base URL
        Retrofit retrofit = RetrofitClient.getClient(BASE_URL);


        APIInterfaces apiService = retrofit.create(APIInterfaces.class);
        Call<LichHocAPIModel> call = apiService.getSchedules("MD17301", 1);
        call.enqueue(new Callback<LichHocAPIModel>() {
            @Override
            public void onResponse(Call<LichHocAPIModel> call, Response<LichHocAPIModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LichHocAPIModel lichHocAPIModel = response.body();
                    List<LichHocModel> lichHocList = lichHocAPIModel.getData();
                    Log.e("Error Response: ", response.toString());

                    setupRecyclerView(lichHocList);
                } else {
                    // Handle the error response here
                    Log.e("Error Response: ", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<LichHocAPIModel> call, Throwable t) {
                // Handle the failure
                Log.e("API Failure: ", t.toString());
            }
        });
    }


    private void setupRecyclerView(List<LichHocModel> lichHocList) {
        // Initialize the adapter with the fetched data
        lichHocAdapter = new LichHocAdapter(lichHocList);

        // Set the layout manager and adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(lichHocAdapter);
    }
}
