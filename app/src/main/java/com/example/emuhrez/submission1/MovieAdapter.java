package com.example.emuhrez.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MovieModel> movieModel;

    public void setMovieModel(ArrayList<MovieModel> movieModel) {
        this.movieModel = movieModel;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movieModel = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieModel.size();
    }

    @Override
    public Object getItem(int position) {
        return movieModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }

        MovieModel movie =(MovieModel) getItem(position);
        TextView movieName = convertView.findViewById(R.id.movie_name);
        TextView overview = convertView.findViewById(R.id.overview_movie);
        ImageView movieImg = convertView.findViewById(R.id.img_photo);

        movieName.setText(movie.moviesTitle);
        overview.setText(movie.overview);
        movieImg.setImageResource(movie.getImageMovie());

        return convertView;
    }

}
