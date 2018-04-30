package com.example.replicateseries;

import android.os.Parcel;
import android.os.Parcelable;

public class Season implements Parcelable {

    private int id;
    private int seasonNumeber;
    private int numEpisodeWatched;
    private int numTotalEpisodes;

    public Season(int id, int seasonNumeber, int numEpisodeWatched, int numTotalEpisodes) {
        this.id = id;
        this.seasonNumeber = seasonNumeber;
        this.numEpisodeWatched = numEpisodeWatched;
        this.numTotalEpisodes = numTotalEpisodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumEpisodeWatched() {
        return numEpisodeWatched;
    }

    public void setNumEpisodeWatched(int numEpisodeWatched) {
        this.numEpisodeWatched = numEpisodeWatched;
    }

    public int getSeasonNumeber() {
        return seasonNumeber;
    }

    public void setSeasonNumeber(int seasonNumeber) {
        this.seasonNumeber = seasonNumeber;
    }

    public int getNumTotalEpisodes() {
        return numTotalEpisodes;
    }

    public void setNumTotalEpisodes(int numTotalEpisodes) {
        this.numTotalEpisodes = numTotalEpisodes;
    }

    protected Season(Parcel in) {
        this.id = in.readInt();
        this.seasonNumeber = in.readInt();
        this.numEpisodeWatched = in.readInt();
        this.numTotalEpisodes = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.seasonNumeber);
        dest.writeInt(this.numEpisodeWatched);
        dest.writeInt(this.numTotalEpisodes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Season> CREATOR = new Creator<Season>() {
        @Override
        public Season createFromParcel(Parcel in) {
            return new Season(in);
        }

        @Override
        public Season[] newArray(int size) {
            return new Season[size];
        }
    };

    @Override
    public String toString() {
        return "Season{\n" +
                "id : " + this.id + "\n" +
                "seasonNumeber : " + this.seasonNumeber + "\n" +
                "numEpisodeWatched : " + this.numEpisodeWatched + "\n" +
                "numTotalEpisodes : " + this.numTotalEpisodes + "\n}";
    }
}
