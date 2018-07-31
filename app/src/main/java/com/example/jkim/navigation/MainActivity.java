package com.example.jkim.navigation;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;



// If you want to change the layout of the first loaded navigation view
// you need to edit the content_main.xml file.
// That file has the constraint layout and the default text view

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fragment_container, new WelcomeFragment())
                        .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        // create a null fragment that we will assign an object to
        // in the if statements below (import the support fragment)
        Fragment fragment = null;

        // the ids here match what is in the menu xml file that you edited
        // so since we got rid of the camera and other items, those
        // will give errors below if you don't delete the R.id.camera, etc
        if (id == R.id.menu_main_pythag) {
            // load a fragment to switch from the main screen
            // to the specific pythagorean theorem screen
            fragment = new PythagFragment();

            // this is the line above that will get student errors if they
            // imported the wrong fragment version
        } else if (id==R.id.menu_main_circle)
        {
            fragment = new CircleFragment();
        }

        // replace the current fragment with the one we just assigned
        // as long as it isn't null

        // when replacing the fragment, the target container is the
        // constraint layout from content_main.xml. You need to give
        // that layout an id
        FragmentManager fm = getSupportFragmentManager();
        if(fragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}