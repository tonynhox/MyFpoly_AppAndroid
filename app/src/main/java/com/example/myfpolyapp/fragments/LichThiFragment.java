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
        View rootView = inflater.inflate(R.layout.fragment_lichhoc, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewLichHoc);

        Spinner dropdownPicker = rootView.findViewById(R.id.dropdownPicker);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.lichhoc_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownPicker.setAdapter(adapter);

        // Create a list of LichHocModel objects (sample data)


        return rootView;
    }

}
