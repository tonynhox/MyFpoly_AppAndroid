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

        // Create a list of LichHocModel objects (sample data)
        List<LichHocModel> lichHocList = new ArrayList<>();
        

        // Initialize the adapter with the data
        lichHocAdapter = new LichHocAdapter(lichHocList);

        // Set the layout manager and adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(lichHocAdapter);

        return rootView;
    }
}
