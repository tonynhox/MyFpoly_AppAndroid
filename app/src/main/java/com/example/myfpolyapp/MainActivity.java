package com.example.myfpolyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Switch;

import com.example.myfpolyapp.fragments.LibraryFrament;
import com.example.myfpolyapp.fragments.LichHocFragment;
import com.example.myfpolyapp.fragments.NotifiFragment;
import com.example.myfpolyapp.fragments.QRScanFragment;
import com.example.myfpolyapp.fragments.ScoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment;

    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = findViewById(R.id.toolBar);
        drawer = findViewById(R.id.drawerLayout);

        //Hiển thị mặc định NotifiFragment
        NotifiFragment notifiFragment = new NotifiFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager = getSupportFragmentManager();
        toolBar.setTitle("Thông báo");
        fragment = new NotifiFragment();
        fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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

        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.icHome) {
                    bottomNavigationView.setSelectedItemId(R.id.notificationBottom);

                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, fragment).commit();
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.notificationBottom) {
//                    toolBar.setTitle("Thông báo");
//                    fragment = new NotifiFragment();
//                }
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.frameLayout, fragment).commit();
//                drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

//    private void loadFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
//    }
//    }
    }
}