package com.example.android.andjokelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent recJoke = getIntent();
        String joke = recJoke.getStringExtra("INTAG");


        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(joke);

    }
}
