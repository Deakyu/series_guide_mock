package com.example.replicateseries;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Episode implements Parcelable {

    private int id;
    private int episodeNumber;
    private Date episodeDate;
    private String episodeDetail;
    private boolean watched;
    private float rating;
    private String[] guestStars;
    private int numVoters;
    private String[] directors;
    private String[] writers;
    private Date lastEdited;

    public Episode(int id, int episodeNumber, Date episodeDate, String episodeDetail, boolean watched, float rating, String[] guestStars, int numVoters, String[] directors, String[] writers, Date lastEdited) {
        this.id = id;
        this.episodeNumber = episodeNumber;
        this.episodeDate = episodeDate;
        this.episodeDetail = episodeDetail;
        this.watched = watched;
        this.rating = rating;
        this.guestStars = guestStars;
        this.numVoters = numVoters;
        this.directors = directors;
        this.writers = writers;
        this.lastEdited = lastEdited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Date getEpisodeDate() {
        return episodeDate;
    }

    public void setEpisodeDate(Date episodeDate) {
        this.episodeDate = episodeDate;
    }

    public String getEpisodeDetail() {
        return episodeDetail;
    }

    public void setEpisodeDetail(String episodeDetail) {
        this.episodeDetail = episodeDetail;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String[] getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(String[] guestStars) {
        this.guestStars = guestStars;
    }

    public int getNumVoters() {
        return numVoters;
    }

    public void setNumVoters(int numVoters) {
        this.numVoters = numVoters;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }


    public Episode(Parcel in) {
        this.id = in.readInt();
        this.episodeNumber = in.readInt();
        this.episodeDate = new Date(in.readLong());
        this.episodeDetail = in.readString();
        this.watched = in.readByte() != 0;
        this.rating = in.readFloat();
        this.guestStars = in.createStringArray();
        this.numVoters = in.readInt();
        this.directors = in.createStringArray();
        this.writers = in.createStringArray();
        this.lastEdited = new Date(in.readLong());

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(this.id);
        dest.writeInt(this.episodeNumber);
        dest.writeLong(this.episodeDate.getTime());
        dest.writeString(this.episodeDetail);
        dest.writeByte((byte) (this.watched ? 1 : 0));
        dest.writeFloat(this.rating);
        dest.writeStringArray(this.guestStars);
        dest.writeInt(this.numVoters);
        dest.writeStringArray(this.directors);
        dest.writeStringArray(this.writers);
        dest.writeLong(this.lastEdited.getTime());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Episode createFromParcel(Parcel in) {
            return new Episode(in);
        }

        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };

    @Override
    public String toString() {
        return "Episode{\n" +
                "id = " + id + "\n" +
                "Episode Number = " + episodeNumber + "\n" +
                "Episode Date = " + episodeDate.toString() + "\n" +
                "Episode Detail = " + episodeDetail + "\n" +
                "Watched? = " + (watched ? "Watched" : "Not Watched") + "\n" +
                "Rating = " + rating + "\n" +
                "guestStars = " + guestStars.toString() + "\n" +
                "Voters = " + numVoters + "\n" +
                "Directors = " + directors.toString() + "\n" +
                "Writers = " + writers.toString() + "\n" +
                "Last Edited = " + lastEdited.toString() + "\n}";

    }
}
