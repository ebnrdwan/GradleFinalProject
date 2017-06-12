package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JavaJoke;
import com.example.android.andjokelib.JokeActivity;
import com.google.android.gms.common.GoogleApiAvailability;


public class MainActivity extends AppCompatActivity {

    public static String IntentExtraTag = "INTAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(MainActivity.this);
        ClintAsync clintAsync = new ClintAsync();

        new ClintAsync().execute(new Pair<Context, String>(this, "i'm the joke hehehe"));


    }

    @Override
    protected void onResume() {
        super.onResume();
        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(MainActivity.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        JavaJoke javaJoke = new JavaJoke();
        Toast.makeText(this, javaJoke.getJoke(), Toast.LENGTH_SHORT).show();
        String joke = javaJoke.getJoke();
        Intent intentJoke = new Intent(this, JokeActivity.class);
        intentJoke.putExtra(IntentExtraTag, joke);
        startActivity(intentJoke);

    }


}
