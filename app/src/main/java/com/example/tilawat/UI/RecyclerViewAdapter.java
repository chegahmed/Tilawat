package com.example.tilawat.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tilawat.DetailActivity;
import com.example.tilawat.ListActivity;
import com.example.tilawat.Model.QuranSurah;
import com.example.tilawat.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<QuranSurah> quranSurahItems;

    public RecyclerViewAdapter(Context context, List<QuranSurah> quranSurahItems) {
        this.context = context;
        this.quranSurahItems = quranSurahItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        QuranSurah quranSurah = quranSurahItems.get(position);

        holder.arabic.setText(quranSurah.getArabic());
        holder.latin.setText(quranSurah.getLatin());

    }

    @Override
    public int getItemCount() {
        return quranSurahItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView arabic;
        public TextView latin;

        public ViewHolder(@NonNull View view, Context ctx) {
            super(view);
            context = ctx;

            arabic = (TextView) view.findViewById(R.id.name_arabic);
            latin = (TextView) view.findViewById(R.id.name_latin);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to next screen/ DetailsActivity
                    int position = getAdapterPosition();

                    QuranSurah grocery = quranSurahItems.get(position);
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("arabic", grocery.getArabic());
                    intent.putExtra("latin", grocery.getLatin());

                    context.startActivity(intent);

                }
            });

        }

        @Override
        public void onClick(View view) {

        }
    }

}
