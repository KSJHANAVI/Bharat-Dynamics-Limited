package com.kjhan.bharathdynamicslimited;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,LoginFragment.OnLoginVerificationListener,ProfileFragment.OnLogoutVerificationListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer =findViewById(R.id.drawer_layout);

        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AboutFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_about);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new LoginFragment()).commit();

        } else if (id == R.id.nav_wp) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WPFragment()).commit();

        } else if (id == R.id.nav_contactus) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ContactFragment()).commit();
        } else if (id == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AboutFragment()).commit();

        } else if (id == R.id.nav_directors) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DirectorsFragment()).commit();

        } else if (id == R.id.nav_investors) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new InvestorsFragment()).commit();

        }
        else if (id == R.id.nav_products) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProductsFragment()).commit();

        }
        else if (id == R.id.nav_rtiact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new RtiFragment()).commit();

        }
        else if (id == R.id.nav_suppliers) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SuppliersFragment()).commit();

        }
        else if (id == R.id.nav_careers) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CareersFragment()).commit();

        }
        else if (id == R.id.nav_exports) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ExportsFragment()).commit();

        }


        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
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


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoginVerify() {

            ProfileFragment profileFragment = new ProfileFragment();
            LoginFragment loginFragment=new LoginFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, profileFragment, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


       }

    @Override

    public void onLogoutVerify()
    {
        //AboutFragment aboutFragment=new AboutFragment();
        LoginFragment loginFragment=new LoginFragment();
        Bundle bundle=new Bundle();
        String logoutmessage="You have logged out successfully";
        Toast.makeText(this,logoutmessage,Toast.LENGTH_LONG).show();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,loginFragment,null);
        fragmentTransaction.commit();

    }
}
