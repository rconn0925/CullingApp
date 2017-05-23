package com.rossconnacher.cullingapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CullculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CullculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CullculatorFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @InjectView(R.id.weaponSpinner)
    public Spinner weaponSpinner;
    @InjectView(R.id.olPainless)
    public RadioButton olPainless;
    @InjectView(R.id.goldenArm)
    public RadioButton goldenArm;
    @InjectView(R.id.brutus)
    public RadioButton brutus;
    @InjectView(R.id.ranger)
    public RadioButton ranger;
    @InjectView(R.id.toughMother)
    public RadioButton toughMother;
    @InjectView(R.id.bombSuit)
    public RadioButton bombSuit;
    @InjectView(R.id.thickSkin)
    public RadioButton thickSkin;
    @InjectView(R.id.armor)
    public RadioButton armor;
    @InjectView(R.id.backstab)
    public RadioButton backstab;
    @InjectView(R.id.muscleManMilk)
    public RadioButton muscleManMilk;
    @InjectView(R.id.iron4skin)
    public RadioButton iron4skin;
    @InjectView(R.id.headshot)
    public RadioButton headshot;
    @InjectView(R.id.tierOneExpose)
    public RadioButton tierOneExpose;
    @InjectView(R.id.tierTwoExpose)
    public RadioButton tierTwoExpose;
    @InjectView(R.id.tierThreeExpose)
    public RadioButton tierThreeExpose;
    @InjectView(R.id.trapper)
    public RadioButton trapper;



    String[] weaponList;

    private PerksFragment.OnFragmentInteractionListener mListener;

    public CullculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CullculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CullculatorFragment newInstance(String param1, String param2) {
        CullculatorFragment fragment = new CullculatorFragment();
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
        View view = inflater.inflate(R.layout.fragment_cullculator, container, false);
       // weaponSpinner
        ButterKnife.inject(this,view);
        weaponList = new String[]{"Fists", "Rock", "Stick",
                "Crafted Knife", "Crafted Spear", "Crafted Hatchet", "Crafted Cudgel",
                "Brass Knuckles", "Tonfa", "Hammer",
                "Crowbar", "Steel Pipe", "Cleaver", "Ice Axe", "Tanto Knife", "Machete", "Javelin",
                "Pipe Wrench", "Baseball Bat", "Bowie Knife", "Kukri", "Tactical Machete", "Sabre", "Tomahawk", "Survival Spear",
                "Sledgehammer", "Katana", "Fireman's Axe", "Trident",
                "Crafted Bow", "Recurve Bow", "Compound Bow", "Auto Bow",
                "Crafted Explosive", "Dynamite", "Impact Grenade", "Explosive Mine", "Remote Explosive",
                "Revolver", "SMG", "Rifle"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, weaponList);
        weaponSpinner.setAdapter(adapter);
        weaponSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                olPainless.setChecked(false);
                goldenArm.setChecked(false);
                brutus.setChecked(false);
                ranger.setChecked(false);
                toughMother.setChecked(false);
                bombSuit.setChecked(false);
                thickSkin.setChecked(false);
                armor.setChecked(false);
                backstab.setChecked(false);
                muscleManMilk.setChecked(false);
                iron4skin.setChecked(false);
                headshot.setChecked(false);
                tierOneExpose.setChecked(false);
                tierTwoExpose.setChecked(false);
                tierThreeExpose.setChecked(false);
                trapper.setChecked(false);
                calculateDamage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        RadioButton.OnClickListener  checkListener = new RadioButton.OnClickListener (){
            @Override
            public void onClick(View v) {
                if(v.isSelected()==true){
                    v.setSelected(false);
                    ((RadioButton)v).setChecked(false);
                    v.setClickable(true);
                } else {
                    v.setSelected(true);
                    ((RadioButton)v).setChecked(true);
                    v.setClickable(true);
                }
            }
        };
        olPainless.setOnClickListener(checkListener);
        goldenArm.setOnClickListener(checkListener);
        brutus.setOnClickListener(checkListener);
        ranger.setOnClickListener(checkListener);
        toughMother.setOnClickListener(checkListener);
        bombSuit.setOnClickListener(checkListener);
        thickSkin.setOnClickListener(checkListener);
        armor.setOnClickListener(checkListener);
        backstab.setOnClickListener(checkListener);
        muscleManMilk.setOnClickListener(checkListener);
        iron4skin.setOnClickListener(checkListener);
        headshot.setOnClickListener(checkListener);
        tierOneExpose.setOnClickListener(checkListener);
        tierTwoExpose.setOnClickListener(checkListener);
        tierThreeExpose.setOnClickListener(checkListener);
        trapper.setOnClickListener(checkListener);


        return view;
    }

    private void calculateDamage() {
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
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */

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
