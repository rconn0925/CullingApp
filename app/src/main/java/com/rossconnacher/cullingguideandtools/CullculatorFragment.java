package com.rossconnacher.cullingguideandtools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

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
    @InjectView(R.id.none)
    public RadioButton none;
    @InjectView(R.id.exposeRadioGroup)
    public RadioGroup exposeRadioGroup;

    @InjectView(R.id.minWeaponDamage)
    public TextView minWeaponDamageText;
    @InjectView(R.id.maxWeaponDamage)
    public TextView maxWeaponDamageText;
    @InjectView(R.id.minThrowDamage)
    public TextView minThrowDamageText;
    @InjectView(R.id.maxThrowDamage)
    public TextView maxThrowDamageText;


    double minDamage, maxDamage, minThrowDamage, maxThrowDamage, minBackstabDamage, maxBackstabDamage;


    double olPainlessDamage = 1.1;
    double rangerDamage = 1.1;
    double goldenArmDamage = 2;
    double craftedGoldenArmDamage = 1.5;
    double expose1Damage = 1.1;
    double expose2Damage = 1.2;
    double expose3Damage = 1.3;
    double exposeTrapperDamage = 1.3;
    double muscleMilkDamage = 1.15;
    double headshotDamage = 1.5;

    double toughMotherDamage = .95;
    double armorDamage = .8;
    double thickSkinDamage = .7;
    double bombSuitDamage = .7;
    double iron4SkinDamage = .85;

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
                "Brass Knuckles", "Tonfa", "Hammer", "Camp Hatchet","Pitchfork",
                "Crowbar", "Steel Pipe", "Cleaver", "Ice Axe", "Tanto Knife", "Machete", "Javelin", "Pike",
                "Pipe Wrench", "Baseball Bat", "Bowie Knife", "Kukri", "Tactical Machete", "Sabre", "Tomahawk","Survival Axe", "Survival Spear", "Yari",
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
                muscleManMilk.setChecked(false);
                iron4skin.setChecked(false);
                headshot.setChecked(false);
                tierOneExpose.setChecked(false);
                tierTwoExpose.setChecked(false);
                tierThreeExpose.setChecked(false);
                none.setChecked(false);
                calculateDamage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RadioButton.OnClickListener  checkListener = new RadioButton.OnClickListener (){
            @Override
            public void onClick(View v) {

                if(v.getId() == tierOneExpose.getId() ||
                    v.getId() == tierTwoExpose.getId() ||
                    v.getId() == tierThreeExpose.getId() ||
                    v.getId() == none.getId()){
                        exposeRadioGroup.clearCheck();
                        ((RadioButton)v).setChecked(true);
                        ((RadioButton)v).setClickable(true);
                        calculateDamage();
                } else {


                    if (v.isSelected() == true) {
                        ((RadioButton) v).setSelected(false);
                        ((RadioButton) v).setChecked(false);
                        ((RadioButton) v).setClickable(true);
                        calculateDamage();
                    } else {
                        ((RadioButton) v).setSelected(true);
                        ((RadioButton) v).setChecked(true);
                        ((RadioButton) v).setClickable(true);
                        calculateDamage();
                    }
                    ((RadioButton) v).setClickable(true);
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
        muscleManMilk.setOnClickListener(checkListener);
        iron4skin.setOnClickListener(checkListener);
        headshot.setOnClickListener(checkListener);
        tierOneExpose.setOnClickListener(checkListener);
        tierTwoExpose.setOnClickListener(checkListener);
        tierThreeExpose.setOnClickListener(checkListener);
        none.setOnClickListener(checkListener);


        return view;
    }

    private void calculateOlPainless() {

        if (olPainless.isChecked()) {
            minDamage *= olPainlessDamage;
            maxDamage *= olPainlessDamage;
            minThrowDamage *= olPainlessDamage;
            maxThrowDamage *= olPainlessDamage;
            minBackstabDamage *= olPainlessDamage;
            maxBackstabDamage *= olPainlessDamage;
        }
        /*
        else if (!olPainless.isChecked()) {
            minDamage /= olPainlessDamage;
            maxDamage /= olPainlessDamage;
            minThrowDamage /= olPainlessDamage;
            maxThrowDamage /= olPainlessDamage;
            minBackstabDamage /= olPainlessDamage;
            maxBackstabDamage /= olPainlessDamage;
        }
        */
        //showDamage();
    }
    private void calculateGoldenArm(){
        if (goldenArm.isChecked() &&
                (weaponSpinner.getSelectedItem().toString().equals("Javelin") ||
                weaponSpinner.getSelectedItem().toString().equals("Pike") ||
                weaponSpinner.getSelectedItem().toString().equals("Survival Spear")||
                weaponSpinner.getSelectedItem().toString().equals("Yari") ||
                weaponSpinner.getSelectedItem().toString().equals("Javelin") ||
                weaponSpinner.getSelectedItem().toString().equals("Trident")))
        {
            minThrowDamage *= goldenArmDamage;
            maxThrowDamage *= goldenArmDamage;
        } else if (goldenArm.isChecked() && weaponSpinner.getSelectedItem().toString().equals("Crafted Spear")){
            minThrowDamage *= craftedGoldenArmDamage;
            maxThrowDamage *= craftedGoldenArmDamage;
        }
    }

    private void calculateBrutus() {

        if(brutus.isChecked()){
            if(weaponSpinner.getSelectedItem().toString().equals("Tanto Knife") ||
                weaponSpinner.getSelectedItem().toString().equals("Crafted Knife") ||
                weaponSpinner.getSelectedItem().toString().equals("Machete") ||
                weaponSpinner.getSelectedItem().toString().equals("Kukri") ||
                weaponSpinner.getSelectedItem().toString().equals("Bowie Knife") ||
                weaponSpinner.getSelectedItem().toString().equals("Katana") ||
                weaponSpinner.getSelectedItem().toString().equals("Sabre") ||
                weaponSpinner.getSelectedItem().toString().equals("Tactical Machete")){
                    minDamage = minBackstabDamage;
                    maxDamage = maxBackstabDamage;
            }
        }
    }
    private void calculateRanger() {
        if(ranger.isChecked()) {
            if(weaponSpinner.getSelectedItem().toString().equals("Crafted Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Recurve Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Compound Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Auto Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("SMG") ||
                weaponSpinner.getSelectedItem().toString().equals("Revolver") ||
                weaponSpinner.getSelectedItem().toString().equals("Rifle")){
                    minDamage *= rangerDamage;
                    maxDamage *= rangerDamage;
            }
        }

    }

    public void calculateToughMother(){
        if(toughMother.isChecked()){
            minDamage *= toughMotherDamage;
            maxDamage *= toughMotherDamage;
            minThrowDamage *= toughMotherDamage;
            maxThrowDamage *= toughMotherDamage;
        }
    }

    public void calculateBombSuit(){
        if(bombSuit.isChecked()){
            if(weaponSpinner.getSelectedItem().toString().equals("SMG") ||
                weaponSpinner.getSelectedItem().toString().equals("Rifle") ||
                weaponSpinner.getSelectedItem().toString().equals("Revolver") ||
                weaponSpinner.getSelectedItem().toString().equals("Crafted Explosive") ||
                weaponSpinner.getSelectedItem().toString().equals("Dynamite") ||
                weaponSpinner.getSelectedItem().toString().equals("Explosive Mine") ||
                weaponSpinner.getSelectedItem().toString().equals("Remote Explosive")){
                    minDamage *= bombSuitDamage;
                    maxDamage *= bombSuitDamage;
            }
        }
    }
    public void calculateThickSkin(){
        if(thickSkin.isChecked()){
            if(weaponSpinner.getSelectedItem().toString().equals("Crafted Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Recurve Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Compound Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Auto Bow")){
                    minDamage *= thickSkinDamage;
                    maxDamage *= thickSkinDamage;
                    minThrowDamage *= thickSkinDamage;
                    maxThrowDamage *= thickSkinDamage;
            } else {
                minThrowDamage *=thickSkinDamage;
                maxThrowDamage *= thickSkinDamage;
            }
        }
    }
    public void calculateArmor(){
        if(armor.isChecked()){
            minDamage *= armorDamage;
            maxDamage *= armorDamage;
            minThrowDamage *= armorDamage;
            maxThrowDamage *= armorDamage;
        }
    }
    public void calculateMuslemanMilk(){
        if(muscleManMilk.isChecked()){
            minDamage *= muscleMilkDamage;
            maxDamage *= muscleMilkDamage;
            minThrowDamage *= muscleMilkDamage;
            maxThrowDamage *= muscleMilkDamage;
        }
    }
    public void calculateIron4Skin(){
        if(iron4skin.isChecked()){
            minDamage *= iron4SkinDamage;
            maxDamage *= iron4SkinDamage;
            minThrowDamage *= iron4SkinDamage;
            maxThrowDamage *= iron4SkinDamage;
        }
    }
    public void calculateHeadshot(){
        if(headshot.isChecked()){
            if(weaponSpinner.getSelectedItem().toString().equals("Crafted Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Recurve Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Compound Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("Auto Bow") ||
                weaponSpinner.getSelectedItem().toString().equals("SMG") ||
                weaponSpinner.getSelectedItem().toString().equals("Revolver") ||
                weaponSpinner.getSelectedItem().toString().equals("Rifle")){
                    minDamage *= headshotDamage;
                    maxDamage *= headshotDamage;
            }
        }
    }
    public void calculateExpose(){
        if(tierOneExpose.isChecked()){
            minDamage *= expose1Damage;
            maxDamage *= expose1Damage;
            minThrowDamage *= expose1Damage;
            maxThrowDamage *= expose1Damage;
        } else if (tierTwoExpose.isChecked()){
            minDamage *= expose2Damage;
            maxDamage *= expose2Damage;
            minThrowDamage *= expose2Damage;
            maxThrowDamage *= expose2Damage;
        } else if (tierThreeExpose.isChecked()) {
            minDamage *= expose3Damage;
            maxDamage *= expose3Damage;
            minThrowDamage *= expose3Damage;
            maxThrowDamage *= expose3Damage;
        } else {

        }
    }
    private void calculateDamage() {

        weaponDamage();
        calculateOlPainless();
        calculateGoldenArm();
        calculateBrutus();
        calculateRanger();
        calculateToughMother();
        calculateBombSuit();
        calculateThickSkin();
        calculateArmor();
        calculateMuslemanMilk();
        calculateIron4Skin();
        calculateHeadshot();
        calculateExpose();
        maxDamage = Math.round(maxDamage*100.0)/100.0;
        minDamage = Math.round(minDamage*100.0)/100.0;
        maxThrowDamage = Math.round(maxThrowDamage*100.0)/100.0;
        minThrowDamage = Math.round(minThrowDamage*100.0)/100.0;

        minThrowDamageText.setText(""+minThrowDamage);
        maxThrowDamageText.setText(""+maxThrowDamage);
        minWeaponDamageText.setText(""+minDamage);
        maxWeaponDamageText.setText(""+maxDamage);
    }


    private void weaponDamage() {

        if (weaponSpinner.getSelectedItem().toString().equals("Rock")) {
            minDamage = 4;
            maxDamage = 8;
            minThrowDamage = 4;
            maxThrowDamage = 8;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Stick")) {
            minDamage = 4;
            maxDamage = 8;
            minThrowDamage = 4;
            maxThrowDamage = 8;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Fists")) {
            minDamage = 4;
            maxDamage = 8;
            minThrowDamage = 0;
            maxThrowDamage = 0;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Crafted Knife")) {
            minDamage = 4;
            maxDamage = 12;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Crafted Spear")) {
            minDamage = 4;
            maxDamage = 13;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Crafted Hatchet")) {
            minDamage = 4;
            maxDamage = 12;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Crafted Cudgel")) {
            minDamage = 4;
            maxDamage = 13;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Brass Knuckles")) {
            minDamage = 5;
            maxDamage = 15;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Tonfa")) {
            minDamage = 5;
            maxDamage = 15;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Camp Hatchet")) {
            minDamage = 5;
            maxDamage = 14;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        }  else if (weaponSpinner.getSelectedItem().toString().equals("Hammer")) {
            minDamage = 5;
            maxDamage = 15;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        }else if (weaponSpinner.getSelectedItem().toString().equals("Crowbar")) {
            minDamage = 6;
            maxDamage = 18;
            minThrowDamage = 5;
            maxThrowDamage = 15;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Steel Pipe")) {
            minDamage = 6;
            maxDamage = 18;
            minThrowDamage = 5;
            maxThrowDamage = 15;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Cleaver")) {
            minDamage = 6;
            maxDamage = 16;
            minThrowDamage = 5;
            maxThrowDamage = 15;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Ice Axe")) {
            minDamage = 6;
            maxDamage = 17;
            minThrowDamage = 5;
            maxThrowDamage = 15;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Survival Axe")) {
            minDamage = 7;
            maxDamage = 19;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Pitchfork")) {
            minDamage = 5;
            maxDamage = 15;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Pike")) {
            minDamage = 6;
            maxDamage = 18;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Tanto Knife")) {
            minDamage = 5;
            maxDamage = 14;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Machete")) {
            minDamage = 5;
            maxDamage = 15;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 4;
            maxThrowDamage = 12;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Javelin")) {
            minDamage = 6;
            maxDamage = 18;
            minThrowDamage = 6;
            maxThrowDamage = 21;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Pipe Wrench")) {
            minDamage = 7;
            maxDamage = 22;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Baseball Bat")) {
            minDamage = 7;
            maxDamage = 22;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Bowie Knife")) {
            minDamage = 7;
            maxDamage = 19;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Kukri")) {
            minDamage = 6;
            maxDamage = 16;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 5;
            maxThrowDamage = 15;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Tactical Machete")) {
            minDamage = 7;
            maxDamage = 20;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Sabre")) {
            minDamage = 6;
            maxDamage = 17;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 5;
            maxThrowDamage = 15;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Tomahawk")) {
            minDamage = 7;
            maxDamage = 19;
            minThrowDamage = 7;
            maxThrowDamage = 24;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Survival Spear")) {
            minDamage = 7;
            maxDamage = 22;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Yari")) {
            minDamage = 7;
            maxDamage = 22;
            minThrowDamage = 6;
            maxThrowDamage = 18;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Sledgehammer")) {
            minDamage = 8;
            maxDamage = 27;
            minThrowDamage = 7;
            maxThrowDamage = 21;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Katana")) {
            minDamage = 8;
            maxDamage = 25;
            minBackstabDamage = minDamage * 1.25;
            maxBackstabDamage = maxDamage * 1.25;
            minThrowDamage = 7;
            maxThrowDamage = 21;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Fireman's Axe")) {
            minDamage = 8;
            maxDamage = 23;
            minThrowDamage = 7;
            maxThrowDamage = 21;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Trident")) {
            minDamage = 8;
            maxDamage = 27;
            minThrowDamage = 7;
            maxThrowDamage = 21;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Crafted Explosive")) {
            minDamage = 30;
            maxDamage = 40;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Dynamite")) {
            minDamage = 60;
            maxDamage = 60;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Impact Grenade")) {
            minDamage = 40;
            maxDamage = 40;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Explosive Mine")) {
            minDamage = 40;
            maxDamage = 40;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Remote Explosive")) {
            minDamage = 60;
            maxDamage = 60;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Revolver")) {
            minDamage = 25;
            maxDamage = 25;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("SMG")) {
            minDamage = 10;
            maxDamage = 10;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Rifle")) {
            minDamage = 40;
            maxDamage = 40;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Crafted Bow")) {
            minDamage = 6;
            maxDamage = 12;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Recurve Bow")) {
            minDamage = 8;
            maxDamage = 16;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Compound Bow")) {
            minDamage = 10;
            maxDamage = 20;
            minThrowDamage = 5;
            maxThrowDamage = 5;

        } else if (weaponSpinner.getSelectedItem().toString().equals("Auto Bow")) {
            minDamage = 8;
            maxDamage = 8;
            minThrowDamage = 5;
            maxThrowDamage = 5;

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
