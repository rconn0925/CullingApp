package com.rossconnacher.cullingguideandtools.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rossconnacher.cullingguideandtools.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Ross on 5/22/2017.
 */

public class AirdropViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "AirdropViewHolder";

    @InjectView(R.id.airdropCost)
    public TextView airdropCost;
    @InjectView(R.id.airdropName)
    public TextView airdropName;
    @InjectView(R.id.airdropCatagory)
    public TextView airdropCatagory;
    @InjectView(R.id.airdropContents1)
    public ImageView airdropContents1;
    @InjectView(R.id.airdropContents1Name)
    public TextView airdropContents1Name;
    @InjectView(R.id.airdropContents2)
    public ImageView airdropContents2;
    @InjectView(R.id.airdropContents2Name)
    public TextView airdropContents2Name;
    @InjectView(R.id.airdropContents3)
    public ImageView airdropContents3;
    @InjectView(R.id.airdropContents3Name)
    public TextView airdropContents3Name;
    @InjectView(R.id.airdropContents4)
    public ImageView airdropContents4;
    @InjectView(R.id.airdropContents4Name)
    public TextView airdropContents4Name;
    @InjectView(R.id.airdropContents5)
    public ImageView airdropContents5;
    @InjectView(R.id.airdropContents5Name)
    public TextView airdropContents5Name;
    @InjectView(R.id.airdropBackground)
    public LinearLayout airdropBackground;

    public AirdropViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
