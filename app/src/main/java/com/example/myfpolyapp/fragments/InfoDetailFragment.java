package com.example.myfpolyapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.apis.APIInterfaces;
import com.example.myfpolyapp.constants.BaseUrl;
import com.example.myfpolyapp.models.InfoDetailApiModel;
import com.example.myfpolyapp.models.NotificationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoDetailFragment extends Fragment {

     TextView textTitle;
     TextView textAuthor;
     TextView textDate;
     TextView textContent;

    private int infoId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info_detail, container, false);

        try {
            Bundle args = getArguments();
            if (args != null) {
                infoId = args.getInt("info_id", -1);
                Log.e("ID: ", String.valueOf(infoId));
            }
            fetchInfoDetail();
        } catch (Exception e) {
            Log.e("EXX: ", e.toString());
        }


        textTitle = rootView.findViewById(R.id.textTitle);
        textAuthor = rootView.findViewById(R.id.textAuthor);
        textDate = rootView.findViewById(R.id.textDate);
        textContent = rootView.findViewById(R.id.textContent);

        // Fetch info details using Retrofit


        return rootView;
    }

    private void fetchInfoDetail() {
        try {
            String BASE_URL = BaseUrl.BASE_URL;

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            APIInterfaces apiService = retrofit.create(APIInterfaces.class);
            Call<InfoDetailApiModel> call = apiService.getInfoById(infoId);
            call.enqueue(new Callback<InfoDetailApiModel>() {
                @Override
                public void onResponse(Call<InfoDetailApiModel> call, Response<InfoDetailApiModel> response) {
                    if (response.isSuccessful()) {
                        Log.e("DETAIL: ", response.body().toString());
                        InfoDetailApiModel infoDetailResponse = response.body();

                        if (infoDetailResponse != null) {
                            NotificationModel info = infoDetailResponse.getData();
                            if (info != null) {
                                Log.e("DATA: ", info.toString());
                                textTitle.setText(info.getTitle());
                                textAuthor.setText(info.getNamecreated());
                                textDate.setText(info.getCreated_at());
                                textContent.setText(info.getContent());
                            } else {
                                Log.e("DATA: ", "NULL");
                            }
                        }
                    } else {
                        Log.e("ERR: ", response.toString());
                    }
                }

                @Override
                public void onFailure(Call<InfoDetailApiModel> call, Throwable t) {
                    Log.e("FAILLLL", t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("Ex: ", e.toString());
        }

    }
}
