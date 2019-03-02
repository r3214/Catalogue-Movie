package com.example.emuhrez.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    String moviesTitle;
    String releaseDate;
    String overview;
    Integer imageMovie;
    Double vote_average;

    public String getMoviesTitle() {
        return moviesTitle;
    }

    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getImageMovie() {
        return imageMovie;
    }

    public void setImageMovie(Integer imageMovie) {
        this.imageMovie = imageMovie;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.moviesTitle);
        dest.writeString(this.releaseDate);
        dest.writeString(this.overview);
        dest.writeValue(this.imageMovie);
        dest.writeValue(this.vote_average);
    }

    public MovieModel() {
    }

    protected MovieModel(Parcel in) {
        this.moviesTitle = in.readString();
        this.releaseDate = in.readString();
        this.overview = in.readString();
        this.imageMovie = (Integer) in.readValue(Integer.class.getClassLoader());
        this.vote_average = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<MovieModel> CREATOR = new Parcelable.Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
