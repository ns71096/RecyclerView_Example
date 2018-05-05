package com.niksharma.practice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    String[] movie = {
            "Ki and Ka",
            "Tere Bin Laden",
            "Neerja",
            "Rocky Handsome",
            "Kyaa Kool Hain Hum 3",
            "Airlift",
            "Dilwale",
            "Ghayal"
    };
    String[] actors = {
            "Arjun Kapoor and Kareena Kapoor",
            "Manish Paul",
            "Sonam Kapoor",
            "John Abraham",
            "Aftab Shivdasani and Tusshar Kapoor",
            "Akshay Kumar",
            "Shah Rukh Khan,Varun Dhawan,Kriti sanon and Kajol"
            , "Sunny Deol"
    };
    int[] images = {
            R.drawable.ki, R.drawable.tere, R.drawable.neerja,
            R.drawable.rocky, R.drawable.kyaa, R.drawable.airlift, R.drawable.dilwale, R.drawable.ghayal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(MainActivity.this,movie,actors,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("info", "onPause() called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("info", "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("info", "onStart() called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("info", "onDestroy() called.");
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Confirm");
        alert.setMessage("DO you want to exit?");
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });

        alert.show();


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("info", "onStop() called.");
    }

}
