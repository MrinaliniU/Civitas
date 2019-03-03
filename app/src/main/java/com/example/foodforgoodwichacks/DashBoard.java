package com.example.foodforgoodwichacks;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DashBoard extends AppCompatActivity {
    TextView event;
    TextView loc;
    TextView name;
    TextView price;
    TextView guests;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


      /*  recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();

        for (int i = 0; i < Jobs.nameArray.size(); i++) {
            data.add(new DataModel(
                    Jobs.nameArray.get(i),
                    Jobs.versionArray[i],
                    Jobs.id_[i]
            ));
        }*/


        event = findViewById(R.id.event);
         loc = findViewById(R.id.location);
         name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        guests = findViewById(R.id.guests);
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
                name.setText(c.getString(c.getColumnIndex(JobContetentProvider.NAME)));
                price.setText(c.getString(c.getColumnIndex(JobContetentProvider.price)));
                guests.setText(c.getString(c.getColumnIndex(JobContetentProvider.guests)));

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


