package com.example.myfpolyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.myfpolyapp.activities.LoginActivity;
import com.example.myfpolyapp.fragments.GiangVienFragment;
import com.example.myfpolyapp.fragments.LibraryFrament;
import com.example.myfpolyapp.fragments.LichHocFragment;
import com.example.myfpolyapp.fragments.NotifiFragment;

import com.example.myfpolyapp.fragments.ScheduleFragment;
import com.example.myfpolyapp.fragments.ScoreFragment;
import com.example.myfpolyapp.fragments.TienIchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

//    BottomNavigationView bottomNavigationView;
    MeowBottomNavigation bottomNavigationView;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment;
    TextView txtFullName;
    ImageView navigation_icon;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = findViewById(R.id.toolBar);
        drawer = findViewById(R.id.drawerLayout);
        txtFullName= findViewById(R.id.txtFulName);
        navigation_icon = findViewById(R.id.navigation_icon);

        txtFullName.setText(LoginActivity.data.getName());

        Glide.with(this)
                .load(LoginActivity.data.getAvatar()) // Pass the URL to the image
                .centerCrop()
                .transform(new RoundedCorners(70))
                .into(navigation_icon);


        NavigationView navigationView = findViewById(R.id.navigationView);
        View headerView = navigationView.getHeaderView(0); // Lấy phần tử đầu tiên (header)

        TextView txtFulNameHeader = headerView.findViewById(R.id.txtFulName); // Tìm txtFulName trong header

        ImageView imgProfileNav = headerView.findViewById(R.id.imgProfileNav);

        txtFulNameHeader.setText(LoginActivity.data.getName());
        Glide.with(this)
                .load(LoginActivity.data.getAvatar()) // Pass the URL to the image
                .centerCrop()
                .transform(new RoundedCorners(70))
                .into(imgProfileNav);

        fragment = new NotifiFragment();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);



        bottomNavigationView.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bottomNavigationView.add(new MeowBottomNavigation.Model(2,R.drawable.ic_canculator));
//        bottomNavigationView.add(new MeowBottomNavigation.Model(3,R.drawable.qr_code));
        bottomNavigationView.add(new MeowBottomNavigation.Model(4,R.drawable.ic_grade));
        bottomNavigationView.add(new MeowBottomNavigation.Model(5,R.drawable.ic_account));

        bottomNavigationView.show(1,true);

        bottomNavigationView.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
//                        toolBar.setTitle("Thông báo");
                        fragment = new NotifiFragment();
                        break;
                    case 2:
                        fragment = new ScheduleFragment();
                        break;
//                    case 3:
//                        break;
                    case 4:
                        fragment = new ScoreFragment();
                        break;
                    case 5:
                        fragment = new TienIchFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, fragment).commit();
                return null;
            }
        });
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.notificationBottom) {
//                    toolBar.setTitle("Thông báo");
//                    fragment = new NotifiFragment();
//                } else if (item.getItemId() == R.id.scheduleBottom) {
////                    toolBar.setTitle("Lịch học");
//                    fragment = new ScheduleFragment();
////                } else if (item.getItemId() == R.id.qrScanBottom) {
////                    toolBar.setTitle("QR Scan");
////                    fragment = new QRScanFragment();
//                } else if (item.getItemId() == R.id.scoreBottom) {
////                    toolBar.setTitle("Bảng điểm");
//                    fragment = new ScoreFragment();
//                } else {
////                    toolBar.setTitle("Thư viện");
//                    fragment = new TienIchFragment();
//                }
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.frameLayout, fragment).commit();
//                return true;
//            }
//        });

        navigationView = findViewById(R.id.navigationView);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        navigation_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.icHome) {
                    bottomNavigationView.show(1,true);

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