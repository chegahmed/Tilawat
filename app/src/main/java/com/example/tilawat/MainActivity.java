package com.example.tilawat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tilawat.Data.DatabaseHandler;
import com.example.tilawat.Model.QuranSurah;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private List<QuranSurah> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this, ListActivity.class));

        db = new DatabaseHandler(this);
        listItems = new ArrayList<>();
        // Get items from database


        listItems = db.getAllQuranSurahs();

        Log.e("listItems ========== ", String.valueOf(listItems.size()));



        if (listItems.size()==0){

            db.insertAllSourat();

        }else{
            Log.e("listItems ", "already existe");
        }

   }

}