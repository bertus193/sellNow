package com.sellnow;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Fragment;
import android.app.FragmentTransaction;

import com.sellnow.controller.UserSessionManager;
import com.sellnow.model.SellNow;
import com.sellnow.view.FragmentAddAuction;
import com.sellnow.view.FragmentCategories;
import com.sellnow.view.FragmentLogin;
import com.sellnow.view.FragmentMain;
import com.sellnow.view.FragmentProfile;
import com.sellnow.view.FragmentRegister;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    UserSessionManager session;

    private static final int nav_home       = 1;
    private static final int nav_categories = 2;
    private static final int nav_profile    = 3;
    private static final int nav_addAuction = 4;
    private static final int nav_login      = 5;
    private static final int nav_register   = 6;

    public SellNow sellNowContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new UserSessionManager(getApplicationContext());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Calling SellNow class (see application tag in AndroidManifest.xml)
        this.sellNowContext = (SellNow) getApplicationContext();

        //Menu
        DrawerLayout drawerMenu = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerMenu, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerMenu.setDrawerListener(toggle);
        toggle.syncState();

        this.createNavigationMenu();

        Fragment fragment = new FragmentMain(); // create a fragement object
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
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

    /**
     * Use if your menu is static (i.e. unchanging)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    public void createNavigationMenu() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Menu navigationMenu = navigationView.getMenu();
        navigationMenu.clear();

        navigationMenu.add(R.id.groupNavigation, nav_home, Menu.NONE, "Inicio").setIcon(R.drawable.ic_menu_home);
        navigationMenu.add(R.id.groupNavigation, nav_categories, Menu.NONE, "Categorias").setIcon(R.drawable.ic_menu_categories);

        if(session.isUserLoggedIn()){
            navigationMenu.add(R.id.groupNavigation, nav_profile, Menu.NONE, "Mi Perfil").setIcon(R.drawable.ic_menu_profile);
            navigationMenu.add(R.id.groupNavigation, nav_addAuction, Menu.NONE, "Nueva Subasta").setIcon(R.drawable.ic_menu_addauction);
        }
        else {
            navigationMenu.add(R.id.groupNavigation, nav_login, Menu.NONE, "Login").setIcon(R.drawable.ic_menu_login);
            navigationMenu.add(R.id.groupNavigation, nav_register, Menu.NONE, "Registro").setIcon(R.drawable.ic_menu_register);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.button_login) {
            Fragment fragment = null;
            if(session.isUserLoggedIn()){
                fragment = new FragmentProfile();
            }
            else{
                fragment = new FragmentLogin();
            }

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;//declaring fragment object
        if (id == nav_home) {
            fragment = new FragmentMain() ;
        }
        else if (id == nav_categories) {
            fragment = new FragmentCategories() ;
        }
        else if (id == nav_profile) {
            fragment = new FragmentProfile(); //initializing fragment object
        }
        else if (id == nav_addAuction) {
            fragment = new FragmentAddAuction() ;
        }
        else if (id == nav_login) {
            fragment = new FragmentLogin() ;
        }
        else if (id == nav_register) {
            fragment = new FragmentRegister() ;
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();

        DrawerLayout drawerMenu = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerMenu.closeDrawer(GravityCompat.START);
        return true;
    }
}
