package com.secondwarranty.app.Adapter;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.secondwarranty.app.R;
import com.secondwarranty.app.TLFragments.Ftab1;
import com.secondwarranty.app.TLFragments.Ftab2;
import com.secondwarranty.app.TLFragments.Ftab3;

public class PageAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0: return new Ftab1();
            case 1: return new Ftab2();
            case 2: return new Ftab3();
            default: return null;

        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }


}
