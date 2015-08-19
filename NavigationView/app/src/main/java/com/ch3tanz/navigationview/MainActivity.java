package com.ch3tanz.navigationview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private TextView mNavDrawerHeaderUserName, mNavDrawerHeaderUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a mToolbar to replace the action bar.
        initToolbar();
        // Initialize Navigation Drawer
        initNavigationDrawer();
    }

    private void initToolbar() {
        // Set a mToolbar to replace the action bar.
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void initNavigationDrawer() {

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }


        }; // Drawer Toggle Object Made

        // Drawer Listener set to the Drawer toggle
        mDrawer.setDrawerListener(mDrawerToggle);
        // Finally we set the drawer toggle sync State
        mDrawerToggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        // setting the click listener to nav menu item
        mNavigationView.setNavigationItemSelectedListener(this);

        mNavDrawerHeaderUserName = (TextView) findViewById(R.id.name);
        mNavDrawerHeaderUserEmail = (TextView) findViewById(R.id.email);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        int id = menuItem.getItemId();
        menuItem.setChecked(true);
        mDrawer.closeDrawers();

        if (id == R.id.navigation_item_home) {
            Toast.makeText(this,"You click Home!! ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.navigation_item_favourite) {
            Toast.makeText(this,"You click Favourite!! ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.navigation_item_settings) {
            Toast.makeText(this,"You click Settings!! ", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
