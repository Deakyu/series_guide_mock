package com.example.replicateseries;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class SeasonListActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_list);

        Toolbar seasonlistToolbar = findViewById(R.id.seasonlist_toolbar);
        seasonlistToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(seasonlistToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorPurple)));
        ab.setDisplayHomeAsUpEnabled(true);

        // TODO: Use the below line to dynamically set the title of the show
        // ab.setTitle("Your Title here");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
