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
import android.widget.ProgressBar;
import android.widget.TextView;

public class SeasonListActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_list);

        Bundle data = getIntent().getExtras();
        int id = 1;
        int seasonNumber = 1;
        int numEpisodeWatched = 1;
        int numTotalEpisodes = 18;
        Season season = new Season(id, seasonNumber, numEpisodeWatched, numTotalEpisodes);
        if(data != null) {
            if(data.getParcelable("season") != null) {
                season = data.getParcelable("season");
            }
        }

        Toolbar seasonlistToolbar = findViewById(R.id.seasonlist_toolbar);
        seasonlistToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(seasonlistToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorPurple)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Friends");

        ConstraintLayout wrapper = findViewById(R.id.season_list_wrapper);
        wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeasonListActivity.this, EpisodeListActivity.class);
                startActivity(intent);
            }
        });

        // region Populate season layout with Season
        TextView tv = findViewById(R.id.season_name);
        tv.setText("Season " + Integer.toString(season.getSeasonNumeber()));

        tv = findViewById(R.id.season_progress_text);
        tv.setText(Integer.toString(season.getNumEpisodeWatched()) + "/" + Integer.toString(season.getNumTotalEpisodes()));

        tv = findViewById(R.id.season_remaining);
        tv.setText(Integer.toString(season.getNumTotalEpisodes()-season.getNumEpisodeWatched()) + " remaining");

        ProgressBar pb = findViewById(R.id.season_progressbar);
        pb.setProgress(season.getNumEpisodeWatched()*100/season.getNumTotalEpisodes());
        // endregion
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
