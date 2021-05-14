package com.example.baitapandroiddonut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener, TextWatcher {
    RecyclerView rcv_donut;
    CustomAdapterDonut adt;
    ArrayList<Donut> mDonuts;
    EditText edSearch;//3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDonuts = new ArrayList<>();
        rcv_donut = findViewById(R.id.rcv_donut);
        edSearch = findViewById(R.id.edSearch);//3

        edSearch.addTextChangedListener(this);

        mDonuts.add(new Donut(R.drawable.donut_red, "Red donut","Donut famlily fnt", 10, R.drawable.vector));
        mDonuts.add(new Donut(R.drawable.donut_yellow, "Donut yellow","Donut famlily fnt", 20, R.drawable.vector));
        mDonuts.add(new Donut(R.drawable.green_donut, "green donut","Donut famlily fnt", 30, R.drawable.vector));
        mDonuts.add(new Donut(R.drawable.pink_donut, "black pink donut","Donut famlily fnt", 50, R.drawable.vector));
        mDonuts.add(new Donut(R.drawable.tasty_donut, "tasty donut","Donut famlily fnt", 100, R.drawable.vector));


        adt = new CustomAdapterDonut(mDonuts, this);
        rcv_donut.setHasFixedSize(true);
        rcv_donut.setAdapter(adt);
        rcv_donut.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void itemClick(Donut donut) {//2
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key1", donut);
        startActivity(intent);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());
    }

    private void filter(String toString) {
        ArrayList<Donut> donuts;
        donuts = new ArrayList<>();
        for (Donut d:mDonuts){
            if (d.getName().toLowerCase().contains(toString.toLowerCase())){
                donuts.add(d);
            }
        }
        adt.filterList(donuts);
    }
}