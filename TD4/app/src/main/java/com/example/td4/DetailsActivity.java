package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
        Intent intent = new Intent(DetailsActivity.this, NewsActivity.class);
        startActivity(intent);

    }
}