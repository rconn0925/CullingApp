package com.rossconnacher.cullingguideandtools.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rossconnacher.cullingguideandtools.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Ross on 5/22/2017.
 */

public class PerkViewHolder extends RecyclerView.ViewHolder{

    @InjectView(R.id.perkImage)
    public ImageView perkImage;
    @InjectView(R.id.perkName)
    public TextView perkName;
    @InjectView(R.id.perkCatagory)
    public TextView perkCatagory;
    @InjectView(R.id.perkDescription)
    public TextView perkDescription;

    public PerkViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
