package com.rossconnacher.cullingapp;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rossconnacher.cullingapp.models.Airdrop;
import com.rossconnacher.cullingapp.models.Perk;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AirdropsPerksFragment.OnFragmentInteractionListener,
        CraftingRecipesFragment.OnFragmentInteractionListener,
        CullculatorFragment.OnFragmentInteractionListener,
        GuidesFragment.OnFragmentInteractionListener,
        LoadoutRandomizerFragment.OnFragmentInteractionListener,
        MapsFragment.OnFragmentInteractionListener,
        IslandMapFragment.OnFragmentInteractionListener,
        PrisonMapFragment.OnFragmentInteractionListener,
        PatchNotesFragment.OnFragmentInteractionListener{


    private Fragment currentFragment;
    private ArrayList<Perk> allPerks;
    private ArrayList<Airdrop> allAirdrops;


    public void getPerksAndAirdrops(){
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
        Airdrop airdrop14 = new Airdrop("Random Tier 3 Spear", new String[]{"Random T3 Axe Spear"},100,"Mid");
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
        //add all perks to list
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
        //add all airdrops to list
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();
        currentFragment = new AirdropsPerksFragment();
        fragmentManager.beginTransaction().replace(R.id.contentFrame, currentFragment).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        currentFragment = new Fragment();

        if (id == R.id.nav_airdropsperks) {
            currentFragment = new AirdropsPerksFragment();
        } else if (id == R.id.nav_craftingrecipes) {
            currentFragment = new CraftingRecipesFragment();
        } else if (id == R.id.nav_maps) {
            currentFragment = new MapsFragment();
        } else if (id == R.id.nav_guides) {
            currentFragment = new GuidesFragment();
        } else if (id == R.id.nav_patchnotes) {
            currentFragment = new PatchNotesFragment();
        } else if (id == R.id.nav_cullculator) {
            currentFragment = new CullculatorFragment();
        } else if (id == R.id.nav_loadoutrandomizer) {
            currentFragment = new LoadoutRandomizerFragment();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();
        if(currentFragment!=null){
            fragmentManager.beginTransaction().replace(R.id.contentFrame, currentFragment).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
