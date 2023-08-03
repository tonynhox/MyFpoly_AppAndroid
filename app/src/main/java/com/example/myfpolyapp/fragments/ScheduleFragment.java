package com.example.myfpolyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.fragments.LichHocFragment;
import com.example.myfpolyapp.fragments.LichThiFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ScheduleFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        viewPager = rootView.findViewById(R.id.viewPager);
        tabLayout = rootView.findViewById(R.id.tabLayout);

        // Set up ViewPager2 with your adapter
        FragmentStateAdapter adapter = new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position == 0) {
                    return new LichHocFragment(); // Create your first tab fragment
                } else {
                    return new LichThiFragment(); // Create your second tab fragment
                }
            }

            @Override
            public int getItemCount() {
                return 2; // Number of tabs
            }
        };
        viewPager.setAdapter(adapter);

        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Lịch Học");
            } else if (position == 1) {
                tab.setText("Lịch Thi");
            }
        }).attach();

        return rootView;
    }
}
