package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getApplicationContext();
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());
        Button details_btn = (Button) findViewById(R.id.details_btn);
        Button libelle_btn = (Button) findViewById(R.id.libelle_btn);
        Button log_out = (Button) findViewById(R.id.logout_btn);

        TextView txt_username = (TextView) findViewById(R.id.user);
        Intent intent = getIntent();
        txt_username.setText(intent.getStringExtra("username"));


        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, DetailsActivity.class);
                String login;
                if (intent.hasExtra("login")) {
                    login = intent.getStringExtra("login");
                }

                startActivity(intent);
            }
        });

        libelle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
        Intent intent = new Intent(NewsActivity.this, LoginActivity.class);
        startActivity(intent);

    }


}