package com.rossconnacher.cullingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rossconnacher.cullingapp.R;
import com.rossconnacher.cullingapp.models.Airdrop;
import com.rossconnacher.cullingapp.viewholders.AirdropViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 5/22/2017.
 */

public class AirdropAdapter  extends RecyclerView.Adapter<AirdropViewHolder>{

    private static final String TAG = "AirdropAdapter";

    private Context mContext;
    private List<Airdrop> mAirdrops;

    public AirdropAdapter(Context context, ArrayList<Airdrop> airdrops){
        this.mContext = context;
        this.mAirdrops = airdrops;
    }

    @Override
    public AirdropViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.airdrop_item, parent, false);
        return new AirdropViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AirdropViewHolder holder, int position) {

        final Airdrop airdrop = mAirdrops.get(position);
        holder.airdropName.setText(airdrop.getAirdropName());
        holder.airdropCatagory.setText(airdrop.getAirdropCatagory());
        holder.airdropCost.setText(airdrop.getAirdropCost()+" FUNC");

        for(int i = 0; i < airdrop.getAirdropContents().length; i++)
        {
            if(i==0){
                if(airdrop.getAirdropContents().length==1)
                {
                    holder.airdropContents1Name.setText(airdrop.getAirdropContents()[0]);
                    holder.airdropContents2Name.setText("");
                    holder.airdropContents3Name.setText("");
                    holder.airdropContents4Name.setText("");
                    holder.airdropContents5Name.setText("");
                    break;
                } else {
                    holder.airdropContents1Name.setText(airdrop.getAirdropContents()[0]);
                }
               // holder.airdropContents1.setImageDrawable(R.drawable.);
            } else if (i == 1){
                if(airdrop.getAirdropContents().length==2){
                    holder.airdropContents2Name.setText(airdrop.getAirdropContents()[1]);
                    holder.airdropContents3Name.setText("");
                    holder.airdropContents4Name.setText("");
                    holder.airdropContents5Name.setText("");
                    break;
                } else {
                    holder.airdropContents2Name.setText(airdrop.getAirdropContents()[1]);
                }
            } else if (i == 2){
                if(airdrop.getAirdropContents().length==3)
                {
                    holder.airdropContents3Name.setText(airdrop.getAirdropContents()[2]);
                    holder.airdropContents4Name.setText("");
                    holder.airdropContents5Name.setText("");
                    break;
                } else {
                    holder.airdropContents3Name.setText(airdrop.getAirdropContents()[2]);
                }
            } else if (i == 3){
                if(airdrop.getAirdropContents().length==3)
                {
                    holder.airdropContents4Name.setText(airdrop.getAirdropContents()[3]);
                    holder.airdropContents5Name.setText("");
                    break;
                } else {
                    holder.airdropContents4Name.setText(airdrop.getAirdropContents()[3]);
                }
            } else {
                holder.airdropContents5Name.setText(airdrop.getAirdropContents()[4]);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mAirdrops.size();
    }

    public void add(Airdrop airdrop) {

        mAirdrops.add(airdrop);
        notifyItemInserted(mAirdrops.size() - 1);
    }

    public void remove(int position) {

        mAirdrops.remove(position);
        notifyItemRemoved(position);
    }

    public void removeAll() {
        mAirdrops.clear();
    }
}
