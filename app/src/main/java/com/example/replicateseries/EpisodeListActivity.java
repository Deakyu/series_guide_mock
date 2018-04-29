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

        ConstraintLayout episodeListWrapper = findViewById(R.id.episode_list_wrapper);
        episodeListWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EpisodeListActivity.this, EpisodeDetailActivity.class);
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
