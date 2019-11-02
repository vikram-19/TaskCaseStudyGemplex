package com.example.casestudygemplex.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.casestudygemplex.R;
import com.example.casestudygemplex.adapters.GenresAdapter;
import com.example.casestudygemplex.adapters.LanguageAdapter;
import com.example.casestudygemplex.adapters.MovieAdapter;
import com.example.casestudygemplex.adapters.SlidePageAdapter;
import com.example.casestudygemplex.fragments.MessageFragment;
import com.example.casestudygemplex.models.Cast;
import com.example.casestudygemplex.models.Genres;
import com.example.casestudygemplex.models.Language;
import com.example.casestudygemplex.models.Movies;
import com.example.casestudygemplex.models.Slide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private ViewPager vpSlidePager;
    private List<Slide> slideList;
    private SlidePageAdapter adapter;

    private TabLayout tabIndicator;

    private RecyclerView rvMovie, rvNonFiction, rvLanguage, rvGenres;
    private MovieAdapter movieAdapter;
    private List<Movies> moviesList;
    private List<Language> languageList;
    private List<Genres> genresList;

    LanguageAdapter languageAdapter;
    GenresAdapter genresAdapter;

    private Toolbar tbHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vpSlidePager = findViewById(R.id.vpSlidePager);
        tabIndicator = findViewById(R.id.tabIndicator);
        rvMovie = findViewById(R.id.rvMovie);
        rvNonFiction = findViewById(R.id.rvNonFiction);
        rvLanguage = findViewById(R.id.rvLanguage);
        rvGenres = findViewById(R.id.rvGenres);
        tbHome = findViewById(R.id.tbHome);

        slideList = new ArrayList<Slide>();
        slideList.add(new Slide(R.drawable.banner1));
        slideList.add(new Slide(R.drawable.banner2));
        slideList.add(new Slide(R.drawable.banner_gurukul));

        adapter = new SlidePageAdapter(this, slideList);
        // set adapter to viewpager
        vpSlidePager.setAdapter(adapter);

        //set indicator with viewpager
        tabIndicator.setupWithViewPager(vpSlidePager, true);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);

        //show Movie List
        getMovieList();
        // non fiction list
        getNonFictionList();
        //lanugage list
        getLanguageList();
        //genresList
        getGenresList();

        //toolbar title
        tbHome.setTitle(R.string.app_name);

    }


    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (vpSlidePager.getCurrentItem() < slideList.size() - 1) {
                        vpSlidePager.setCurrentItem(vpSlidePager.getCurrentItem() + 1);
                    } else {
                        vpSlidePager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void getMovieList() {

        moviesList = new ArrayList<Movies>();
        moviesList.add(new Movies("Bollywood Gurukul", "A funny take on bollywood, where a school full of students posing as current bollywood starts and their teachers are ex-superstars of the hindi film industry. \n\n Director : Vaibhav Bist \n Starring : \n Genres : Comedy \n\n ", R.drawable.front_gurukul, R.drawable.banner_gurukul));
        moviesList.add(new Movies("The Real Land", "Two tyrant brothers Amarpal and Samarpal who have ruled the land on their own terms for more than three decades, cross path with a young boy Ajit Yadav who happens to be the son of their driver, then begins the battle of casteism, power and greed that threatens the throne of the land without law. \n\n Director : Vivek Srivastav \n Starring : \n Genres : Drama Action Thriller \n Language List : Hindi \n Age Limit : 18+ \n\n", R.drawable.front_realdhaba, R.drawable.banner2));

        movieAdapter = new MovieAdapter(HomeActivity.this, moviesList);
        rvMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvMovie.setAdapter(movieAdapter);
    }

    public void getNonFictionList() {
        moviesList = new ArrayList<Movies>();
        moviesList.add(new Movies("Lets go", R.drawable.front_go, R.drawable.banner_gurukul));
        moviesList.add(new Movies("Khane ke Dewane", R.drawable.front_khana_diwane, R.drawable.banner2));
        moviesList.add(new Movies("Niana", R.drawable.front_naina, R.drawable.banner1));
        moviesList.add(new Movies("Zuban", R.drawable.front_zuban, R.drawable.banner_gurukul));

        movieAdapter = new MovieAdapter(HomeActivity.this, moviesList);
        rvNonFiction.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNonFiction.setAdapter(movieAdapter);
    }

    public void getLanguageList() {
        languageList = new ArrayList<Language>();
        languageList.add(new Language("Hindi", R.drawable.language_hindi));
        languageList.add(new Language("Bengali", R.drawable.language_bengali));
        languageList.add(new Language("Malayalam", R.drawable.language_malyalam));
        languageList.add(new Language("Punjabi", R.drawable.language_punjabi));
        languageList.add(new Language("English", R.drawable.language_english));

        languageAdapter = new LanguageAdapter(HomeActivity.this, languageList);
        rvLanguage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvLanguage.setAdapter(languageAdapter);
    }

    public void getGenresList() {
        genresList = new ArrayList<Genres>();
        genresList.add(new Genres("Drama", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Action", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Thriller", R.drawable.custom_camera_icon));
       /* genresList.add(new Genres("Horror", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Comedy", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Adult", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Documentry", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Classic", R.drawable.custom_camera_icon));
        genresList.add(new Genres("Crime", R.drawable.custom_camera_icon));*/

        genresAdapter = new GenresAdapter(HomeActivity.this, genresList);
        rvGenres.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvGenres.setAdapter(genresAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;
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
