package com.example.civitas;


import java.util.List;

public class Jobs {

    static List<String> nameArray ;
    static String[] versionArray = {"1.5", "1.6", "2.0-2.1", "2.2-2.2.3", "2.3-2.3.7", "3.0-3.2.6", "4.0-4.0.4", "4.1-4.3.1", "4.4-4.4.4", "5.0-5.1.1","6.0-6.0.1"};

    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

/*    public void onClickRetrieveStudents() {
        // Retrieve student records
        String URL = "content://com.example.foodforgoodwichacks.JobContetentProvider";

        Uri job = Uri.parse(URL);
        Cursor c = managedQuery(job, null, null, null, "_id");

        if (c.moveToFirst()) {
            do{

                nameArray.add(c.getString(c.getColumnIndex(JobContetentProvider.Event)));

            } while (c.moveToNext());
        }
    }*/


}
