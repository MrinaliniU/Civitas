package com.example.foodforgoodwichacks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PostCatering extends AppCompatActivity {
    Button submit;
    TextView name;
    EditText numOfGuests;
    EditText location;
    EditText date;
    EditText price;
    Spinner eventType;
    String spinnerdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_catering);

        submit = findViewById(R.id.submit);
        price = findViewById(R.id.payment);
        date = findViewById(R.id.date);
        location = findViewById(R.id.Location);
        numOfGuests = findViewById(R.id.numOfGuests);
        name = findViewById(R.id.name);
        eventType = findViewById(R.id.eventType);
        spinnerdata = eventType.getSelectedItem().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","Submit Clicked");
                new MyTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
            }
        });
    }


    private class MyTask extends AsyncTask<Context, Integer, Long>{
        @Override
        protected Long doInBackground(Context... contexts) {

            Connection connection;
            String query = "INSERT into jobsPosted values(" + name.getText().toString() + "," + spinnerdata + "," +
                    Integer.parseInt(numOfGuests.getText().toString()) + "," + date.getText().toString() + "," + price.getText().toString() + "," + location.getText().toString()+ ")";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://35.225.136.23/foodforgood", "mkheraja", "root");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                Log.i("The resul", resultSet.toString());
            }catch (SQLException e) {

            }catch (ClassNotFoundException e){
                e.printStackTrace();

            }
            return null;
        }
    }


}

