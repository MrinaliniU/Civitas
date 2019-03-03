package com.example.foodforgoodwichacks;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import android.widget.Toast;

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
    EditText description;
    /*
        The actual data
     */

    String _name,_guests,_loc,_date,_price,_dec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_catering);

        submit = findViewById(R.id.submit);
        price = findViewById(R.id.payment);
        date = findViewById(R.id.date);
        location = findViewById(R.id.Location);
        numOfGuests = findViewById(R.id.numOfGuests);
        name = findViewById(R.id.organizer);
        eventType = findViewById(R.id.eventType);
        description = findViewById(R.id.description);

        final Intent intent = new Intent(this, DashBoard.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerdata = eventType.getSelectedItem().toString();
                Log.i("tag","Submit Clicked");
                _price = price.getText().toString();
                _date = date.getText().toString();
                _loc = location.getText().toString();
                _guests = numOfGuests.getText().toString();
                _name = name.getText().toString();
                _dec = description.getText().toString();
                price.setText("");
                date.setText("");
                location.setText("");
                numOfGuests.setText("");
                name.setText("");
                description.setText("");
                startActivity(intent);
                //new MyTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
                ContentValues values = new ContentValues();
                //values.put(JobContetentProvider.NAME, _name);
                values.put(JobContetentProvider.Location, _loc);
                values.put(JobContetentProvider.Event, spinnerdata);
                Uri uri = getContentResolver().insert(
                        JobContetentProvider.CONTENT_URI, values);
                /*Toast.makeText(getBaseContext(),
                        uri.toString(), Toast.LENGTH_LONG).show();*/
            }
        });
    }

    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.foodforgoodwichacks.JobContetentProvider";

        Uri job = Uri.parse(URL);
        Cursor c = managedQuery(job, null, null, null, "event");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(JobContetentProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( JobContetentProvider.Location)) +
                                ", " + c.getString(c.getColumnIndex( JobContetentProvider.Event)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }

    public void cancel(View view){
        Intent intent = new Intent(this, Profile_Common.class);
        startActivity(intent);
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

