package com.example.casestudygemplex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.casestudygemplex.R;
import com.example.casestudygemplex.adapters.CastAdapter;
import com.example.casestudygemplex.adapters.CrewAdapter;
import com.example.casestudygemplex.adapters.RecommendedMovieAdapter;
import com.example.casestudygemplex.models.Cast;
import com.example.casestudygemplex.models.Crew;
import com.example.casestudygemplex.models.Movies;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private Toolbar tbDetail;
    private ImageButton imgBtnFavourite;

    private ImageView ivBanner;
    private TextView tvTitle, tvDescription;

    private RecyclerView rvCast;
    private CastAdapter castAdapter;
    private List<Cast> castList;

    private RecyclerView rvCrew;
    private CrewAdapter crewAdapter;
    private List<Crew> crewList;

    private RecyclerView rvRecommended;
    private RecommendedMovieAdapter recommendedAdapter;
    private List<Movies> moviesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        ivBanner = findViewById(R.id.ivBanner);
        tvDescription = findViewById(R.id.tvDescription);
        //spSeason = findViewById(R.id.spSeason);

        imgBtnFavourite = findViewById(R.id.imgBtnFavourite);
        rvCast = findViewById(R.id.rvCast);
        rvCrew = findViewById(R.id.rvCrew);
        rvRecommended = findViewById(R.id.rvRecommended);


        tbDetail = findViewById(R.id.tbDetail);
        tbDetail.setTitle("Series");
        tbDetail.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        tbDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //get onclick data by intent
        Intent intent = getIntent();
        String movieTitle = intent.getStringExtra("movieTitle");
        int movieBanner = intent.getIntExtra("movieBanner",0);
        String movieDescription = intent.getStringExtra("movieDesc");

        Glide.with(this).load(movieBanner).into(ivBanner);
        tvTitle.setText(movieTitle);
        tvDescription.setText(movieDescription);

       //get CastList
        getCastData();

        //get CrewList
        getCrewData();

        //get Reommended Movies
        getRecommendMovies();


    }

    public void getCastData() {
        castList = new ArrayList<Cast>();
        castList.add(new Cast(R.drawable.cast_icon, "Cast"));

        castAdapter = new CastAdapter(this, castList);
        rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvCast.setAdapter(castAdapter);

    }

    public void getCrewData() {
        crewList = new ArrayList<Crew>();
        crewList.add(new Crew(R.drawable.crew_vaibhav, "Vaibhav Bist"));
        crewList.add(new Crew(R.drawable.crew_suresh, "Suresh"));
        crewList.add(new Crew(R.drawable.crew_avishek, "Avishek"));
        crewList.add(new Crew(R.drawable.crew_vishal, "Vishal"));

        crewAdapter = new CrewAdapter(this, crewList);
        rvCrew.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvCrew.setAdapter(crewAdapter);
    }

    public void getRecommendMovies() {
        moviesList = new ArrayList<Movies>();
        moviesList.add(new Movies("Bollywood Gurukul", R.drawable.banner_gurukul,R.drawable.banner_gurukul));

        recommendedAdapter = new RecommendedMovieAdapter(this, moviesList);
        rvRecommended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvRecommended.setAdapter(recommendedAdapter);

    }
}
