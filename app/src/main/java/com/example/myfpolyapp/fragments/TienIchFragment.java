package com.example.myfpolyapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfpolyapp.MainActivity;
import com.example.myfpolyapp.R;
import com.example.myfpolyapp.activities.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.concurrent.Executor;

public class TienIchFragment extends Fragment {

    TextView btnCongDong, btnGiangVien;
    LinearLayout btnDangXuat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tienich, container, false);

        btnCongDong = rootView.findViewById(R.id.btnCongDong);
        btnGiangVien = rootView.findViewById(R.id.btnGiangVien);
        btnDangXuat = rootView.findViewById(R.id.btnDangXuat);


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

        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        return rootView;
    }

    private void signOut() {
        // Firebase sign out
        LoginActivity.mAuth.signOut();

        // Google sign out
        LoginActivity.mGoogleSignInClient.signOut().addOnCompleteListener(requireActivity(), new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                // Update your UI or perform any other tasks after signing out
                Intent intent = new Intent(requireContext(), LoginActivity.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });
    }
}
