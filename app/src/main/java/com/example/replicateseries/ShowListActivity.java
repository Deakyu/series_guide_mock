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

public class ShowListActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        Toolbar showlistToolbar = findViewById(R.id.showlist_toolbar);
        showlistToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(showlistToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorPurple)));

        ConstraintLayout wrapper = findViewById(R.id.show_list_wrapper);
        wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowListActivity.this, EpisodeDetailActivity.class);
                startActivity(intent);
            }
        });
    }


}
