package com.connacher.cullingguideandtools.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.connacher.cullingguideandtools.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Ross on 5/27/2017.
 */

public class StreamerViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.streamerPreviewImage)
    public ImageView streamerPreviewImage;
    @InjectView(R.id.streamerTitle)
    public TextView streamerTitle;
    @InjectView(R.id.streamerViewersAndName)
    public TextView streamerViewersAndName;

    public StreamerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
