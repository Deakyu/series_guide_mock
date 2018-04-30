package com.example.replicateseries;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowListActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        // region Set variables for Show Object
        int id = 1;
        String showName = "Friends";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String strStartDate = "10/02/2003";
        Date dtStartDate = new Date();
        try {
            dtStartDate = format.parse(strStartDate);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        String publisher = "NBC";
        int numTotalEpisodes = 236;
        String dayOfWeek = "Thu";
        String time = "8:00 PM";

        Show show = new Show(id, showName, dtStartDate, publisher, numTotalEpisodes, dayOfWeek, time);
        // endregion

        // region Populate show layout with Show object
        TextView tv = findViewById(R.id.showname_showlist);
        tv.setText(show.getShowName());

        // Date Formatting
        SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
        String formatted = newFormat.format(show.getStartDate());

        tv = findViewById(R.id.episode_date_showlist);
        tv.setText(formatted);

        tv = findViewById(R.id.ramaining_showlist);
        tv.setText(show.getNumTotalEpisode() + " ramaining " + show.getPublisher() + " \u2022 " + show.getDayOfWeek() + " " + show.getTime());
        // endregion

        Toolbar showlistToolbar = findViewById(R.id.showlist_toolbar);
        showlistToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(showlistToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorPurple)));

        ConstraintLayout wrapper = findViewById(R.id.show_list_wrapper);
        wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 1;
                int seasonNumber = 1;
                int numEpisodeWatched = 1;
                int numTotalEpisodes = 18;
                Season season = new Season(id, seasonNumber, numEpisodeWatched, numTotalEpisodes);

                Intent intent = new Intent(ShowListActivity.this, SeasonListActivity.class);
                intent.putExtra("season", season);

                startActivity(intent);
            }
        });
    }


}
