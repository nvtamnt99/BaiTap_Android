package com.example.romuserbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv_user;
    private UserDao userDao;
    List<User> list = new ArrayList<>();
    UserAdapter adapter;
    Button btnAdd, btnRemove, btnCancel;
    EditText editPutName;
    private int deleteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_user = findViewById(R.id.rcv_user);
        list = ConnectDatabase.getInstance(MainActivity.this).userDao().getAllUsers();
        adapter = new UserAdapter(this, list);
        rcv_user.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv_user.setAdapter(adapter);
        btnAdd = findViewById(R.id.btnAdd);
        editPutName = findViewById(R.id.editPutName);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPutName.setText("");
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editPutName.getText().toString();
                ConnectDatabase.getInstance(MainActivity.this).userDao().addUser(new User(name));
                list = ConnectDatabase.getInstance(MainActivity.this).userDao().getAllUsers();
                adapter = new UserAdapter(MainActivity.this, list);
                rcv_user.setAdapter(adapter);
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteId != -1) {
                    userDao.deleteUser(userDao.getById(deleteId));
                }
            }
        });
    }

}