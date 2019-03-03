package com.example.foodforgoodwichacks;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {
    TextView event;
    TextView loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
         event = findViewById(R.id.event);
         loc = findViewById(R.id.location);
        onClickRetrieveStudents();


    }

    public void lookForCaterer(View view){
        Intent intent = new Intent(this, Profile_Common.class);
        startActivity(intent);
    }


    public void onClickRetrieveStudents() {
        // Retrieve student records
        String URL = "content://com.example.foodforgoodwichacks.JobContetentProvider";

        Uri job = Uri.parse(URL);
        Cursor c = managedQuery(job, null, null, null, "_id");

        if (c.moveToFirst()) {
            do{

                event.setText(c.getString(c.getColumnIndex(JobContetentProvider.Event)));
                loc.setText(c.getString(c.getColumnIndex(JobContetentProvider.Location)));

                /*Toast.makeText(this,
                        c.getString(c.getColumnIndex(JobContetentProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( JobContetentProvider.Location)) +
                                ", " + c.getString(c.getColumnIndex( JobContetentProvider.Event)),
                        Toast.LENGTH_SHORT).show();*/

            } while (c.moveToNext());
        }
    }

    public void cancel(View view){
        Intent intent = new Intent(this, Profile_Common.class);
        startActivity(intent);
    }
}


