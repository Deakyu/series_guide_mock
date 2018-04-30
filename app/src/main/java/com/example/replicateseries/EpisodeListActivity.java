package com.example.replicateseries;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EpisodeListActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_list);

        Toolbar episodeListToolbar = findViewById(R.id.episodelist_toolbar);
        episodeListToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(episodeListToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorPurple)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Friends");

        ConstraintLayout episodeListWrapper = findViewById(R.id.episode_list_wrapper);
        episodeListWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // region variables
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                String strEpisodeDate = "09/25/2003 00:00:00";
                String strLastEdited = "06/06/2015 18:08:00";
                Date dtEpisodeDate = new Date();
                Date dtLastEdited = new Date();
                String episodeDetail = "Monica, Chandler and Phoebe discover that they can eavesdrop on Ross & Charlie and Joey" +
                        " & Rachel through the wall of the hotel. Both new couples decide to wait before proceeding" +
                        " with their relationships, until the men can talk to each other. Ross tells Joey on the plane ride" +
                        " back to New York, but Joey can't quite yet. Later, Ross walks in on Joey and Rachel kissing." +
                        " Meanwhile, Monica combats her poofy hair by getting corn rows put in, and Phoebe discovers that Mike has a girlfriend";
                String[] guestStars = {"Cali and Noel Sheldon", "Paul Rudd", "Aisha Tyler", "Anne Dudek"};
                int numVoters = 1072;
                String[] directors = {"Kevin S. Bright"};
                String[] writers = {"Andrew Reich", "Ted Cohen"};

                try {
                    dtEpisodeDate = format.parse(strEpisodeDate);
                    dtLastEdited = format.parse(strLastEdited);
                } catch(ParseException e) {
                    e.printStackTrace();
                }
                // endregion
                Episode episode = new Episode(1, 2, dtEpisodeDate, episodeDetail,
                        true, 7.9f, guestStars, numVoters, directors, writers,
                        dtLastEdited);

                Intent intent = new Intent(EpisodeListActivity.this, EpisodeDetailActivity.class);
                intent.putExtra("episode", episode);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
