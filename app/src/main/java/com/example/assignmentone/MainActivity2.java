package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private String selectedItem = null;
    private ListView listView;
    private CaptionedMathAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        selectedItem = getIntent().getStringExtra("selected_item");

        listView = findViewById(R.id.list_item);

        if (selectedItem != null) {
            ArrayList<Math> mathList = null;
            if (selectedItem.equals("Hard")) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                Gson gson = new Gson();
                String str = prefs.getString("hardMath", "");
                Math[] obj = gson.fromJson(str, Math[].class);
                mathList = new ArrayList<>();
                for (Math math : obj) {
                    mathList.add(math);
                }
            } else if (selectedItem.equals("Easy")) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                Gson gson = new Gson();
                String str = prefs.getString("easyMath", "");
                Math[] obj = gson.fromJson(str, Math[].class);
                mathList = new ArrayList<>();
                for (Math math : obj) {
                    mathList.add(math);
                }
            }else if (selectedItem.equals("Medium")) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                Gson gson = new Gson();
                String str = prefs.getString("mediumMath", "");
                Math[] obj = gson.fromJson(str, Math[].class);
                mathList = new ArrayList<>();
                for (Math math : obj) {
                    mathList.add(math);
                }
            }

            if (mathList != null) {
                adapter = new CaptionedMathAdapter(this, mathList);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click if needed
                    }
                });
            }
        }
    }

    public void finish(View v) {
        Intent intentw = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intentw);
    }
}
