package com.example.ahmshere.driverinstructor;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ahmshere.driverinstructor.adapter.TabFragmentAdapter;
import com.example.ahmshere.driverinstructor.fragments.FragmentOne;

public class MainActivity extends AppCompatActivity {
    private static final int MAIN_LAYOUT = R.layout.activity_main;
    private Toolbar toolBar;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppMain);
        super.onCreate(savedInstanceState);
        setContentView(MAIN_LAYOUT);


        initTabs();
        initToolbar();
        initNavigationView();
    }
//ukazivaem layoutu viewpager. svyaz mezdu nimi
    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabFragmentAdapter adapter =new TabFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout)findViewById(R.id.tab_layour);
        tabLayout.setupWithViewPager(viewPager);
//viewPager.setOnClickListener();
    }

    private void initToolbar() {
        toolBar = (Toolbar)findViewById(R.id.toolbar);
        toolBar.setTitle(R.string.app_name);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolBar.inflateMenu(R.menu.menu);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_lay);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           //pishem deistviya na bokovom menu i listeners
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.item_ts:
                        showVechicleTab();
                        break;
                    case R.id.item_about:
                        showAboutInstructorTab();
                        break;
                    case R.id.item_reviews:
                        showReviewTab();
                        break;
                }
                return true;
            }
        });
    }
    //metod pokaza taba
    private void showVechicleTab(){
        viewPager.setCurrentItem(Constants.TAB_ONE);
    }

    private void showAboutInstructorTab(){
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }
    private void showReviewTab(){
        viewPager.setCurrentItem(Constants.TAB_THREE);
    }
}
