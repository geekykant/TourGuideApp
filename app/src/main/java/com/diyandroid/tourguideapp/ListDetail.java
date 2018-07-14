package com.diyandroid.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.detailsToolbar);
        setSupportActionBar(toolbar);

        //Setting toolbar title to Clicked title
        getSupportActionBar().setTitle(getIntent().getStringExtra("TOOLBAR_TITLE"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Like Hotels, Tourist Spot..
        int desc_id = getIntent().getIntExtra("TAB_DESC_ID", -1);
        int image = getIntent().getIntExtra("IMAGE", -1);

        ((TextView) findViewById(R.id.detailsDescription)).setText(getResources().getString(desc_id));
        ((ImageView) findViewById(R.id.detailsImage)).setImageResource(image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity
        }
        return super.onOptionsItemSelected(item);
    }
}
