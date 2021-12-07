package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureButton();
    }
    private void configureButton(){
        Button search = (Button) findViewById(R.id.search);
        EditText searchField = (EditText) findViewById(R.id.SearchField);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!searchField.getText().toString().isEmpty())
                {
                    Intent intent = new Intent(MainActivity.this,RepoSearch.class);
                    intent.putExtra("repository",searchField.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Insert repo name please", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}