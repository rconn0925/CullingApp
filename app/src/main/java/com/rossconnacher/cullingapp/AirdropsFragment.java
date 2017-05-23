package com.rossconnacher.cullingapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rossconnacher.cullingapp.adapters.AirdropAdapter;
import com.rossconnacher.cullingapp.models.Airdrop;
import com.rossconnacher.cullingapp.models.Perk;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AirdropsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AirdropsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AirdropsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private GridLayoutManager mAirdropLayoutManager;
    private AirdropAdapter mAirdropAdapter;
    @InjectView(R.id.allAirdrops)
    RecyclerView mAirdropView;
    private ArrayList<Airdrop> allAirdrops;

    public AirdropsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AirdropFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AirdropsFragment newInstance(String param1, String param2) {
        AirdropsFragment fragment = new AirdropsFragment();
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
        View view = inflater.inflate(R.layout.fragment_airdrop, container, false);
        ButterKnife.inject(this, view);
        mAirdropLayoutManager = new GridLayoutManager(getActivity(), 1);
        mAirdropView.setLayoutManager(mAirdropLayoutManager);
        mAirdropView.addItemDecoration(new SimpleDividerItemDecoration(this.getActivity()));
        mAirdropAdapter = new AirdropAdapter(getActivity(), new ArrayList<Airdrop>());
        mAirdropView.setAdapter(mAirdropAdapter);
        addAirdropsToView();
        return view;
    }

    private void addAirdropsToView() {
        //create all airdrops
        Airdrop airdrop1 = new Airdrop("Helsing", new String[]{"Auto Bow", "Steel Punji Sticks","Pepper Spray"},100,"Mid");
        Airdrop airdrop2 = new Airdrop("Chef", new String[]{"Cleaver", "Bandage","Muscleman Milk"},100,"Mid");
        Airdrop airdrop3 = new Airdrop("Car Jacker", new String[]{"Crowbar", "Man Tracker","Crafted Explosive"},100,"Mid");
        Airdrop airdrop4 = new Airdrop("Golden Arm", new String[]{"Javelin", "Javelin","Javelin"},100,"Mid");
        Airdrop airdrop5 = new Airdrop("Climber", new String[]{"Ice Axe", "Steel Snares","Steel Punji Sticks"},100,"Mid");
        Airdrop airdrop6 = new Airdrop("Marauder", new String[]{"Kukri", "Crafted Blowgun","Reinforced Crafted Armor"},100,"Mid");
        Airdrop airdrop7 = new Airdrop("Defender", new String[]{"Pike","Tactical Body Armor"},100,"Mid");
        Airdrop airdrop8 = new Airdrop("Cupid", new String[]{"Recurve Bow", "Gas Grenade","Crafted Smoke Bomb"},100,"Mid");
        Airdrop airdrop9 = new Airdrop("Cavalry", new String[]{"Sabre", "Backpack","X-Plosive Runs"},100,"Mid");
        Airdrop airdrop10 = new Airdrop("Thug", new String[]{"Steel Pipe", "Muscleman Milk","Iron-4-Skin"},100,"Mid");
        Airdrop airdrop11 = new Airdrop("Random Tier 3 Axe", new String[]{"Random T3 Axe"},100,"Mid");
        Airdrop airdrop12 = new Airdrop("Random Tier 3 Blade", new String[]{"Random T3 Blade"},100,"Mid");
        Airdrop airdrop13 = new Airdrop("Random Tier 3 Bludgeon", new String[]{"Random T3 Bludgeon"},100,"Mid");
        Airdrop airdrop14 = new Airdrop("Random Tier 3 Spear", new String[]{"Random T3 Spear"},100,"Mid");
        Airdrop airdrop15 = new Airdrop("Long Ball", new String[]{"Baseball Bat", "Reinforced Crafted Armor","Gas Grenade","Crafted Explosive"},150,"Late");
        Airdrop airdrop16 = new Airdrop("Outback", new String[]{"Bowie Knife", "Steel Punji Sticks","Steel Snares","Steel Caltrops"},150,"Late");
        Airdrop airdrop17 = new Airdrop("Black Thumb", new String[]{"Pipe Wrench", "Pepper Spray","Iron-4-Skin","Steel Punji Sticks"},150,"Late");
        Airdrop airdrop18 = new Airdrop("Survivalist", new String[]{"Survival Axe", "Reinforced Crafted Armor","Bandage","Hemo Blast"},150,"Late");
        Airdrop airdrop19 = new Airdrop("Boar Hunter", new String[]{"Survival Spear", "Crafted Blowgun","Steel Snares","Backpack"},150,"Late");
        Airdrop airdrop20 = new Airdrop("Spec Ops", new String[]{"Tactical Machete", "Remote Explosive","Iron-4-Skin","Lung Butter"},150,"Late");
        Airdrop airdrop21 = new Airdrop("Wildling", new String[]{"Tomahawk", "Crafted Blowgun","Crafted Explosive","Hemo Drip"},150,"Late");
        Airdrop airdrop22 = new Airdrop("Spearman", new String[]{"Yari", "Reinforced Crafted Armor","Steel Caltrops","Muscleman Milk"},150,"Late");
        Airdrop airdrop23 = new Airdrop("Big Game", new String[]{"Compound Bow", "Crafted Explosive","Steel Caltrops"},200,"Late");
        Airdrop airdrop24 = new Airdrop("Fireman's Axe", new String[]{"Fireman's Axe"},200,"Late");
        Airdrop airdrop25 = new Airdrop("Katana", new String[]{"Katana"},200,"Late");
        Airdrop airdrop26 = new Airdrop("Sledgehammer", new String[]{"Sledgehammer"},200,"Late");
        Airdrop airdrop27 = new Airdrop("Trident", new String[]{"Trident"},200,"Late");
        Airdrop airdrop28 = new Airdrop("Random Gun", new String[]{"Random Gun"},200,"Late");
        Airdrop airdrop29 = new Airdrop("Stims", new String[]{"Backpack","Med Kit","Muscleman Milk","Iron-4-Skin","Silent But Deadly"},75,"Utility");
        Airdrop airdrop30 = new Airdrop("Tracker", new String[]{"Backpack","Alarm Gun","Man Tracker","Silent But Deadly","X-Plosive Runs"},75,"Utility");
        Airdrop airdrop31 = new Airdrop("Traps", new String[]{"Backpack","Steel Snares","Explosive Mine","Steel Punji Sticks","Steel Caltrops"},75,"Utility");
        Airdrop airdrop32 = new Airdrop("Bait Crate", new String[]{""},0,"Utility");

        //add all airdrops to list
        allAirdrops = new ArrayList<Airdrop>();
        allAirdrops.add(airdrop1);
        allAirdrops.add(airdrop2);
        allAirdrops.add(airdrop3);
        allAirdrops.add(airdrop4);
        allAirdrops.add(airdrop5);
        allAirdrops.add(airdrop6);
        allAirdrops.add(airdrop7);
        allAirdrops.add(airdrop8);
        allAirdrops.add(airdrop9);
        allAirdrops.add(airdrop10);
        allAirdrops.add(airdrop11);
        allAirdrops.add(airdrop12);
        allAirdrops.add(airdrop13);
        allAirdrops.add(airdrop14);
        allAirdrops.add(airdrop15);
        allAirdrops.add(airdrop16);
        allAirdrops.add(airdrop17);
        allAirdrops.add(airdrop18);
        allAirdrops.add(airdrop19);
        allAirdrops.add(airdrop20);
        allAirdrops.add(airdrop21);
        allAirdrops.add(airdrop22);
        allAirdrops.add(airdrop23);
        allAirdrops.add(airdrop24);
        allAirdrops.add(airdrop25);
        allAirdrops.add(airdrop26);
        allAirdrops.add(airdrop27);
        allAirdrops.add(airdrop28);
        allAirdrops.add(airdrop29);
        allAirdrops.add(airdrop30);
        allAirdrops.add(airdrop31);
        allAirdrops.add(airdrop32);
        mAirdropAdapter.removeAll();
        for(int i = 0;i<allAirdrops.size();i++){
            mAirdropAdapter.add(allAirdrops.get(i));
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
