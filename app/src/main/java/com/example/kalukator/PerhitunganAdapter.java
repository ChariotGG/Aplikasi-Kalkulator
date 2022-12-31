package com.example.kalukator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerhitunganAdapter extends RecyclerView.Adapter<PerhitunganAdapter.ViewHolder> {
    ArrayList<Perhitungan> listPerhitungan;

    public PerhitunganAdapter(ArrayList<Perhitungan> listPerhitungan) {
        this.listPerhitungan = listPerhitungan;
    }

    @NonNull
    @Override
    public PerhitunganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.record_history, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PerhitunganAdapter.ViewHolder holder, int position){
        Perhitungan perhitungan = listPerhitungan.get(position);
        holder.txtPerhitungan.setText(perhitungan.toString());
        holder.txtHasil.setText(perhitungan.getHasil());
    }

    @Override
    public int getItemCount() {
        return listPerhitungan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPerhitungan,txtHasil;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            txtPerhitungan = itemView.findViewById(R.id.txt_perhitungan);
            txtHasil = itemView.findViewById(R.id.txt_hasil);
        }
    }
}
