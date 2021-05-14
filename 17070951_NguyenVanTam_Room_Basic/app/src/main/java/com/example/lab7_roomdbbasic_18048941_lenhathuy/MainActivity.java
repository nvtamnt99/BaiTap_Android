package com.example.lab7_roomdbbasic_18048941_lenhathuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    List<User> users;
    CustomAdapter customAdapter;
    AppDatabase db;
    UserDao userDao;
    User obj = null;
    int id = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();
        userDao = db.userDao();
        users = userDao.getAll();
        customAdapter = new CustomAdapter(users,this,R.layout.item_listview1);
        lv = findViewById(R.id.listview);
        lv.setAdapter(customAdapter);

        //Them
        if(users.size() > 0){
            id = idMax(users);
            id++;
        }else{
            id = users.size();
        }
        TextView tvSearch = findViewById(R.id.txtSearch);
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text =  tvSearch.getText().toString();
                if(text.equalsIgnoreCase("") == false){
                    User u = new User(id,text);
                    userDao.insertAll(u);
                    users = userDao.getAll();
                    customAdapter.changeList(users);
                    id++;
                }
            }
        });

        //Hien thi len search
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User u = users.get(i);
                tvSearch.setText(u.getName());
                obj = u;
            }
        });

        //Xoa
        Button btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDao.delete(obj);
                users = userDao.getAll();
                customAdapter.changeList(users);
                obj = null;
                tvSearch.setText("");
            }
        });



    }
    public int idMax(List<User> l){
        int i =0;
        for(User u : l){
            if(i < u.getId()){
                i = u.getId();
            }
        }
        return i;
    }
}