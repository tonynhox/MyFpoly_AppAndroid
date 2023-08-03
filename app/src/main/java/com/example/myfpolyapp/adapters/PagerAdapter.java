package com.example.myfpolyapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myfpolyapp.fragments.LichHocFragment;
import com.example.myfpolyapp.fragments.LichThiFragment;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

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
}
