package com.example.baitapandroiddonut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgDonutDt;
    TextView tvNameDt, tvPriceDt, tvDesDt, tvSoDt;
    Button btn_addtocart;
    Donut mDonut;
    ImageButton imgbtn_plusDt, imgbtn_minusDt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imgDonutDt = findViewById(R.id.imgDonutDt);
        tvNameDt = findViewById(R.id.tvNameDt);
        tvPriceDt = findViewById(R.id.tvPriceDt);
        tvDesDt = findViewById(R.id.tvDesDt);
        tvSoDt = findViewById(R.id.tvSoDt);
        btn_addtocart = findViewById(R.id.btn_addtocart);
        imgbtn_plusDt = findViewById(R.id.imgbtn_plusDt);
        imgbtn_minusDt = findViewById(R.id.imgbtn_minusDt);
        Intent intent = getIntent();
        if (intent != null){
            mDonut = (Donut) intent.getSerializableExtra("key1");
            tvNameDt.setText(mDonut.getName());
            imgDonutDt.setImageResource(mDonut.getAnh());
            tvPriceDt.setText(mDonut.getPrice()+"");
            tvDesDt.setText(mDonut.getDes());

        }

    }
}