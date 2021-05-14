package com.example.thigk3_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgClothDt;
    TextView tvNameDt, tvPriceDt;
    Button btn_addtobag;
    Cloth mCloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Anh xa
        imgClothDt = findViewById(R.id.imgCloth_Dt);
        tvNameDt = findViewById(R.id.tvNameDt);
        tvPriceDt = findViewById(R.id.tvPriceDt);
        //bay gio se lay giu lieu tu main 1 gui sang day
        Intent intent = getIntent();
        if (intent != null) {
            mCloth = (Cloth) intent.getSerializableExtra("key1");
            //sau khi nhan xong du lieu thi bay gio se set lai cac Text view, Anh cho main2
            imgClothDt.setImageResource(mCloth.getImgCloth());
            tvPriceDt.setText(mCloth.getPrice()+"$");
            tvNameDt.setText(mCloth.getName());
        }

    }
}