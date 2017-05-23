package com.rossconnacher.cullingguideandtools;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.Fragment;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by Ross on 5/21/2017.
 */

class MapsPagerAdapter extends FragmentPagerAdapter {
    public MapsPagerAdapter(Activity activity, FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }

    @Override
    public android.app.Fragment getItem(int position) {
        Fragment frag;
        if(position==0){
            frag = new IslandMapFragment();
        }else {
            frag = new PrisonMapFragment();
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
            return "Island";
        }  else {
            return "Prison";
        }
    }
}
