package com.example.wordsgame.database.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player_table")
public class PlayerEntity {
    //PlayerEntity => {name, score}

@PrimaryKey
@NonNull
@ColumnInfo(name = "name")
    private String name;
    private int score;

    public PlayerEntity(@NonNull String name, int score) {
        this.name = name;
        this.score = score;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
