package com.example.casestudygemplex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.casestudygemplex.activities.DetailActivity;
import com.example.casestudygemplex.fragments.HomeFragment;
import com.example.casestudygemplex.fragments.MessageFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{


    private Toolbar tbHome;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbHome = findViewById(R.id.tbHome);
        tbHome.setTitle(R.string.app_name);

        tabLayout = findViewById(R.id.tabLayout);

        /*tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Original"));
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        */
        viewPager = findViewById(R.id.viewPager);
        setupViewpager(viewPager);
        //set the viewpager in tablayout
        tabLayout.setupWithViewPager(viewPager);



    }

    private void setupViewpager(ViewPager viewPager){
        Adapter adapter = new Adapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new HomeFragment(),"Home");
        adapter.addFragment(new HomeFragment(),"Originals");
        adapter.addFragment(new HomeFragment(),"Movies");

        viewPager.setAdapter(adapter);

    }
    static class Adapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> tabTitle = new ArrayList<>();

        public Adapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
           return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle.get(position);
        }

        //custom method to get fragments and title
        public void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            tabTitle.add(title);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuCart:
                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuSearch:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }

}
