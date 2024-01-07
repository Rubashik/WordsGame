package com.example.wordsgame.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.wordsgame.database.dao.PlayerDAO;
import com.example.wordsgame.database.entity.PlayerEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PlayerEntity.class}, version = 1, exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract PlayerDAO playerDAO();

    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                PlayerDAO dao = INSTANCE.playerDAO();

                PlayerEntity player = new PlayerEntity("Hello", 0);
                dao.insert(player);
                player = new PlayerEntity("World", 1);
                dao.insert(player);
            });
        }
    };

    static MyRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MyRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDatabase.class, "player_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
}
