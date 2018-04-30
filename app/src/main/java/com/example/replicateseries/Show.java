package com.example.replicateseries;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Show implements Parcelable {

    private int id;
    private String showName;
    private Date startDate;
    private String publisher;
    private int numTotalEpisode;
    private String dayOfWeek;
    private String time;

    public Show(int id, String showName, Date startDate, String publisher, int numTotalEpisode, String dayOfWeek, String time) {
        this.id = id;
        this.showName = showName;
        this.startDate = startDate;
        this.publisher = publisher;
        this.numTotalEpisode = numTotalEpisode;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumTotalEpisode() {
        return numTotalEpisode;
    }

    public void setNumTotalEpisode(int numTotalEpisode) {
        this.numTotalEpisode = numTotalEpisode;
    }

    protected Show(Parcel in) {
        this.id = in.readInt();
        this.showName = in.readString();
        this.startDate = new Date(in.readLong());
        this.publisher = in.readString();
        this.numTotalEpisode = in.readInt();
        this.dayOfWeek = in.readString();
        this.time = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.showName);
        dest.writeLong(this.startDate.getTime());
        dest.writeString(this.publisher);
        dest.writeInt(this.numTotalEpisode);
        dest.writeString(this.dayOfWeek);
        dest.writeString(this.time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Show> CREATOR = new Creator<Show>() {
        @Override
        public Show createFromParcel(Parcel in) {
            return new Show(in);
        }

        @Override
        public Show[] newArray(int size) {
            return new Show[size];
        }
    };
}
