package com.example.emuhrez.submission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.emuhrez.submission1.DetailMovieActivity.DETAIL_MOVIE;

public class MainActivity extends AppCompatActivity {

    String[] moviesTitle;
    String[] moviesRelease;
    String[] moviesVote;
    String[] moviesOverview;
    TypedArray moviesImage;

    ArrayList<MovieModel> moviesModel = new ArrayList<>();

    MovieAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, moviesModel.get(position).moviesTitle, Toast.LENGTH_SHORT).show();
                Intent movieDetail = new Intent(MainActivity.this, DetailMovieActivity.class);
                movieDetail.putExtra(DETAIL_MOVIE, moviesModel.get(position));
                startActivity(movieDetail);
            }
        });
    }

    private void prepare() {
        moviesTitle = getResources().getStringArray(R.array.movie_name);
        moviesRelease = getResources().getStringArray(R.array.release_date);
        moviesVote = getResources().getStringArray(R.array.vote_average);
        moviesOverview = getResources().getStringArray(R.array.overview);
        moviesImage = getResources().obtainTypedArray(R.array.movie_photo);
    }

    private void addItem() {

        for (int i = 0; i < moviesTitle.length; i++) {
            MovieModel movieModel = new MovieModel();
            movieModel.setMoviesTitle(moviesTitle[i]);
            movieModel.setReleaseDate(moviesRelease[i]);
            movieModel.setVote_average(Double.valueOf(moviesVote[i]));
            movieModel.setOverview(moviesOverview[i]);
            movieModel.setImageMovie(moviesImage.getResourceId(i, -1));
            moviesModel.add(movieModel);
        }

        adapter.setMovieModel(moviesModel);
    }
}
