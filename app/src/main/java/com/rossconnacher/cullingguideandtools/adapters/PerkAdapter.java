package com.rossconnacher.cullingguideandtools.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rossconnacher.cullingguideandtools.R;
import com.rossconnacher.cullingguideandtools.models.Perk;
import com.rossconnacher.cullingguideandtools.viewholders.PerkViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 5/22/2017.
 */

public class PerkAdapter extends RecyclerView.Adapter<PerkViewHolder> {

    private static final String TAG = "PerkAdapter";

    private Context mContext;
    private List<Perk> mPerks;

    public PerkAdapter(Context context, ArrayList<Perk> perks){
        this.mContext = context;
        this.mPerks = perks;
    }

    @Override
    public PerkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.perk_item, parent, false);
        return new PerkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PerkViewHolder holder, int position) {
        final Perk perk = mPerks.get(position);
        holder.perkName.setText(perk.getPerkName());
        holder.perkCatagory.setText(perk.getCatagory());
        holder.perkDescription.setText(perk.getPerkText());
        //holder.perkImage.setImageDrawable(perk.getPerkName());
    }

    @Override
    public int getItemCount() {
        return mPerks.size();
    }
    public void add(Perk perk) {

        mPerks.add(perk);
        notifyItemInserted(mPerks.size() - 1);
    }

    public void remove(int position) {

        mPerks.remove(position);
        notifyItemRemoved(position);
    }

    public void removeAll() {

        mPerks.clear();
    }
}
