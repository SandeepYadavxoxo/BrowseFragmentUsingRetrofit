package com.example.BrowseFragmentUsingRetrofit;

import androidx.fragment.app.FragmentActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showOnLoadPage();
        }

    public void showOnLoadPage(){
        findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
    }
    public void hideOnLoadPage() {
        findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);
    }

    public void setMovieName(String title) {

        TextView movieName= findViewById(R.id.movie_name);
        movieName.setText(title);


    }
    public void setMovieRuntime(String n){
        TextView movieTime=(TextView) findViewById(R.id.movie_time);
        if(n !=null){
            movieTime.setText(n);
        }
        else {
            movieTime.setText("N/A");
        }
    }

    public void setMoviePoster(String background) {
        ImageView moviePoster=(ImageView) findViewById(R.id.movie_poster);
        Glide.with(this)
                .load(Uri.parse(background))
                .into(moviePoster);
    }

    public void setYearOfProduction(String year) {
        String yearOfProduction=year+"";
        TextView prodYear=findViewById(R.id.yearOfProduction);
        prodYear.setText(yearOfProduction);
    }

    public void setMovieDescription(String description) {
        TextView movieDescription= findViewById(R.id.movie_desrciption);
        movieDescription.setText(description);
        hideOnLoadPage();
    }

    }
