package com.example.a18065341_huynhanhtien_room_custom_listview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "place")
public class Place {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;

    public Place() {
    }

    public Place(String name) {
        this.name = name;
    }

    public Place(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
