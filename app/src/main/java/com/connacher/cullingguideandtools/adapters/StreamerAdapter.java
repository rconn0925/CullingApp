package com.connacher.cullingguideandtools.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.connacher.cullingguideandtools.R;
import com.connacher.cullingguideandtools.models.Perk;
import com.connacher.cullingguideandtools.models.Streamer;
import com.connacher.cullingguideandtools.viewholders.StreamerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 5/27/2017.
 */

public class StreamerAdapter extends RecyclerView.Adapter<StreamerViewHolder>{

    private static final String TAG = "StreamerAdapter";

    private Context mContext;
    private List<Streamer> mStreamers;

    public StreamerAdapter(Context context, ArrayList<Streamer> streamers){
        this.mContext = context;
        this.mStreamers = streamers;
    }


    @Override
    public StreamerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.streamer_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(mContext, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(mContext);
                }
                builder.setTitle("Redirecting to Twitch")
                        .setMessage("Do you want to watch the stream?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitch.tv/directory/game/The%20Culling"));
                                mContext.startActivity(browserIntent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });
        return new StreamerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StreamerViewHolder holder, int position) {
        final Streamer streamer = mStreamers.get(position);
        holder.streamerTitle.setText(streamer.getTitle());
        holder.streamerViewersAndName.setText(streamer.getViewers()+" viewers on "+ streamer.getName());
        Picasso.with(mContext).load("https:"+streamer.getPreviewImageUrl()).into(holder.streamerPreviewImage);
        Picasso.with(mContext).load("https:"+streamer.getLogoImageUrl()).into(holder.streamerLogo);

    }

    @Override
    public int getItemCount() {
        return mStreamers.size();
    }
    // Where “packagename” is the package name of the Twitch app:

    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
