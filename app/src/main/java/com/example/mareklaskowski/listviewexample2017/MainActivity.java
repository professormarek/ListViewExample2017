package com.example.mareklaskowski.listviewexample2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare an array to provide data through the array adaptor to our ListView
        String[] data = new String[] {"beard", "iPhone", "giraffe"};
        /*
        create an ArrayAdapter for an array of Strings
        the constructor for ArrayAdapter requires a "sample list item" layout
        make sure you have one created in res/layout
        (Context, sample_layout_id, array)
         */
        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(this, R.layout.list_item, data);

        //get a reference to the ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        //set the adapter for listView to use our ArrayAdpter "sAdpater"
        listView.setAdapter(sAdapter);

    }
}
