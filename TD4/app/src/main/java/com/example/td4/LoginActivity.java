package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewsListApplication app = (NewsListApplication) getApplicationContext();

        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        Button login = (Button) findViewById(R.id.login_btn);
        EditText username = (EditText) findViewById(R.id.name);
        EditText password = (EditText) findViewById(R.id.password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("test") && password.getText().toString().equals("test")) {
                    Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                    intent.putExtra("username", username.getText().toString());
                    app.setLogin(username.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
