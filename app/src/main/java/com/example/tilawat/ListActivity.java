package com.example.tilawat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tilawat.Data.DatabaseHandler;
import com.example.tilawat.Model.QuranSurah;
import com.example.tilawat.UI.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<QuranSurah> quranSurahList;
    private List<QuranSurah> listItems;
    private DatabaseHandler db;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = new DatabaseHandler(this);
        recyclerView = findViewById(R.id.recycleViewId );
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        quranSurahList = new ArrayList<>();
        listItems = new ArrayList<>();

        // Get items from database
        quranSurahList = db.getAllQuranSurahs();

        for (QuranSurah c : quranSurahList) {
            QuranSurah quranSurah = new QuranSurah();
            quranSurah.setArabic(c.getArabic());
            quranSurah.setLatin(c.getLatin());
            quranSurah.setId(c.getId());



            listItems.add(quranSurah);

        }

        recyclerViewAdapter = new RecyclerViewAdapter(this, listItems);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();


    }


}