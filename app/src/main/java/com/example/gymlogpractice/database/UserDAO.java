package com.example.gymlogpractice.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gymlogpractice.database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query(" SELECT * FROM " + GymLogDatabase.USER_TABLE + " ORDER BY username")
    LiveData<List<User>> getAllUsers();

    @Query("DELETE FROM " + GymLogDatabase.USER_TABLE)
    void deleteAll();

    @Query("SELECT * FROM " + GymLogDatabase.USER_TABLE + " WHERE username == :username")
    LiveData<User> getUserByUserName(String username);

    @Query((" SELECT * FROM " + GymLogDatabase.USER_TABLE + " Where id = :userId"))
    LiveData<User> getUserByUserId(int userId);
}
