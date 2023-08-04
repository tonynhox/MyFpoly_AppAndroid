package com.example.myfpolyapp.fragments;

import android.os.Bundle;
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
import com.example.myfpolyapp.models.LichHocModel;

import java.util.ArrayList;
import java.util.List;

public class LichThiFragment extends Fragment {

    private RecyclerView recyclerView;
    private LichHocAdapter lichHocAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lichthi, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewLichThi);

        Spinner dropdownPicker = rootView.findViewById(R.id.spnLichThi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.lichhoc_options, R.layout.spinner_item_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_custom); // Use the updated custom layout here
        dropdownPicker.setAdapter(adapter);

        // Create a list of LichHocModel objects (sample data)
        LichHocModel lichHoc1 = new LichHocModel(1, "Room A", "Monday", "10:00 AM - 12:00 PM", "Mathematics", "John Doe", 1, "Class A", "123 Main St");
        LichHocModel lichHoc2 = new LichHocModel(2, "Room B", "Tuesday", "2:00 PM - 4:00 PM", "Science", "Jane Smith", 2, "Class B", "456 Oak Ave");
        LichHocModel lichHoc3 = new LichHocModel(3, "Room C", "Wednesday", "1:00 PM - 3:00 PM", "History", "Michael Johnson", 1, "Class C", "789 Elm St");

// Add the instances to the lichHocList
        List<LichHocModel> lichHocList = new ArrayList<>();
        lichHocList.add(lichHoc1);
        lichHocList.add(lichHoc2);
        lichHocList.add(lichHoc3);


        // Initialize the adapter with the data
        lichHocAdapter = new LichHocAdapter(lichHocList);

        // Set the layout manager and adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(lichHocAdapter);

        return rootView;
    }

}
