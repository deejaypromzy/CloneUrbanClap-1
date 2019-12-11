package com.sundram.urbanclapclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.sundram.urbanclapclone.adapter.ListViewAdapter;
import com.sundram.urbanclapclone.datamodel.ServiceName;

import java.util.ArrayList;

public class WidgetSearch extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] serviceNameList;
    ArrayList<ServiceName> arraylist = new ArrayList<ServiceName>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_search_bar_expanded);

        // Generate sample data

        serviceNameList = new String[]{"Plumber", "Carpenter", "Electrician",
                "Salon at Home", "Cleaning Service", "Pest control service", "Refrigerator Repair", "Microwave epair",
                "Microwave Repair", "Washing machine Service and Repair"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < serviceNameList.length; i++) {
            ServiceName serviceName = new ServiceName(serviceNameList[i]);
            // Binds all strings into an array
            arraylist.add(serviceName);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
            adapter.filter(text);
            list.setVisibility(View.VISIBLE);

        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(WidgetSearch.this, DashBoard.class);
        startActivity(back);
        finish();
    }
}