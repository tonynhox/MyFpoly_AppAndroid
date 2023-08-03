package com.example.myfpolyapp.fragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.adapters.NotificationAdapter;
import com.example.myfpolyapp.models.NotificationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class NotifiFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifi, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewNotifi);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<NotificationModel> notificationList = getNotificationData(); // Replace with your data source
        notificationAdapter = new NotificationAdapter(notificationList, new NotificationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NotificationModel notification) {
                showDetailDialog(notification.getContent());
            }
        });
        recyclerView.setAdapter(notificationAdapter);

        return rootView;
    }

    // Replace this method with your actual data source
    private List<NotificationModel> getNotificationData() {
        List<NotificationModel> data = new ArrayList<>();

        data.add(new NotificationModel(1, "Notification 1", "11/1/2013", "John", "This is the content of notification 1."));
        data.add(new NotificationModel(2, "Notification 2", "11/1/2013", "Jane", "This is the content of notification 2."));
        data.add(new NotificationModel(3, "Notification 3", "11/1/2013", "Bob", "This is the content of notification 3."));
        return data;
    }
    private void showDetailDialog(String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Nội dung chi tiết");
        builder.setMessage(content);
        builder.setPositiveButton("OK",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}