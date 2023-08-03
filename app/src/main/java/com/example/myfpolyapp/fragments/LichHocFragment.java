package com.example.myfpolyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.adapters.LichHocAdapter;
import com.example.myfpolyapp.models.LichHocModel;

import java.util.ArrayList;
import java.util.List;

public class LichHocFragment extends Fragment {
    private RecyclerView recyclerView;
    private LichHocAdapter lichHocAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lichhoc, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewLichHoc);

        // Create a list of LichHocModel objects (sample data)
        List<LichHocModel> lichHocList = new ArrayList<>();
        lichHocList.add(new LichHocModel(1, "G1", "101", "MATH101", "Mathematics", "Morning", "Monday", "John Doe", 1));
        lichHocList.add(new LichHocModel(2, "G2", "201", "PHYS101", "Physics", "Afternoon", "Tuesday", "Jane Smith", 0));
        // Add more sample data...

        // Initialize the adapter with the data
        lichHocAdapter = new LichHocAdapter(lichHocList);

        // Set the layout manager and adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(lichHocAdapter);

        return rootView;
    }
}
