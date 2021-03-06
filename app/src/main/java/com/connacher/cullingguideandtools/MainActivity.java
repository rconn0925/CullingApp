package com.connacher.cullingguideandtools;

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

import com.connacher.cullingguideandtools.models.Airdrop;
import com.connacher.cullingguideandtools.models.Perk;

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
        PatchNotesFragment.OnFragmentInteractionListener,
        AirdropsFragment.OnFragmentInteractionListener,
        PerksFragment.OnFragmentInteractionListener,
        TwitchFragment.OnFragmentInteractionListener
{


    private Fragment currentFragment;
    private ArrayList<Perk> allPerks;
    private ArrayList<Airdrop> allAirdrops;



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
        }

        /*else if (id == R.id.nav_craftingrecipes) {
            currentFragment = new CraftingRecipesFragment();
        }*/
          else if (id == R.id.nav_maps) {
            currentFragment = new MapsFragment();
        } else if (id == R.id.nav_guides) {
            currentFragment = new GuidesFragment();
        } else if (id == R.id.nav_patchnotes) {
            currentFragment = new PatchNotesFragment();
        } else if (id == R.id.nav_cullculator) {
            currentFragment = new CullculatorFragment();
        } else if (id == R.id.nav_loadoutrandomizer) {
            currentFragment = new LoadoutRandomizerFragment();
        } else if (id == R.id.nav_twitch) {
            currentFragment = new TwitchFragment();
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
