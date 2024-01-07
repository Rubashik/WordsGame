package com.example.wordsgame.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wordsgame.database.entity.PlayerEntity;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel {
    private PlayerRepository playerRepository;

    private final LiveData<List<PlayerEntity>> allPlayers;


    public PlayerViewModel(@NonNull Application application) {
        super(application);
        playerRepository = new PlayerRepository(application);
        allPlayers = playerRepository.getAllPLayers();
    }

    public LiveData<List<PlayerEntity>> getAllPlayers() {
        return allPlayers;
    }

    public void insert(PlayerEntity player) {playerRepository.insert(player);}
}
