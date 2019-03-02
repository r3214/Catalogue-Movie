package com.example.emuhrez.submission1;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String DETAIL_MOVIE = "detail_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        TextView movieTitle = findViewById(R.id.movie_title);
        TextView movieDate = findViewById(R.id.release_date);
        TextView movieVote = findViewById(R.id.vote_movies);
        TextView movieOverview = findViewById(R.id.overview_movie);
        ImageView moviePoster = findViewById(R.id.poster_movie);

        MovieModel movieDetail = getIntent().getParcelableExtra(DETAIL_MOVIE);

        movieTitle.setText(movieDetail.moviesTitle);
        movieDate.setText(movieDetail.releaseDate);
        movieOverview.setText(movieDetail.overview);
        movieVote.setText(String.valueOf(movieDetail.vote_average));
        moviePoster.setImageResource(movieDetail.getImageMovie());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
