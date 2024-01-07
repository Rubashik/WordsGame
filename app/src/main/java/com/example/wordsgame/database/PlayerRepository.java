package com.example.wordsgame.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.wordsgame.database.dao.PlayerDAO;
import com.example.wordsgame.database.entity.PlayerEntity;

import java.util.List;

public class PlayerRepository {
    private PlayerDAO playerDAO;
    private LiveData<List<PlayerEntity>> allPLayers;

    PlayerRepository(Application application){
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
        playerDAO = db.playerDAO();
        allPLayers = playerDAO.getOrderedTable();
    }

    LiveData<List<PlayerEntity>> getAllPLayers() {
        return allPLayers;
    }

    void insert (PlayerEntity player){
        MyRoomDatabase.databaseWriteExecutor.execute(() -> {
            playerDAO.insert(player);
        });
    }
}
