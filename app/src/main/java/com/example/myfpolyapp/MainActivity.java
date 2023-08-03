package com.example.myfpolyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myfpolyapp.fragments.LibraryFrament;
import com.example.myfpolyapp.fragments.LichHocFragment;
import com.example.myfpolyapp.fragments.NotifiFragment;
import com.example.myfpolyapp.fragments.QRScanFragment;
import com.example.myfpolyapp.fragments.ScoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Hiển thị mặc định NotifiFragment
        NotifiFragment notifiFragment = new NotifiFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, notifiFragment);
        fragmentTransaction.commit();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId() == R.id.notificationBottom) {
                    toolBar.setTitle("Thông báo");
                    fragment = new NotifiFragment();
                } else if (item.getItemId() == R.id.scheduleBottom) {
                    toolBar.setTitle("Lịch học");
                    fragment = new LichHocFragment();
//                } else if (item.getItemId() == R.id.qrScanBottom) {
//                    toolBar.setTitle("QR Scan");
//                    fragment = new QRScanFragment();
                } else if (item.getItemId() == R.id.scoreBottom) {
                    toolBar.setTitle("Bảng điểm");
                    fragment = new ScoreFragment();
                } else {
                    toolBar.setTitle("Thư viện");
                    fragment = new LibraryFrament();
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, fragment).commit();
                return true;
            }
        });

//    private void loadFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
//    }
//    }
    }
}