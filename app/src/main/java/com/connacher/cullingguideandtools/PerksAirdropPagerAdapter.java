package com.connacher.cullingguideandtools;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by Ross on 5/22/2017.
 */

class PerksAirdropPagerAdapter extends FragmentPagerAdapter {
    public PerksAirdropPagerAdapter(Activity activity, FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }

    @Override
    public android.app.Fragment getItem(int position) {
        Fragment frag;
        if(position==0){
            frag = new PerksFragment();
        }else {
            frag = new AirdropsFragment();
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Perks";
        }  else {
            return "Airdrops";
        }
    }
}

