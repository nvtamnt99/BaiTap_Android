package com.example.thigk3_demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnclickListener {
    ArrayList<Cloth> mCloths;
    RecyclerView rcv_cloth;
    CustomAdapterCloth adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCloths = new ArrayList<>();
        rcv_cloth = findViewById(R.id.rvc_cloth);
        mCloths.add(new Cloth(R.drawable.code, 10,"Google1"));
        mCloths.add(new Cloth(R.drawable.google, 20,"Google2"));
        mCloths.add(new Cloth(R.drawable.android_software_developer, 30,"Google3"));
        mCloths.add(new Cloth(R.drawable.computer, 40,"Google4"));
        mCloths.add(new Cloth(R.drawable.dev, 50,"Google5"));
        mCloths.add(new Cloth(R.drawable.custom_tshirt_1, 60,"Google6"));
        adt = new CustomAdapterCloth(mCloths, this);
        rcv_cloth.setHasFixedSize(true);
        rcv_cloth.setAdapter(adt);
        // layout nam doc xuong
//        rcv_cloth.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //layout nam ngang
//        rcv_cloth.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //layout chia 2 cot
        rcv_cloth.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    public void itemClick(Cloth cloth) {
    // phan nay se la xu ly
        // dau tien se xu ly chuyen man hinh
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        // ok gio se gui du lieu sang
        intent.putExtra("key1", cloth);
        // bay gio se qua main2 de xu ly
        startActivity(intent);
    }
}