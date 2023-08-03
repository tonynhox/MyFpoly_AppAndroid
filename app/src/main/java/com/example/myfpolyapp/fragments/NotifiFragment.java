package com.example.myfpolyapp.fragments;

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
        notificationAdapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        return rootView;
    }

    // Replace this method with your actual data source
    private List<NotificationModel> getNotificationData() {
        List<NotificationModel> data = new ArrayList<>();
        data.add(new NotificationModel(1, "New Update Available", "Admin", "2023-08-03", "A new update is now available for download."));
        data.add(new NotificationModel(2, "Important Announcement", "CEO", "2023-08-02", "We are pleased to announce a new project launch next week."));
        data.add(new NotificationModel(3, "Upcoming Event", "Event Coordinator", "2023-08-05", "Don't forget to attend our annual company picnic on Saturday."));

        return data;
    }
}