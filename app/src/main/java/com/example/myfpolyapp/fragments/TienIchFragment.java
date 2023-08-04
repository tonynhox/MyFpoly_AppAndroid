package com.example.myfpolyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfpolyapp.R;

public class TienIchFragment extends Fragment {

    TextView btnCongDong, btnGiangVien;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tienich, container, false);

        btnCongDong = rootView.findViewById(R.id.btnCongDong);
        btnGiangVien = rootView.findViewById(R.id.btnGiangVien);

        btnCongDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace with the CongDongFragment
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, new CongDongFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnGiangVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace with the GiangVienFragment
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, new GiangVienFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView;
    }
}
