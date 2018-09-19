package com.madsoftware.commvoy.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.madsoftware.commvoy.MainActivity;
import com.madsoftware.commvoy.R;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton profileBackButton;
    private ImageButton profileMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileBackButton = (ImageButton) findViewById(R.id.profile_back_arrow);
        profileMenuButton = (ImageButton) findViewById(R.id.profile_menu_button);

        profileBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to home.
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        profileMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add drop down menu
            }
        });
    }
}
