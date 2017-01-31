package com.example.mareklaskowski.listviewexample2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    create an OnItemClickListener object and override its onItemClick method
    (this is much like the anonymous class pattern shown earlier with buttons)
     */
    private AdapterView.OnItemClickListener myMessageClickHandler = new AdapterView.OnItemClickListener() {
        @Override
        /*
        parent is the ListView
        view is a way to get the context
        position is the item that was clicked
        the android:id of the item that was clicked (?) - look me up in the api
         */
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //get data from the view that was clicked
            String info = parent.getItemAtPosition(position).toString();
            //all we'll do here is show a toast, but you can imagine other things as well
            Toast.makeText(view.getContext(), info, Toast.LENGTH_LONG).show();
        }
    };

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

        //assoiciate the listener we create above with our listView
        listView.setOnItemClickListener(myMessageClickHandler);

    }
}
