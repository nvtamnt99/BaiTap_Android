package com.example.a18065341_huynhanhtien_room_custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private AppDatabase appDatabase;
    private PlaceDao placeDao;
    private ListView lvPlaces;
    private Button btnSave, btnCancel;
    private EditText etPlace;
    private OnClickCustom onDeleteClick;
    private OnClickCustom onUpdateClick;
    private Place selectedPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getInstance(getApplicationContext());
        placeDao = appDatabase.placeDao();

        lvPlaces = findViewById(R.id.lvPlaces);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        etPlace = findViewById(R.id.etPlace);

        onDeleteClick = id -> {
            placeDao.delete(placeDao.getById(id));
            capNhatDuLieu();
        };

        onUpdateClick = id -> {

            selectedPlace = placeDao.getById(id);
            String name = selectedPlace.getName();

            etPlace.setText(name);

        };


        lvPlaces.setAdapter(new PlaceApdater(MainActivity.this, placeDao.getAll(), R.layout.item_layout, onDeleteClick, onUpdateClick));


        btnSave.setOnClickListener(v -> {

            String name = etPlace.getText().toString();

            if(selectedPlace != null) {
                selectedPlace.setName(name);
                placeDao.update(selectedPlace);
                selectedPlace = null;
                etPlace.setText("");

            }
            else{
                Place place = new Place(name);
                placeDao.add(place);

            }

            capNhatDuLieu();
        });

        btnCancel.setOnClickListener(v-> {

            etPlace.setText("");
            selectedPlace = null;
        });





    }

    private  void capNhatDuLieu(){

        lvPlaces.setAdapter(new PlaceApdater(MainActivity.this, placeDao.getAll(), R.layout.item_layout, onDeleteClick, onUpdateClick));
    }
}