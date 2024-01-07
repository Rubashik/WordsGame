package com.example.wordsgame.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wordsgame.database.entity.PlayerEntity;

import java.util.List;

@Dao
public interface PlayerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PlayerEntity player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * FROM player_table ORDER BY score DESC")
    LiveData<List<PlayerEntity>> getOrderedTable();

}
