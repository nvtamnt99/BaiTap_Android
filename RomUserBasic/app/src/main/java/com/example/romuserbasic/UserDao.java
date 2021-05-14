package com.example.romuserbasic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addUser(User user);

    @Query("Select * From user")
    List<User> getAllUsers();

    @Delete
    void deleteUser(User user);

    @Query("Select * From user Where userID = :id")
    User getById(Integer id);

}
