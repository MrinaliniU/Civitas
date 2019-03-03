package com.example.foodforgoodwichacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void lookForCaterer(View view){
        Intent intent = new Intent(this, Profile_Common.class);
        startActivity(intent);
    }
}
