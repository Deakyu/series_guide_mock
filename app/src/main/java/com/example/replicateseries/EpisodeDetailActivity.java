package com.example.replicateseries;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EpisodeDetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);

        // Get episode info from EpisodeListActivity
        Bundle data = getIntent().getExtras();
        Episode episode = data.getParcelable("episode");

        System.out.println("EPISODE HERE:\n");
        System.out.println(episode.toString());

        Toolbar episodeDetailToolbar = findViewById(R.id.episode_detail_toolbar);
        episodeDetailToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(episodeDetailToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorPurple)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Friends");

        // region Set TextView values from episode object
        // Set values of texts here
        TextView tv = findViewById(R.id.episode_name);
        tv.setText("Episode " + Integer.toString(episode.getEpisodeNumber()));

        tv = findViewById(R.id.episode_date);
        tv.setText(episode.getEpisodeDate().toString());

        tv = findViewById(R.id.details_string);
        tv.setText(episode.getEpisodeDetail());

        tv = findViewById(R.id.edited_date);
        tv.setText(episode.getLastEdited().toString());

        tv = findViewById(R.id.rating);
        tv.setText(Float.toString(episode.getRating()) + " " + episode.getNumVoters() + " votes");

        tv = findViewById(R.id.guest_stars_detail);
        tv.setText(implode(", ", episode.getGuestStars()));

        tv = findViewById(R.id.directors_detail);
        tv.setText(implode(", ", episode.getDirectors()));

        tv = findViewById(R.id.writers_detail);
        tv.setText(implode(", ", episode.getWriters()));
        // endregion
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.go_to_season:
                int id = 1;
                int seasonNumber = 1;
                int numEpisodeWatched = 1;
                int numTotalEpisodes = 18;
                Season season = new Season(id, seasonNumber, numEpisodeWatched, numTotalEpisodes);

                Intent intent = new Intent(EpisodeDetailActivity.this, SeasonListActivity.class);
                intent.putExtra("season", season);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Needed to create menu items!!
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public String implode(String delimiter, String[] str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<str.length ; i++) {
            sb.append(str[i]);
            if(i != str.length - 1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
}
