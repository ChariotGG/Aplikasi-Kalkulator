package com.example.kalukator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Perhitungan> listPerhitungan;
    private RecyclerView recPerhitungan;
    PerhitunganAdapter adapter;

    EditText edtAngka1, edtAngka2;
    RadioGroup RGroup;
    RadioButton RBtnTambah, RBtnKurang, RBtnKali, RBtnBagi;
    Button btnHitung, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPerhitungan = new ArrayList<>();
        initComponent();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPerhitungan();
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPerhitungan();
            }
        });

    }

    private void initComponent(){
        recPerhitungan =findViewById(R.id.rec_records);
        adapter = new PerhitunganAdapter(listPerhitungan);
        recPerhitungan.setAdapter(adapter);
        recPerhitungan.setLayoutManager(new LinearLayoutManager(this));

        edtAngka1 = findViewById(R.id.edt_angka1);
        edtAngka2 = findViewById(R.id.edt_angka2);

        RGroup = findViewById(R.id.r_group);
        RBtnTambah = findViewById(R.id.rbtn_tambah);
        RBtnKurang = findViewById(R.id.rbtn_kurang);
        RBtnKali = findViewById(R.id.rbtn_kali);
        RBtnBagi = findViewById(R.id.rbtn_bagi);

        btnHitung = findViewById(R.id.btn_hitung);
        btnReset = findViewById(R.id.btn_reset);
    }

    public void resetInput(){
        edtAngka1.setText("");
        edtAngka2.setText("");
    }

    public void resetPerhitungan(){
        resetInput();
        listPerhitungan.clear();
        adapter.notifyDataSetChanged();
    }

    public void addPerhitungan(){
        if(RBtnTambah.isChecked()){
            Perhitungan hitung = new Perhitungan(Double.parseDouble(edtAngka1.getText().toString()), Double.parseDouble(edtAngka2.getText().toString()), 1);
            listPerhitungan.add(hitung);
            adapter.notifyDataSetChanged();
            resetInput();
        }
        else if(RBtnKurang.isChecked()){
            Perhitungan hitung = new Perhitungan(Double.parseDouble(edtAngka1.getText().toString()), Double.parseDouble(edtAngka2.getText().toString()), 2);
            listPerhitungan.add(hitung);
            adapter.notifyDataSetChanged();
            resetInput();
        }
        else if(RBtnKali.isChecked()){
            Perhitungan hitung = new Perhitungan(Double.parseDouble(edtAngka1.getText().toString()), Double.parseDouble(edtAngka2.getText().toString()), 3);
            listPerhitungan.add(hitung);
            adapter.notifyDataSetChanged();
            resetInput();
        }
        else if(RBtnBagi.isChecked()) {
            Perhitungan hitung = new Perhitungan(Double.parseDouble(edtAngka1.getText().toString()), Double.parseDouble(edtAngka2.getText().toString()), 4);
            listPerhitungan.add(hitung);
            adapter.notifyDataSetChanged();
            resetInput();
        }
        else {
            resetInput();
        }
    }
}