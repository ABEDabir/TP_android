package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int min = 1;
    int max = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice3);
        Button rollButton = (Button) findViewById(R.id.button);
        TextView result = (TextView) findViewById(R.id.textView);
        TextView result2 = (TextView) findViewById(R.id.textView2);
        EditText input = (EditText) findViewById(R.id.user_inp) ;
        //Button rollButton2 = (Button) findViewById(R.id.button2);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Exercice2
//                Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT).show();
//                Integer random_int = (int)(Math.random() * ((max - min) + 1)) + min;
//                Integer random_int2 = (int)(Math.random() * ((max - min) + 1)) + min;
//                result.setText(random_int.toString());
//                result2.setText(random_int2.toString());
                //Exercice3
                max = Integer.parseInt(input.getText().toString());
                Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT).show();
                Integer random_int = (int)(Math.random() * ((max - min) + 1)) + min;
                Integer random_int2 = (int)(Math.random() * ((max - min) + 1)) + min;
                result.setText(random_int.toString());
                result2.setText(random_int2.toString());
            }
        });

    }
}