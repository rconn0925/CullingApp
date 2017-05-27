package com.connacher.cullingguideandtools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.connacher.cullingguideandtools.adapters.PerkAdapter;
import com.connacher.cullingguideandtools.models.Perk;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerksFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerksFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<Perk> allPerks;
    private GridLayoutManager mPerksLayoutManager;
    private PerkAdapter mPerksAdapter;
    @InjectView(R.id.allPerks)
    RecyclerView mPerksView;

    public PerksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerksFragment newInstance(String param1, String param2) {
        PerksFragment fragment = new PerksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perks, container, false);
        ButterKnife.inject(this,view);
        mPerksLayoutManager = new GridLayoutManager(getActivity(), 1);
        mPerksView.setLayoutManager(mPerksLayoutManager);
        mPerksView.addItemDecoration(new SimpleDividerItemDecoration(this.getActivity()));
        mPerksAdapter = new PerkAdapter(getActivity(), new ArrayList<Perk>());
        mPerksView.setAdapter(mPerksAdapter);
        addPerksToView();

        return view;
    }


    public void addPerksToView() {
        //create all perks
        Perk perk1 = new Perk("Cannibal","Survival","Killing an opponent restores 20 additional health and full stamina");
        Perk perk2 = new Perk("Regenerator", "Survival","Recover 1 health point every 4 seconds (10 second cooldown after taking damage)");
        Perk perk3 = new Perk("Angry Octopus","Survival","When reduced below 20 health automatically drop a smoke bomb (once per match)");
        Perk perk4 = new Perk("Blood Guzzler","Survival","If someone is bleeding within 15 meters of you, you gain 1 health per 3 seconds");
        Perk perk5 = new Perk("Bomb Suit","Survival","Reduce all damage from firearms and explosives by 30%");
        Perk perk6 = new Perk("Dig Deep","Survival","Recover 10 health when you drop to 1hp (once per match)");
        Perk perk7 = new Perk("Immunity","Survival","Immune to bonus damage from backstabs and headshots");
        Perk perk8 = new Perk("Inhuman","Survival","You can not be tracked with a man tracker and are immune to the alarm gun");
        Perk perk9 = new Perk("Sixth Scents","Survival","Become alerted when a player is within 20 meters (30 second cooldown)");
        Perk perk10 = new Perk("Thick Skin","Survival","Reduce all damage from bows, blowguns, and thrown weapons by 30% while holding an axe");
        Perk perk11 = new Perk("Tough Mother","Survival","Reduce all incoming damage by 5%");
        Perk perk12 = new Perk("Moneybags","Utility","Gain +2 bonus FUNC each time FUNC is gathered");
        Perk perk13 = new Perk("Master Crafter","Utility","Craft time reduced by 25%");
        Perk perk14 = new Perk("Bow Flexer","Utility","+25% arrow velocity and 25% charge time reduction with all bows");
        Perk perk15 = new Perk("Chemist","Utility","Stim effects last 50% longer");
        Perk perk16 = new Perk("Load Dropper","Utility","Airdrops arrive much faster");
        Perk perk17 = new Perk("Man Tracker","Utility","Start the match with a man tracker in your inventory");
        Perk perk18 = new Perk("Backpacker","Utility","Start the match with a backpack in your inventory");
        Perk perk19 = new Perk("Basher","Combat","-15% melee and thrown charge time with all bludgeons");
        Perk perk20 = new Perk("Brutus","Combat","+25% backstab damage with any blade");
        Perk perk21 = new Perk("Golden Arm","Combat","+25% velocity and +100% damage for thrown spears (+50% for crafter) Maximum effect at 20 meters");
        Perk perk22 = new Perk("Mangler","Combat","40% of melee damage dealth with axes is also applied to opponents stamina");
        Perk perk23 = new Perk("Ranger","Combat","+10% damage with all ranged weapons");
        Perk perk24 = new Perk("Trapper","Combat","-75% time to place and disarm traps. Snares apply a 30% expose wound");
        Perk perk25 = new Perk("Speedy Spear","Movement","+5% sprint speed and sprint stamina cost increased while holding any spear");
        Perk perk26 = new Perk("Stealthy Blade","Movement","Your movement is nearly silent while holding any blade");
        Perk perk27 = new Perk("Recovery","Movement","+30% faster stamina regeneration");
      
        //add all perks to list
        allPerks = new ArrayList<Perk>();
        allPerks.add(perk1);
        allPerks.add(perk2);
        allPerks.add(perk3);
        allPerks.add(perk4);
        allPerks.add(perk5);
        allPerks.add(perk6);
        allPerks.add(perk7);
        allPerks.add(perk8);
        allPerks.add(perk9);
        allPerks.add(perk10);
        allPerks.add(perk11);
        allPerks.add(perk12);
        allPerks.add(perk13);
        allPerks.add(perk14);
        allPerks.add(perk15);
        allPerks.add(perk16);
        allPerks.add(perk17);
        allPerks.add(perk18);
        allPerks.add(perk19);
        allPerks.add(perk20);
        allPerks.add(perk21);
        allPerks.add(perk22);
        allPerks.add(perk23);
        allPerks.add(perk24);
        allPerks.add(perk25);
        allPerks.add(perk26);
        allPerks.add(perk27);
        mPerksAdapter.removeAll();
        for(int i = 0;i<allPerks.size();i++){
            mPerksAdapter.add(allPerks.get(i));
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
