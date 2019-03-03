package com.example.foodforgoodwichacks;

import android.content.Intent;
import android.graphics.PostProcessor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile_Common extends AppCompatActivity {
    Button lookForCater;
    Button lookForJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__common);
        lookForCater = (Button) findViewById(R.id.lookForCaterers);
        lookForJob = findViewById(R.id.toCater);

    }

    public void lookForCaterer(View view){
        Intent intent = new Intent(this, PostCatering.class);
        startActivity(intent);
    }
}
